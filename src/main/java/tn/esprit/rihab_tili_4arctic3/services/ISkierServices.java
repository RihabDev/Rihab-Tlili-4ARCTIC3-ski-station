package tn.esprit.rihab_tili_4arctic3.services;

import tn.esprit.rihab_tili_4arctic3.entites.Skier;
import tn.esprit.rihab_tili_4arctic3.entites.Support;
import tn.esprit.rihab_tili_4arctic3.entites.TypeSubscription;

import java.util.List;

public interface ISkierServices {
    Skier addSkier(Skier skier);

    Skier updateSkier(Skier skier);

    Skier retrieveSkier(Long numSkier);

    void deleteSkier(Long numSkier);

    List<Skier> retrieveAllSkier();

    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);

    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement);
}

