package com.osd.prefect.system.app.facade.person.impl;

import com.osd.prefect.system.app.facade.person.PersonFacade;
import com.osd.prefect.system.data.dao.person.PersonDao;
import com.osd.prefect.system.data.dao.person.impl.PersonDaoImpl;
import com.osd.prefect.system.model.person.Person;

public class PersonFacadeImpl implements PersonFacade {
    private PersonDao personDao;

    public PersonFacadeImpl() {this.personDao = new PersonDaoImpl();}

    @Override
    public Person getByPersonId(String personID) {
        return personDao.getByPersonId(personID);
    }
}
