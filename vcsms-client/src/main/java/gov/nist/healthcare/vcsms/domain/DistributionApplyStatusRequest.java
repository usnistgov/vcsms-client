package gov.nist.healthcare.vcsms.domain;

public class DistributionApplyStatusRequest {

	private String distributionNodeUID;
	private String distributionPackageUID;
	private String applyStateID;
	private String statusMessage;
	
	
	
	public DistributionApplyStatusRequest() {
		super();
	}

	public DistributionApplyStatusRequest(String distributionNodeUID, String distributionPackageUID,
			String applyStateID, String statusMessage) {
		super();
		this.distributionNodeUID = distributionNodeUID;
		this.distributionPackageUID = distributionPackageUID;
		this.applyStateID = applyStateID;
		this.statusMessage = statusMessage;
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
	public String getApplyStateID() {
		return applyStateID;
	}
	public void setApplyStateID(String applyStateID) {
		this.applyStateID = applyStateID;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
	
}
