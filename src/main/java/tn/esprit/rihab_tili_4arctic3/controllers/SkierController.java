package tn.esprit.rihab_tili_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rihab_tili_4arctic3.entites.Skier;
import tn.esprit.rihab_tili_4arctic3.services.ISkierServices;

import java.util.List;

@RestController
@RequestMapping("skier")
public class SkierController {
    @Autowired
    private ISkierServices skierServices;

    @PostMapping("add")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierServices.addSkier(skier);
    }
    @PutMapping("update")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierServices.updateSkier(skier);
    }
    @GetMapping("get/{numSkier}")
    public Skier retrieveSkier(@PathVariable Long numSkier) {
        return skierServices.retrieveSkier(numSkier);
    }
    @DeleteMapping("delete/{numSkier}")
    public void deleteSkier(@PathVariable Long numSkier) {
        skierServices.deleteSkier(numSkier);
    }
    @GetMapping("all")
    public List<Skier> retrieveAllSkier() {
        return skierServices.retrieveAllSkier();
    }
}

