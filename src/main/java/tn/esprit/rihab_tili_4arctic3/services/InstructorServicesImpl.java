package tn.esprit.rihab_tili_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.Course;
import tn.esprit.rihab_tili_4arctic3.entites.Instructor;
import tn.esprit.rihab_tili_4arctic3.repositories.ICourseRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.IInstructorRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class InstructorServicesImpl implements IInstructorServices {
    private ICourseRepository courseRepository;
    private IInstructorRepository instructorRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(long numInstructor) {
        instructorRepository.deleteById(numInstructor);

    }

    @Override
    public List<Instructor> retrieveAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        instructor.setCourses((Set<Course>) course);

        return instructorRepository.save(instructor);
    }
}
