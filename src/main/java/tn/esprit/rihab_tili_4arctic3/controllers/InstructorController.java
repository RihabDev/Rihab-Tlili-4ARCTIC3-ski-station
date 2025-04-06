package tn.esprit.rihab_tili_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rihab_tili_4arctic3.entites.Instructor;
import tn.esprit.rihab_tili_4arctic3.services.ICourseServices;
import tn.esprit.rihab_tili_4arctic3.services.IInstructorServices;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("instructor")
public class InstructorController {

    private IInstructorServices instructorServices;
    private ICourseServices courseServices;
    @PostMapping("add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorServices.addInstructor(instructor);
    }
    @PutMapping("update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorServices.updateInstructor(instructor);
    }
    @GetMapping("get/{numInstructor}")
    public Instructor retrieveInstructor(@PathVariable Long numInstructor) {
        return instructorServices.retrieveInstructor(numInstructor);
    }
    @DeleteMapping("delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor) {
        instructorServices.deleteInstructor(numInstructor);
    }
    @GetMapping("all")
    public List<Instructor> retrieveAllInstructor() {
        return instructorServices.retrieveAllInstructor();
    }
    @PostMapping("addInstructorAndAssignToCourse/{numCourse}")
    public Instructor addInstructorAndAssignToCourse(@RequestBody Instructor instructor, @PathVariable Long numCourse) {
        return instructorServices.addInstructorAndAssignToCourse(instructor, numCourse);
    }
    }
