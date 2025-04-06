package tn.esprit.rihab_tili_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.Course;
import tn.esprit.rihab_tili_4arctic3.entites.Registration;
import tn.esprit.rihab_tili_4arctic3.entites.Skier;
import tn.esprit.rihab_tili_4arctic3.entites.TypeCourse;
import tn.esprit.rihab_tili_4arctic3.repositories.ICourseRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.IRegistrationRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.ISkierRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@Service
public class RegistrationServicesImpl implements IRegistrationServices {

    private IRegistrationRepository registrationRepository;
    private ISkierRepository skierRepository;
    private ICourseRepository courseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public void deleteRegistration(long numRegistration) {
        registrationRepository.deleteById(numRegistration);

    }

    @Override
    public List<Registration> retrieveAllRegistration() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
       Course course = courseRepository.findById(numCourse).orElse(null);
       Registration registration = registrationRepository.findById(numRegistration).orElse(null);
       registration.setCourse(course);
        return registrationRepository.save(registration);
    }
    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        Course course = courseRepository.findById(numCourse).orElse(null);

        if (course != null && skier != null) {
            // check skier age
            int age = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears();

            if ((course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN && age > 12)
                    || (course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT && age <= 12)) {
                throw new IllegalArgumentException("Skier age is not suitable for the course type");
            }

            long count = registrationRepository.countByCourse(course);
            if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN || course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT) {
                if (count >= 6) {
                    throw new IllegalStateException("Course already has 6 skiers");
                }
            }

            registration.setSkier(skier);
            registration.setCourse(course);
            return registrationRepository.save(registration);
        }
        return null;
    }

}
