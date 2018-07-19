package gov.nist.healthcare.vcsms.domain;

public class DistributionRequestStatus extends AcknowledgementResult {

	private String stackTrace;
	
	public DistributionRequestStatus(boolean isGood, String message, String stackTrace) {
		super(isGood, message);
		this.stackTrace = stackTrace;
	}
		
	public DistributionRequestStatus() {
		super();
	}

	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	
	
}
