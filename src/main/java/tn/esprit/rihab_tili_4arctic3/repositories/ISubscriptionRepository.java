package tn.esprit.rihab_tili_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.rihab_tili_4arctic3.entites.Subscription;
import tn.esprit.rihab_tili_4arctic3.entites.TypeSubscription;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ISubscriptionRepository extends JpaRepository<Subscription, Long> {
    Collection<? extends Subscription> findByTypeAbonnementOrderByStartDateAsc(TypeSubscription type);

    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
