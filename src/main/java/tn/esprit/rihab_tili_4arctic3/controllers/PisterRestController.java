package tn.esprit.rihab_tili_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rihab_tili_4arctic3.entites.Piste;
import tn.esprit.rihab_tili_4arctic3.services.IPisteServices;
import tn.esprit.rihab_tili_4arctic3.services.ISkierServices;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("piste")
public class PisterRestController {

    private IPisteServices pisteServices;
    private ISkierServices skierServices;

    @PostMapping("add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteServices.addPiste(piste);
    }
    @PutMapping("update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteServices.updatePiste(piste);
    }
    @GetMapping("get/{numPiste}")
    public Piste retrievePiste(@PathVariable Long numPiste) {
        return pisteServices.retrievePiste(numPiste);
    }
    @DeleteMapping("delete/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
      pisteServices.deletePiste(numPiste);
    }
    @GetMapping("all")
    public List<Piste> retrieveAllPiste() {
        return pisteServices.retrieveAllPiste();
    }
    @PutMapping("assignToSkier/{numPiste}/{numSkier}")
    Piste assignToSkier(@PathVariable long numPiste, @PathVariable long numSkier){
        return pisteServices.assignToSkier(numPiste, numSkier);
    }

}
