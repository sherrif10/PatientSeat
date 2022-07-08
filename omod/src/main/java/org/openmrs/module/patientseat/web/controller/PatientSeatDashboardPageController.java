package org.openmrs.module.patientseat.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

// This will act as landing page
public class PatientSeatDashboardPageController {
	
	public void get(PageModel model,@RequestParam("appId")String app, UiSessionContext sessionContext, UiUtils ui){
        AppFrameworkService appFrameworkService = Context.getService(AppFrameworkService.class);
        AppDescriptor appDescriptor = appFrameworkService.getApp("referenceapplication.registrationapp.registerPatient");
        if(appDescriptor .getConfig().get("registrationAppLink") == null {
            model.addAttribute("registrationAppLink", "");

        }

    }
	
}
