package gov.nist.healthcare.vcsms.domain;

public class DistributionSubscribeRequest {
	
	private String distributionGroupMnemonic;
	private String distributionNodeUID;
	private String distributionPackageUID;
	private String userName;
	
	public DistributionSubscribeRequest(String distributionGroupMnemonic, String distributionNodeUID,
			String distributionPackageUID, String userName) {
		super();
		this.distributionGroupMnemonic = distributionGroupMnemonic;
		this.distributionNodeUID = distributionNodeUID;
		this.distributionPackageUID = distributionPackageUID;
		this.userName = userName;
	}
	
	public DistributionSubscribeRequest() {
		super();
	}

	public String getDistributionGroupMnemonic() {
		return distributionGroupMnemonic;
	}
	public void setDistributionGroupMnemonic(String distributionGroupMnemonic) {
		this.distributionGroupMnemonic = distributionGroupMnemonic;
	}
	public String getDistributionNodeUID() {
		return distributionNodeUID;
	}
	public void setDistributionNodeUID(String distributionNodeUID) {
		this.distributionNodeUID = distributionNodeUID;
	}
	public String getDistributionPackageUID() {
		return distributionPackageUID;
	}
	public void setDistributionPackageUID(String distributionPackageUID) {
		this.distributionPackageUID = distributionPackageUID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
