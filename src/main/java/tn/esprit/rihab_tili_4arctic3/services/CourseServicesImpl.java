package tn.esprit.rihab_tili_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.Course;
import tn.esprit.rihab_tili_4arctic3.entites.Registration;
import tn.esprit.rihab_tili_4arctic3.entites.Support;
import tn.esprit.rihab_tili_4arctic3.repositories.ICourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServicesImpl implements ICourseServices {

    @Autowired
    ICourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void deleteCourse(long numCourse) {
        courseRepository.deleteById(numCourse);

    }

    @Override
    public List<Course> retrieveAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        List<Course> courses = courseRepository.findByInstructorNumInstructorAndSupport(numInstructor, support);
        return courses.stream()
                .flatMap(c -> c.getRegistrations().stream())
                .map(Registration::getNumWeek)
                .distinct()
                .collect(Collectors.toList());
    }
    }



