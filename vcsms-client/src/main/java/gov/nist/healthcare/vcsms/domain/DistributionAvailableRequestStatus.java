package gov.nist.healthcare.vcsms.domain;

import java.util.List;

public class DistributionAvailableRequestStatus extends AcknowledgementResult {
	
	private List<DistributionPackageListItem> packageItems;
	
	
	public DistributionAvailableRequestStatus() {
		super();
	}
	
	public DistributionAvailableRequestStatus(boolean isGood, String message,
			List<DistributionPackageListItem> packageItems) {
		super(isGood, message);
		this.packageItems = packageItems;
	}

	public List<DistributionPackageListItem> getPackageItems() {
		return packageItems;
	}
	public void setPackageItems(List<DistributionPackageListItem> packageItems) {
		this.packageItems = packageItems;
	}
	
	
}
