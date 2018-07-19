package gov.nist.healthcare.vcsms.domain;

import java.util.List;

public class DistributionPendingDownloadRequestStatus extends AcknowledgementResult {

	private String serverMnemonic;
	private List<PackageFile> packages;
	
	
	
	public DistributionPendingDownloadRequestStatus() {
		super();
	}

	public DistributionPendingDownloadRequestStatus(boolean isGood, String message, String serverMnemonic,
			List<PackageFile> packages) {
		super(isGood, message);
		this.serverMnemonic = serverMnemonic;
		this.packages = packages;
	}
		

	public String getServerMnemonic() {
		return serverMnemonic;
	}
	public void setServerMnemonic(String serverMnemonic) {
		this.serverMnemonic = serverMnemonic;
	}
	public List<PackageFile> getPackages() {
		return packages;
	}
	public void setPackages(List<PackageFile> packages) {
		this.packages = packages;
	}
	
	
}
