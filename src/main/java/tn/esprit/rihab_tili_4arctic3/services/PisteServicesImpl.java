package tn.esprit.rihab_tili_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rihab_tili_4arctic3.entites.Piste;
import tn.esprit.rihab_tili_4arctic3.entites.Skier;
import tn.esprit.rihab_tili_4arctic3.repositories.IPisteRepository;
import tn.esprit.rihab_tili_4arctic3.repositories.ISkierRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class PisteServicesImpl implements IPisteServices {
    private IPisteRepository pisteRepository;
    private ISkierRepository skierRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(Long numPiste) {
      pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> retrieveAllPiste() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste assignToSkier(long numPiste, long numSkier) {
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        piste.getSkiers().add(skier);

        return pisteRepository.save(piste);
    }


}
