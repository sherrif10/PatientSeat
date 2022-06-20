package org.openmrs.module.patientseat.page;

import org.openmrs.ui.framework.fragment.FragmentRequest;
import org.openmrs.ui.framework.fragment.FragmentRequestMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PatientSeatPageRequestMapper implements FragmentRequestMapper {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Implementations should call {@link FragmentRequest#setProviderNameOverride(String)} and
	 * {@link FragmentRequest#setFragmentIdOverride(String)}, and return true if they want to remap
	 * a request, or return false if they didn't remap it.
	 * 
	 * @param request may have its providerNameOverride and pageNameOverride set
	 * @return true if this page was mapped (by overriding the provider and/or page), false
	 *         otherwise
	 */
	public boolean mapRequest(FragmentRequest request) {
		if (request.getProviderName().equals("appui")) {
			if (request.getFragmentId().equals("header")) {
				// change to the custom login provided by the module
				request.setProviderNameOverride("patientseatLoginPage");
				
				log.info(request.toString());
				return true;
			}
		}
		if (request.getProviderName().equals("adminui")) {
			if (request.getProviderName().equals("myaccount/myAccount")) {
				// change to the custom login provided by the module
				request.setProviderNameOverride("patientseat");
				request.setProviderNameOverride("userProfile");
				
				log.info(request.toString());
				return true;
			}
		}
		return false;
	}
}
