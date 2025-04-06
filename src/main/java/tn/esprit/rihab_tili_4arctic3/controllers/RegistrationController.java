package tn.esprit.rihab_tili_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rihab_tili_4arctic3.entites.Registration;
import tn.esprit.rihab_tili_4arctic3.services.IRegistrationServices;
import tn.esprit.rihab_tili_4arctic3.services.ISkierServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("registration")
public class RegistrationController {
    private IRegistrationServices registrationServices;
    private ISkierServices skierServices;

    @PostMapping("add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationServices.addRegistration(registration);
    }
    @PutMapping("update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationServices.updateRegistration(registration);
    }
    @GetMapping("get/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable Long numRegistration) {
        return registrationServices.retrieveRegistration(numRegistration);
    }
    @DeleteMapping("delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationServices.deleteRegistration(numRegistration);
    }
    @GetMapping("all")
    public List<Registration> retrieveAllRegistration() {
        return registrationServices.retrieveAllRegistration();
    }
    @PostMapping("addRegistrationAndAssignToSkier/{numSkier}")
    public Registration addRegistrationAndAssignToSkier( @RequestBody Registration registration, @PathVariable Long numSkier) {
        return registrationServices.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PutMapping("assignRegistrationToCourse/{numRegistration}/{numCourse}")
    public Registration assignRegistrationToCourse(@PathVariable Long numRegistration, @PathVariable Long numCourse) {
        return registrationServices.assignRegistrationToCourse(numRegistration, numCourse);
    }

    }

