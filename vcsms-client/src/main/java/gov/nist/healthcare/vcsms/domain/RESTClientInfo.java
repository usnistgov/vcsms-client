package gov.nist.healthcare.vcsms.domain;

public class RESTClientInfo {
	
	private String clientSoftwareVersion;
	private String clientMachineInfo;

	public RESTClientInfo(String clientSoftwareVersion, String clientMachineInfo) {
		super();
		this.clientSoftwareVersion = clientSoftwareVersion;
		this.clientMachineInfo = clientMachineInfo;
	}
		
	public RESTClientInfo() {
		super();
	}

	public String getClientSoftwareVersion() {
		return clientSoftwareVersion;
	}
	public void setClientSoftwareVersion(String clientSoftwareVersion) {
		this.clientSoftwareVersion = clientSoftwareVersion;
	}
	public String getClientMachineInfo() {
		return clientMachineInfo;
	}
	public void setClientMachineInfo(String clientMachineInfo) {
		this.clientMachineInfo = clientMachineInfo;
	}
	
}
