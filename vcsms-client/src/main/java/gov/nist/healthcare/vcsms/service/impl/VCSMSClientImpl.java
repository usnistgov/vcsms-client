package gov.nist.healthcare.vcsms.service.impl;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.nist.healthcare.vcsms.domain.ClientConfiguration;
import gov.nist.healthcare.vcsms.domain.DistributionApplyStatusRequest;
import gov.nist.healthcare.vcsms.domain.DistributionAvailableRequestStatus;
import gov.nist.healthcare.vcsms.domain.DistributionDownloadStatusRequest;
import gov.nist.healthcare.vcsms.domain.DistributionPendingDownloadRequestStatus;
import gov.nist.healthcare.vcsms.domain.DistributionRequestStatus;
import gov.nist.healthcare.vcsms.domain.DistributionSubscribeRequest;
import gov.nist.healthcare.vcsms.domain.RESTClientInfo;
import gov.nist.healthcare.vcsms.service.VCSMSClient;

public class VCSMSClientImpl implements VCSMSClient {

	private ClientConfiguration configuration;
	private RestTemplate wire;
	public final String ALL_AVAILABLE_PACKAGE_LISTS = "%s://%s/available/%s";
	public final String PACKAGE_APPLY_STATE = "%s://%s/applystate";
	public final String PACKAGE_DOWNLOAD_STATE = "%s://%s/downloadstate";
	public final String PACKAGE_SUBSCRIBE = "%s://%s/subscribe";
	public final String PACKAGE_UNSUBSCRIBE = "%s://%s/unsubscribe";
	public final String POST_PENDING_DOWNLOAD_PACKAGES = "%s://%s/pending/%s";
	
	
	public VCSMSClientImpl(ClientConfiguration configuration) {
		super();
		this.configuration = configuration;
		this.wire = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		.setPropertyNamingStrategy(new MyNameStrategy());
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setPrettyPrint(false);
		messageConverter.setObjectMapper(mapper);
		wire.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
		wire.getMessageConverters().add(messageConverter);
	}

	public DistributionAvailableRequestStatus getAllAvailablePackageLists() {
		System.out.println(getURL(ALL_AVAILABLE_PACKAGE_LISTS));
		return wire.getForObject(getURL(ALL_AVAILABLE_PACKAGE_LISTS), DistributionAvailableRequestStatus.class);
	}

	public DistributionRequestStatus postPackageApplyState(DistributionApplyStatusRequest distributionApplyStatusRequest) {
		return wire.postForObject(getURL(PACKAGE_APPLY_STATE), distributionApplyStatusRequest, DistributionRequestStatus.class);
	}

	public DistributionRequestStatus postPackageDownloadState(DistributionDownloadStatusRequest distributionDownloadStatusRequest) {
		return wire.postForObject(getURL(PACKAGE_DOWNLOAD_STATE), distributionDownloadStatusRequest, DistributionRequestStatus.class);
	}

	public DistributionRequestStatus postPackageSubscribe(DistributionSubscribeRequest distributionSubscribeRequest) {
		return wire.postForObject(getURL(PACKAGE_SUBSCRIBE), distributionSubscribeRequest, DistributionRequestStatus.class);
	}

	public DistributionRequestStatus postPackageUnsubscribe(DistributionSubscribeRequest distributionSubscribeRequest) {
		System.out.println(getURL(PACKAGE_UNSUBSCRIBE));
		return wire.postForObject(getURL(PACKAGE_UNSUBSCRIBE), distributionSubscribeRequest, DistributionRequestStatus.class);
	}

	public DistributionPendingDownloadRequestStatus postPendingDownloadPackages(RESTClientInfo requestClientInfo) {
		System.out.println(getURL(POST_PENDING_DOWNLOAD_PACKAGES));
		return wire.postForObject(getURL(POST_PENDING_DOWNLOAD_PACKAGES), requestClientInfo, DistributionPendingDownloadRequestStatus.class);
	}
	
	private String getURL(String str){
		return String.format(str, configuration.getProtocol(), configuration.getRoot(), configuration.getGroupMnemonic());
	}

	public ClientConfiguration getConfiguration() {
		return configuration;
	}
	

}
