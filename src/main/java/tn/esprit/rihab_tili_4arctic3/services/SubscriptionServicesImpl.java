package tn.esprit.rihab_tili_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.Subscription;
import tn.esprit.rihab_tili_4arctic3.entites.TypeSubscription;
import tn.esprit.rihab_tili_4arctic3.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {

    @Autowired
    ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public void deleteSubscription(long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);

    }

    @Override
    public List<Subscription> retrieveAllSubscription() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return new TreeSet<>(subscriptionRepository.findByTypeAbonnementOrderByStartDateAsc(type));
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.findByStartDateBetween(startDate, endDate);

    }


}