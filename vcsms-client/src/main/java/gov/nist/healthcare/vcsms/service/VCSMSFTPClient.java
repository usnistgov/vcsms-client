package gov.nist.healthcare.vcsms.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface VCSMSFTPClient {

	public File fetch(String filename, String location) throws IOException;
	public InputStream fetchStream(String filename) throws IOException;
	public String getLatestFileContent(String packageTemplateName) throws IOException;
	public String getValuesetString(String packageTemplateName) throws IOException;
	
}
