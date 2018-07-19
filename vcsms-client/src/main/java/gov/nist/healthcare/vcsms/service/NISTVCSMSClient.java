package gov.nist.healthcare.vcsms.service;

import gov.nist.healthcare.vcsms.domain.RemoteResponse;
import gov.nist.healthcare.vcsms.exception.ResourceNotFoundException;

public interface NISTVCSMSClient {

	public RemoteResponse checkResource(String resourceID) throws ResourceNotFoundException;
	
}
