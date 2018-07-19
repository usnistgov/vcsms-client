package gov.nist.healthcare.vcsms.example;

import java.io.IOException;
import gov.nist.healthcare.vcsms.domain.ClientConfiguration;
import gov.nist.healthcare.vcsms.domain.RESTClientInfo;
import gov.nist.healthcare.vcsms.domain.RemoteResponse;
import gov.nist.healthcare.vcsms.exception.ResourceNotFoundException;
import gov.nist.healthcare.vcsms.service.impl.NISTVCSMSClientImpl;

public class Main {

	public static void main(String[] args) throws ResourceNotFoundException, IOException {
		NISTVCSMSClientImpl client = new NISTVCSMSClientImpl(
				new ClientConfiguration("{ROOT_PATH}", 
										"{GROUP_MNEMONIC}", 
										"{NODE_ID}", 
										"{FTP_HOST}", 
										"{USERNAME}", 
										"{PASSWORD}"), 
				new RESTClientInfo("1.0.0","TEST Client"), "{DOWNLOAD_LOCATION}");

		RemoteResponse response = client.checkResource("{RESOURCE_ID}");
		System.out.println(response.isStatus());
		System.out.println(response.getName());
		System.out.println(response.isChanged());
	}
}
