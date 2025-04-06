package tn.esprit.rihab_tili_4arctic3.services;

import tn.esprit.rihab_tili_4arctic3.entites.Course;
import tn.esprit.rihab_tili_4arctic3.entites.Support;

import java.util.List;

public interface ICourseServices {
    Course addCourse (Course course);
    Course updateCourse (Course course);
    Course retrieveCourse (long numCourse);
    void deleteCourse (long numCourse);
    List<Course> retrieveAllCourse();
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor,
                                                      Support support);
}
