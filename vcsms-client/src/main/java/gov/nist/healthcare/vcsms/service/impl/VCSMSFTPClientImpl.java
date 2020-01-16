package gov.nist.healthcare.vcsms.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;

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
		ftp.connect(this.configuration.getFtpHost(), 21);
		ftp.login(this.configuration.getFtpUserName(), this.configuration.getFtpUserPassword());

		OutputStream stream = getOutputStreamFor(filename, location);
		boolean success = ftp.retrieveFile(filename, stream);
		stream.close();
		assert (success);
		return new File(location + "/" + filename);
	}
	
	public InputStream fetchStream(String filename) throws IOException {
		ftp.connect(this.configuration.getFtpHost(), 21);
		ftp.login(this.configuration.getFtpUserName(), this.configuration.getFtpUserPassword());
		return ftp.retrieveFileStream(filename);
	}

	public String getValuesetString(String filename) throws IOException {
		System.out.println("Trying to Ftp connect");
		ftp.connect(this.configuration.getFtpHost(), 21);
		System.out.println("Ftp connected");
		System.out.println("Trying to Ftp login");
		ftp.login(this.configuration.getFtpUserName(), this.configuration.getFtpUserPassword());
		System.out.println("Ftp logged in");
		System.out.println("Trying to ftp retrieveFile");
		ftp.enterLocalPassiveMode();
		System.out.println("Switch to passive mode");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ftp.retrieveFile(filename, outputStream);
		System.out.println("Ftp retrieved");
		InputStream in = new ByteArrayInputStream(outputStream.toByteArray());
		
		
//		InputStream in = ftp.retrieveFileStream(filename);
		
		if(in != null) {
			System.out.println("Input stream found");
			String valueSetString = this.extractFileToJson(in);
			return valueSetString;
		}
		System.out.println("No input stream found" + filename);
		return null;
	}

	public String getLatestFileContent(String packageTemplateName) throws IOException {
		ftp.connect(this.configuration.getFtpHost(), 21);
		ftp.login(this.configuration.getFtpUserName(), this.configuration.getFtpUserPassword());

		String dirToSearch = "";

		FTPFileFilter filter = new FTPFileFilter() {

			@Override
			public boolean accept(FTPFile ftpFile) {

				return (ftpFile.isFile() && ftpFile.getName().contains(packageTemplateName));
			}
		};

		FTPFile[] files = ftp.listFiles(dirToSearch, filter);
		Integer latestDate = 0;
		Integer latestTime = 0;
		FTPFile latestFile = null;
		for (FTPFile f : files) {

			String fileName = f.getName().split("\\.")[0];
			if (fileName != null) {
				String[] fileNameSplit = fileName.split("_");
				Integer fileDate = Integer.parseInt(fileNameSplit[fileNameSplit.length - 2]);
				Integer fileTime = Integer.parseInt(fileNameSplit[fileNameSplit.length - 1]);
				if (fileDate > latestDate) {
					latestFile = f;
				} else if (fileDate == latestDate) {
					if (fileTime > latestTime) {
						latestFile = f;
					}
				}
			}
		}
		String fileContent = null;
		ZipEntry zipEntry = null;
		if (latestFile != null) {
			System.out.println("2" + latestFile.getName());
			InputStream in = ftp.retrieveFileStream(latestFile.getName());
			ZipInputStream zis = new ZipInputStream(in);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int read = 0;

			while ((zipEntry = zis.getNextEntry()) != null) {
				while ((read = zis.read(buffer, 0, buffer.length)) > 0) {
					baos.write(buffer, 0, read);
				}
				fileContent = baos.toString();
				zipEntry = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();

		}

		return fileContent;
	}

	private String extractFileToJson(InputStream stream) throws IOException {

		String fileContent = null;
		ZipEntry zipEntry = null;
		ZipInputStream zis = new ZipInputStream(stream);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int read = 0;

		while ((zipEntry = zis.getNextEntry()) != null) {
			while ((read = zis.read(buffer, 0, buffer.length)) > 0) {
				baos.write(buffer, 0, read);
			}
			fileContent = baos.toString();
			zipEntry = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
		return fileContent;
	}

	private OutputStream getOutputStreamFor(String filename, String location) throws IOException {
		if (!new File(location).exists()) {
			Files.createDirectories(Paths.get(location));
		}
		File download = new File(location + "/" + filename);
		return new BufferedOutputStream(new FileOutputStream(download));
	}

}
