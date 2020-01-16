package gov.nist.healthcare.vcsms.domain;


public class DistributionPackageListItem {

	private String serverMnemonic;
	private String servername;
	private String listUID;
	private String listName;
	private String packageUID;
	private String packagePublishDate;
	private String packageFileName;
	private boolean packageApprovedToSubscribe;
	private boolean packageDownloadIsDisabled;
	private String packageComment;
	private String packageSize;
	private boolean packageTemplateAutoApprove;
	private String packageTemplateUID;
	private String packageTemplateDescription;
	private String packageTemplateSearchKeywords;
	private String packageTemplateDomain;
	private String packageTemplateFrequency;
	private DistributionPackageTemplateLicensing packageTemplateLicensing;
	private boolean packageTemplateRequiresApprovalToSubscibe;
	private boolean packageTemplateIsSubscribed;
	private String packageTemplateName;
	private String packageTemplateSourceName;
	private String packageTemplateVersion;
	private int packageTypeID;
	private int packageStatusID;
	private String packageApplyDate;
	private String packageApplyVersion;
	
	
	
	
	public DistributionPackageListItem(String serverMnemonic, String servername, String listUID, String listName,
			String packageUID, String packagePublishDate, String packageFileName, boolean packageApprovedToSubscribe,
			boolean packageDownloadIsDisabled, String packageComment, String packageSize,
			boolean packageTemplateAutoApprove, String packageTemplateUID, String packageTemplateDescription,
			String packageTemplateSearchKeywords, String packageTemplateDomain, String packageTemplateFrequency,
			DistributionPackageTemplateLicensing packageTemplateLicensing,
			boolean packageTemplateRequiresApprovalToSubscibe, boolean packageTemplateIsSubscribed,
			String packageTemplateName, String packageTemplateSourceName, String packageTemplateVersion,
			int packageTypeID, int packageStatusID, String packageApplyDate, String packageApplyVersion) {
		super();
		this.serverMnemonic = serverMnemonic;
		this.servername = servername;
		this.listUID = listUID;
		this.listName = listName;
		this.packageUID = packageUID;
		this.packagePublishDate = packagePublishDate;
		this.packageFileName = packageFileName;
		this.packageApprovedToSubscribe = packageApprovedToSubscribe;
		this.packageDownloadIsDisabled = packageDownloadIsDisabled;
		this.packageComment = packageComment;
		this.packageSize = packageSize;
		this.packageTemplateAutoApprove = packageTemplateAutoApprove;
		this.packageTemplateUID = packageTemplateUID;
		this.packageTemplateDescription = packageTemplateDescription;
		this.packageTemplateSearchKeywords = packageTemplateSearchKeywords;
		this.packageTemplateDomain = packageTemplateDomain;
		this.packageTemplateFrequency = packageTemplateFrequency;
		this.packageTemplateLicensing = packageTemplateLicensing;
		this.packageTemplateRequiresApprovalToSubscibe = packageTemplateRequiresApprovalToSubscibe;
		this.packageTemplateIsSubscribed = packageTemplateIsSubscribed;
		this.packageTemplateName = packageTemplateName;
		this.packageTemplateSourceName = packageTemplateSourceName;
		this.packageTemplateVersion = packageTemplateVersion;
		this.packageTypeID = packageTypeID;
		this.packageStatusID = packageStatusID;
		this.packageApplyDate = packageApplyDate;
		this.packageApplyVersion = packageApplyVersion;
	}
	
		
	public DistributionPackageListItem() {
		super();
	}

	public String getServerMnemonic() {
		return serverMnemonic;
	}
	public void setServerMnemonic(String serverMnemonic) {
		this.serverMnemonic = serverMnemonic;
	}
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	public String getListUID() {
		return listUID;
	}
	public void setListUID(String listUID) {
		this.listUID = listUID;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getPackageUID() {
		return packageUID;
	}
	public void setPackageUID(String packageUID) {
		this.packageUID = packageUID;
	}
	public String getPackagePublishDate() {
		return packagePublishDate;
	}
	public void setPackagePublishDate(String packagePublishDate) {
		this.packagePublishDate = packagePublishDate;
	}
	public String getPackageFileName() {
		return packageFileName;
	}
	public void setPackageFileName(String packageFileName) {
		this.packageFileName = packageFileName;
	}
	public boolean isPackageApprovedToSubscribe() {
		return packageApprovedToSubscribe;
	}
	public void setPackageApprovedToSubscribe(boolean packageApprovedToSubscribe) {
		this.packageApprovedToSubscribe = packageApprovedToSubscribe;
	}
	public boolean isPackageDownloadIsDisabled() {
		return packageDownloadIsDisabled;
	}
	public void setPackageDownloadIsDisabled(boolean packageDownloadIsDisabled) {
		this.packageDownloadIsDisabled = packageDownloadIsDisabled;
	}
	public String getPackageComment() {
		return packageComment;
	}
	public void setPackageComment(String packageComment) {
		this.packageComment = packageComment;
	}
	public String getPackageSize() {
		return packageSize;
	}
	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}
	public boolean isPackageTemplateAutoApprove() {
		return packageTemplateAutoApprove;
	}
	public void setPackageTemplateAutoApprove(boolean packageTemplateAutoApprove) {
		this.packageTemplateAutoApprove = packageTemplateAutoApprove;
	}
	public String getPackageTemplateUID() {
		return packageTemplateUID;
	}
	public void setPackageTemplateUID(String packageTemplateUID) {
		this.packageTemplateUID = packageTemplateUID;
	}
	public String getPackageTemplateDescription() {
		return packageTemplateDescription;
	}
	public void setPackageTemplateDescription(String packageTemplateDescription) {
		this.packageTemplateDescription = packageTemplateDescription;
	}
	public String getPackageTemplateSearchKeywords() {
		return packageTemplateSearchKeywords;
	}
	public void setPackageTemplateSearchKeywords(String packageTemplateSearchKeywords) {
		this.packageTemplateSearchKeywords = packageTemplateSearchKeywords;
	}
	public String getPackageTemplateDomain() {
		return packageTemplateDomain;
	}
	public void setPackageTemplateDomain(String packageTemplateDomain) {
		this.packageTemplateDomain = packageTemplateDomain;
	}
	public String getPackageTemplateFrequency() {
		return packageTemplateFrequency;
	}
	public void setPackageTemplateFrequency(String packageTemplateFrequency) {
		this.packageTemplateFrequency = packageTemplateFrequency;
	}
	public DistributionPackageTemplateLicensing getPackageTemplateLicensing() {
		return packageTemplateLicensing;
	}
	public void setPackageTemplateLicensing(DistributionPackageTemplateLicensing packageTemplateLicensing) {
		this.packageTemplateLicensing = packageTemplateLicensing;
	}
	public boolean isPackageTemplateRequiresApprovalToSubscibe() {
		return packageTemplateRequiresApprovalToSubscibe;
	}
	public void setPackageTemplateRequiresApprovalToSubscibe(boolean packageTemplateRequiresApprovalToSubscibe) {
		this.packageTemplateRequiresApprovalToSubscibe = packageTemplateRequiresApprovalToSubscibe;
	}
	public boolean isPackageTemplateIsSubscribed() {
		return packageTemplateIsSubscribed;
	}
	public void setPackageTemplateIsSubscribed(boolean packageTemplateIsSubscribed) {
		this.packageTemplateIsSubscribed = packageTemplateIsSubscribed;
	}
	public String getPackageTemplateName() {
		return packageTemplateName;
	}
	public void setPackageTemplateName(String packageTemplateName) {
		this.packageTemplateName = packageTemplateName;
	}
	public String getPackageTemplateSourceName() {
		return packageTemplateSourceName;
	}
	public void setPackageTemplateSourceName(String packageTemplateSourceName) {
		this.packageTemplateSourceName = packageTemplateSourceName;
	}
	public String getPackageTemplateVersion() {
		return packageTemplateVersion;
	}
	public void setPackageTemplateVersion(String packageTemplateVersion) {
		this.packageTemplateVersion = packageTemplateVersion;
	}
	public int getPackageTypeID() {
		return packageTypeID;
	}
	public void setPackageTypeID(int packageTypeID) {
		this.packageTypeID = packageTypeID;
	}
	public int getPackageStatusID() {
		return packageStatusID;
	}
	public void setPackageStatusID(int packageStatusID) {
		this.packageStatusID = packageStatusID;
	}
	public String getPackageApplyDate() {
		return packageApplyDate;
	}
	public void setPackageApplyDate(String packageApplyDate) {
		this.packageApplyDate = packageApplyDate;
	}
	public String getPackageApplyVersion() {
		return packageApplyVersion;
	}
	public void setPackageApplyVersion(String packageApplyVersion) {
		this.packageApplyVersion = packageApplyVersion;
	}
	
	
}
