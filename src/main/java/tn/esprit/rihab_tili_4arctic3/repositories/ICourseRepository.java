package tn.esprit.rihab_tili_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.rihab_tili_4arctic3.entites.Course;
import tn.esprit.rihab_tili_4arctic3.entites.Support;

import java.util.List;


public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructorNumInstructorAndSupport(Long numInstructor, Support support);
}
