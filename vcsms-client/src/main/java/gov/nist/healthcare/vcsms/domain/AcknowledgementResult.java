package gov.nist.healthcare.vcsms.domain;

public class AcknowledgementResult {
	
	protected boolean isGood;
	protected String message;
	
	public AcknowledgementResult(boolean isGood, String message) {
		super();
		this.isGood = isGood;
		this.message = message;
	}
	
	public AcknowledgementResult() {
		super();
	}

	public boolean isIsGood() {
		return isGood;
	}
	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
