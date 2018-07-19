package gov.nist.healthcare.vcsms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import gov.nist.healthcare.vcsms.domain.ClientConfiguration;
import gov.nist.healthcare.vcsms.domain.DistributionAvailableRequestStatus;
import gov.nist.healthcare.vcsms.domain.DistributionDownloadStatusRequest;
import gov.nist.healthcare.vcsms.domain.DistributionPackageListItem;
import gov.nist.healthcare.vcsms.domain.DistributionPendingDownloadRequestStatus;
import gov.nist.healthcare.vcsms.domain.DistributionRequestStatus;
import gov.nist.healthcare.vcsms.domain.DistributionSubscribeRequest;
import gov.nist.healthcare.vcsms.domain.PackageFile;
import gov.nist.healthcare.vcsms.domain.RESTClientInfo;
import gov.nist.healthcare.vcsms.domain.RemoteResponse;
import gov.nist.healthcare.vcsms.exception.ResourceNotFoundException;
import gov.nist.healthcare.vcsms.service.NISTVCSMSClient;
import gov.nist.healthcare.vcsms.service.VCSMSClient;
import gov.nist.healthcare.vcsms.service.VCSMSFTPClient;

public class NISTVCSMSClientImpl implements NISTVCSMSClient {

	private ClientConfiguration configuration;
	private RESTClientInfo clientInfo;
	private VCSMSClient vcsmsClient;
	private VCSMSFTPClient vcsmsFtpClient;
	private String storage;
	
	public NISTVCSMSClientImpl(ClientConfiguration configuration, RESTClientInfo clientInfo, String storage) {
		super();
		this.configuration = configuration;
		this.storage = storage;
		this.clientInfo = clientInfo;
		this.vcsmsClient = new VCSMSClientImpl(configuration);
		this.vcsmsFtpClient = new VCSMSFTPClientImpl(configuration);
	}

	public RemoteResponse checkResource(String resourceID) throws ResourceNotFoundException {
		DistributionAvailableRequestStatus availablePackages = this.vcsmsClient.getAllAvailablePackageLists();
		if(availablePackages.getPackageItems() != null && availablePackages.getPackageItems().size() > 0){
			DistributionPackageListItem item = this.findPackageItem(availablePackages.getPackageItems(), resourceID);
			if(item == null){
				throw new ResourceNotFoundException(resourceID);
			}
			else {
				if(!item.isPackageTemplateIsSubscribed()){
					return this.subscribeAndFetchAndAcknowledge(resourceID);
				}
				else {
					return this.fetchAndAcknowledge(resourceID);
				}
			}
		}
		else {
			return new RemoteResponse(false, availablePackages.getMessage(), false, null);
		}		
	}

	public ClientConfiguration getConfiguration() {
		return configuration;
	}	
	
	
	
	private RemoteResponse subscribeAndFetchAndAcknowledge(String resourceID){
		DistributionRequestStatus requestStatus = subscribe(resourceID);
		if(requestStatus.isIsGood()){
			return this.fetchAndAcknowledge(resourceID);
		}
		else {
			return new RemoteResponse(false, requestStatus.getMessage(), false, null);
		}
	}
	
	private RemoteResponse fetchAndAcknowledge(String resourceID){
		try {
			RemoteResponse response = this.fetch(resourceID);
			this.acknowledge(resourceID, true, "success");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			this.acknowledge(resourceID, false, e.getMessage());
			return new RemoteResponse(false, e.getMessage(), false, null);
		}
	}
	
	private DistributionRequestStatus subscribe(String resourceID){
		DistributionSubscribeRequest subscribeRequest = new DistributionSubscribeRequest(this.configuration.getGroupMnemonic(), this.configuration.getNodeID(), resourceID, this.configuration.getFtpUserName());
		return this.vcsmsClient.postPackageSubscribe(subscribeRequest);
	}
	
	private RemoteResponse fetch(String resourceID) throws IOException {
		DistributionPendingDownloadRequestStatus pendingDownloadRequestStatus = this.vcsmsClient.postPendingDownloadPackages(this.clientInfo);
		PackageFile file = this.findPackageFile(pendingDownloadRequestStatus.getPackages(), resourceID);
		if(file != null){
			File f = this.vcsmsFtpClient.fetch(file.getPackageName(), this.storage + "/" + resourceID);
			return new RemoteResponse(true, "Updated", true, new FileInputStream(f));
		}
		else {
			return new RemoteResponse(true, "Up to date", false, null);
		}
	}
	
	private void acknowledge(String resourceID, boolean status, String message){
		DistributionDownloadStatusRequest request = new DistributionDownloadStatusRequest(this.configuration.getGroupMnemonic(), resourceID, status ? 1 : 0, message);
		this.vcsmsClient.postPackageDownloadState(request);
	}

	private DistributionPackageListItem findPackageItem(List<DistributionPackageListItem> list, String UID){
		if(list == null) return null;
		return list.stream().filter(packageItem -> {
			return packageItem.getPackageUID().equals(UID);
		})
		.findFirst().orElse(null);
	}
	
	private PackageFile findPackageFile(List<PackageFile> list, String UID){
		if(list == null) return null;
		return list.stream().filter(packageFile -> {
			return packageFile.getDistributionPackageUID().equals(UID);
		})
		.findFirst().orElse(null);
	}
}
