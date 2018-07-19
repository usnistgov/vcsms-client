package gov.nist.healthcare.vcsms.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.net.ftp.FTPClient;

import gov.nist.healthcare.vcsms.domain.ClientConfiguration;
import gov.nist.healthcare.vcsms.service.VCSMSFTPClient;

public class VCSMSFTPClientImpl implements VCSMSFTPClient {

	private ClientConfiguration configuration;
	private FTPClient ftp;
		
	public VCSMSFTPClientImpl(ClientConfiguration configuration) {
		super();
		this.configuration = configuration;
		ftp = new FTPClient();
	}

	public File fetch(String filename, String location) throws IOException {
		ftp.connect(this.configuration.getFtpHost());
		ftp.login(this.configuration.getFtpUserName(), this.configuration.getFtpUserPassword());
		
		OutputStream stream = getOutputStreamFor(filename, location);
		boolean success = ftp.retrieveFile(filename, stream);
		stream.close();
	    assert(success);
	    return new File(location+"/"+filename);
	}

	private OutputStream getOutputStreamFor(String filename, String location) throws IOException{
		if(!new File(location).exists()){
			Files.createDirectories(Paths.get(location));
		}
		File download = new File(location+"/"+filename);
        return new BufferedOutputStream(new FileOutputStream(download));
	}

}
