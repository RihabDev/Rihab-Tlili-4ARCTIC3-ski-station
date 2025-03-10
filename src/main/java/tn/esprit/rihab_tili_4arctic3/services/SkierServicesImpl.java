package tn.esprit.rihab_tili_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.Skier;
import tn.esprit.rihab_tili_4arctic3.repositories.ISkierRepository;

import java.util.List;

@Service
public class SkierServicesImpl implements ISkierServices {
  @Autowired
  private ISkierRepository skierRepository;


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
}
