package tn.esprit.rihab_tili_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.rihab_tili_4arctic3.entites.Course;
import tn.esprit.rihab_tili_4arctic3.entites.Registration;

public interface IRegistrationRepository extends JpaRepository<Registration, Long> {
    long countByCourse(Course course);
}
