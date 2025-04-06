package tn.esprit.rihab_tili_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.*;
import tn.esprit.rihab_tili_4arctic3.repositories.ICourseRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.IRegistrationRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.ISkierRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.ISubscriptionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SkierServicesImpl implements ISkierServices {

  private ISkierRepository skierRepository;
  private ICourseRepository courseRepository;
  private IRegistrationRepository registrationRepository;
  private ISubscriptionRepository subscriptionRepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public void deleteSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);

    }

    @Override
    public List<Skier> retrieveAllSkier() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        Subscription subscription = skier.getSubscription();
        subscriptionRepository.save(subscription);

        Registration registration = new Registration();
        registration.setSkier(skier);
        registration.setCourse(course);
        registration.setNumWeek(1);
        registrationRepository.save(registration);

        skier.getRegistrations().add(registration);
        skier.getCourses().add(course);
        return skierRepository.save(skier);
    }
    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement) {
        return skierRepository.findBySubscriptionTypeAbonnement(typeAbonnement);
    }

}
