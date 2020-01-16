package gov.nist.healthcare.vcsms.domain;

public class ClientConfiguration {
	
	private String protocol;
	private String root;
	private String groupMnemonic;
	private String nodeID;
	private String ftpHost;
	private String ftpUserName;
	private String ftpUserPassword;
	
	public ClientConfiguration(String protocol, String root, String groupMnemonic, String nodeID, String ftpHost, String ftpUserName,
			String ftpUserPassword) {
		super();
		this.protocol = protocol;
		this.root = root;
		this.groupMnemonic = groupMnemonic;
		this.nodeID = nodeID;
		this.ftpHost = ftpHost;
		this.ftpUserName = ftpUserName;
		this.ftpUserPassword = ftpUserPassword;
	}
	
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getGroupMnemonic() {
		return groupMnemonic;
	}
	public void setGroupMnemonic(String groupMnemonic) {
		this.groupMnemonic = groupMnemonic;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getFtpHost() {
		return ftpHost;
	}
	public void setFtpHost(String ftpHost) {
		this.ftpHost = ftpHost;
	}
	public String getFtpUserName() {
		return ftpUserName;
	}
	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}
	public String getFtpUserPassword() {
		return ftpUserPassword;
	}
	public void setFtpUserPassword(String ftpUserPassword) {
		this.ftpUserPassword = ftpUserPassword;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

}
