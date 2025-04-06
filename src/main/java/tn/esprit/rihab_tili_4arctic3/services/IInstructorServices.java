package tn.esprit.rihab_tili_4arctic3.services;


import tn.esprit.rihab_tili_4arctic3.entites.Instructor;

import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor (Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (long numInstructor);
    void deleteInstructor (long numInstructor);
    List<Instructor> retrieveAllInstructor();
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long
            numCourse);
}

