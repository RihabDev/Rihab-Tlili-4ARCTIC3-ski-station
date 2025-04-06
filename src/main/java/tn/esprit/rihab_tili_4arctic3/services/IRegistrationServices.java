package tn.esprit.rihab_tili_4arctic3.services;

import tn.esprit.rihab_tili_4arctic3.entites.Registration;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration (Registration registration);
    Registration updateRegistration (Registration registration);
    Registration retrieveRegistration (long numRegistration);
    void deleteRegistration (long numRegistration);
    List<Registration> retrieveAllRegistration();
    Registration addRegistrationAndAssignToSkier(Registration registration, Long
            numSkieur);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration,
                                                          Long numSkier, Long numCourse);
}
