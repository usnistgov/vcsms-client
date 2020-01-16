package gov.nist.healthcare.vcsms.domain;

public class DistributionDownloadStatusRequest {
	
	private String distributionGroupMnemonic;
	private String distributionPackageUID;
	private int downloadStateID;
	private String statusMessage;
	
	
	public DistributionDownloadStatusRequest(String distributionGroupMnemonic, String distributionPackageUID,
			int downloadStateID, String statusMessage) {
		super();
		this.distributionGroupMnemonic = distributionGroupMnemonic;
		this.distributionPackageUID = distributionPackageUID;
		this.downloadStateID = downloadStateID;
		this.statusMessage = statusMessage;
	}
	
	public DistributionDownloadStatusRequest() {
		super();
	}

	public String getDistributionGroupMnemonic() {
		return distributionGroupMnemonic;
	}
	public void setDistributionGroupMnemonic(String distributionGroupMnemonic) {
		this.distributionGroupMnemonic = distributionGroupMnemonic;
	}
	public String getDistributionPackageUID() {
		return distributionPackageUID;
	}
	public void setDistributionPackageUID(String distributionPackageUID) {
		this.distributionPackageUID = distributionPackageUID;
	}
	public int getDownloadStateID() {
		return downloadStateID;
	}
	public void setDownloadStateID(int downloadStateID) {
		this.downloadStateID = downloadStateID;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
