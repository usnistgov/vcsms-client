package gov.nist.healthcare.vcsms.domain;

public class DistributionPackageTemplateLicensing {
	
	private String requirement;
	private String description;
	private boolean approvalRequired;
	private boolean hasLicensor;
	private String licensorName;
	private String licensorDescription;
	private String licensorTermsOfUseURL;
	private boolean isThirdPartyLicensor;
	private int licenseAgreementID;
	private String licenseAgreementText;
	

	public DistributionPackageTemplateLicensing(String requirement, String description, boolean approvalRequired,
			boolean hasLicensor, String licensorName, String licensorDescription, String licensorTermsOfUseURL,
			boolean isThirdPartyLicensor, int licenseAgreementID, String licenseAgreementText) {
		super();
		this.requirement = requirement;
		this.description = description;
		this.approvalRequired = approvalRequired;
		this.hasLicensor = hasLicensor;
		this.licensorName = licensorName;
		this.licensorDescription = licensorDescription;
		this.licensorTermsOfUseURL = licensorTermsOfUseURL;
		this.isThirdPartyLicensor = isThirdPartyLicensor;
		this.licenseAgreementID = licenseAgreementID;
		this.licenseAgreementText = licenseAgreementText;
	}
	
	public DistributionPackageTemplateLicensing() {
		super();
	}

	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isApprovalRequired() {
		return approvalRequired;
	}
	public void setApprovalRequired(boolean approvalRequired) {
		this.approvalRequired = approvalRequired;
	}
	public boolean isHasLicensor() {
		return hasLicensor;
	}
	public void setHasLicensor(boolean hasLicensor) {
		this.hasLicensor = hasLicensor;
	}
	public String getLicensorName() {
		return licensorName;
	}
	public void setLicensorName(String licensorName) {
		this.licensorName = licensorName;
	}
	public String getLicensorDescription() {
		return licensorDescription;
	}
	public void setLicensorDescription(String licensorDescription) {
		this.licensorDescription = licensorDescription;
	}
	public String getLicensorTermsOfUseURL() {
		return licensorTermsOfUseURL;
	}
	public void setLicensorTermsOfUseURL(String licensorTermsOfUseURL) {
		this.licensorTermsOfUseURL = licensorTermsOfUseURL;
	}
	public boolean isThirdPartyLicensor() {
		return isThirdPartyLicensor;
	}
	public void setThirdPartyLicensor(boolean isThirdPartyLicensor) {
		this.isThirdPartyLicensor = isThirdPartyLicensor;
	}
	public int getLicenseAgreementID() {
		return licenseAgreementID;
	}
	public void setLicenseAgreementID(int licenseAgreementID) {
		this.licenseAgreementID = licenseAgreementID;
	}
	public String getLicenseAgreementText() {
		return licenseAgreementText;
	}
	public void setLicenseAgreementText(String licenseAgreementText) {
		this.licenseAgreementText = licenseAgreementText;
	}
	
}
