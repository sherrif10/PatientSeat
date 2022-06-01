/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientseat;

import org.openmrs.BaseOpenmrsData;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Item class persistable, see also PatientseatDaoTest and liquibase.xml
//@Entity(name = "patientseat.seat")
//@Table(name = "patientseat_seat")
public class Seat extends BaseOpenmrsData {
	
	private Integer id;
	
	public String name;
	
	public String description;

	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public User getName() {
		return name;
	}
	
	public void setName(User name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	
}
