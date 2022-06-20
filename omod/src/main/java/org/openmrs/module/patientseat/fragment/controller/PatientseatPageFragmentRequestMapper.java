package org.openmrs.module.patientseat.fragment.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ui.framework.fragment.FragmentRequest;
import org.openmrs.ui.framework.fragment.FragmentRequestMapper;

public class PatientseatPageFragmentRequestMapper implements FragmentRequestMapper {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public boolean mapRequest(FragmentRequest request) {
		if (request.getProviderName().equals("appui")) {
			if (request.getFragmentId().equals("header")) {
				//change the custom login page provided by this module
				request.setProviderNameOverride("patientSeat");
				request.setFragmentIdOverride("patientseatHeader");
			}
		}
		
		return false;
		
	}
	
}
