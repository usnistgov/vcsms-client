package gov.nist.healthcare.vcsms.service;

import java.io.IOException;

import gov.nist.healthcare.vcsms.domain.RemoteResponse;
import gov.nist.healthcare.vcsms.exception.ResourceNotFoundException;

public interface NISTVCSMSClient {

	public RemoteResponse checkResource(String resourceID) throws ResourceNotFoundException;

	public String fetchPackage(String resourceID) throws IOException;
	
	public RemoteResponse fetchStream(String resourceID) throws IOException;

	public String getValuesetString(String resourceID) throws IOException;
}
