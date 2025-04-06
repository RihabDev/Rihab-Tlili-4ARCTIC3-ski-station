package tn.esprit.rihab_tili_4arctic3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long numPiste;
     String namePiste;
    @Enumerated(EnumType.STRING)
     Color color;
     int length;
     int slope;

    @ManyToMany

    @JsonIgnore
    Set<Skier> skiers;



}
