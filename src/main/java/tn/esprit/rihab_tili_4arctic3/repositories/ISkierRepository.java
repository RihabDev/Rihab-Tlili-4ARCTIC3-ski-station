package tn.esprit.rihab_tili_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.rihab_tili_4arctic3.entites.Skier;
import tn.esprit.rihab_tili_4arctic3.entites.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

public interface ISkierRepository extends JpaRepository<Skier, Long> {


    List<Skier> findBySubscriptionTypeAbonnement(TypeSubscription typeAbonnement);
}
