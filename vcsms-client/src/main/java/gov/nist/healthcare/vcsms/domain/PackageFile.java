package gov.nist.healthcare.vcsms.domain;

public class PackageFile {
	
	private String packageName;
	private long packageSize;
	private String packageHash;
	private String distributionPackageUID;
	private boolean isFullPackage;
	private String serviceProperties;
	
	public PackageFile(String packageName, long packageSize, String packageHash, String distributionPackageUID,
			boolean isFullPackage, String serviceProperties) {
		super();
		this.packageName = packageName;
		this.packageSize = packageSize;
		this.packageHash = packageHash;
		this.distributionPackageUID = distributionPackageUID;
		this.isFullPackage = isFullPackage;
		this.serviceProperties = serviceProperties;
	}
		
	public PackageFile() {
		super();
	}

	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public long getPackageSize() {
		return packageSize;
	}
	public void setPackageSize(long packageSize) {
		this.packageSize = packageSize;
	}
	public String getPackageHash() {
		return packageHash;
	}
	public void setPackageHash(String packageHash) {
		this.packageHash = packageHash;
	}
	public String getDistributionPackageUID() {
		return distributionPackageUID;
	}
	public void setDistributionPackageUID(String distributionPackageUID) {
		this.distributionPackageUID = distributionPackageUID;
	}
	public boolean isFullPackage() {
		return isFullPackage;
	}
	public void setFullPackage(boolean isFullPackage) {
		this.isFullPackage = isFullPackage;
	}
	public String getServiceProperties() {
		return serviceProperties;
	}
	public void setServiceProperties(String serviceProperties) {
		this.serviceProperties = serviceProperties;
	}
	
	

}
