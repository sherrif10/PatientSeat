package org.openmrs.module.patientseat;

import org.openmrs.annotation.AddOnStartup;
import org.openmrs.annotation.HasAddOnStartupPrivileges;

@HasAddOnStartupPrivileges
public class PatientSeatPrivilegeConstants {
	
	@AddOnStartup(description = "Able to add seat in EMR system")
	public static final String ADD_SEAT = "Add PatientSeat seat";
	
	@AddOnStartup(description = "Able to get Seat in EMR system")
	public static final String GET_SEAT = "Get Patient seat";
	
	@AddOnStartup(description = "Able to edit Seat in EMR system")
	public static final String EDIT_SEAT = "Edit Patient Seat";
	
}
