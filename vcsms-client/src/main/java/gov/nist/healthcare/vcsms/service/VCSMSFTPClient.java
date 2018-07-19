package gov.nist.healthcare.vcsms.service;

import java.io.File;
import java.io.IOException;

public interface VCSMSFTPClient {

	public File fetch(String filename, String location) throws IOException;
	
}
