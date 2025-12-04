package com.osd.prefect.system.app.facade.person;

import com.osd.prefect.system.model.person.Person;

public interface PersonFacade {
    Person getByPersonId(String personID);
}
