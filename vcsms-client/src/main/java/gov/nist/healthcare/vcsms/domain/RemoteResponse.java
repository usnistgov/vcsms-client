package gov.nist.healthcare.vcsms.domain;

import java.io.InputStream;

public class RemoteResponse {
	
	private boolean status;
	private String message;
	private boolean changed;
	private InputStream resource;
	
	public RemoteResponse(boolean status, String name, boolean changed, InputStream resource) {
		super();
		this.status = status;
		this.message = name;
		this.changed = changed;
		this.resource = resource;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getName() {
		return message;
	}
	public void setName(String name) {
		this.message = name;
	}
	public boolean isChanged() {
		return changed;
	}
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	public InputStream getResource() {
		return resource;
	}
	public void setResource(InputStream resource) {
		this.resource = resource;
	}
	
}
