package tn.esprit.rihab_tili_4arctic3.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numSkier;
    //@column(name="firstName", nullable= "false", length="20", unique= true );
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String city;
@OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
     Subscription subscription;
@OneToMany (mappedBy = "skier")
List<Registration> registrations;
@ManyToMany (mappedBy = "skiers")
    Set<Piste> pistes;



    public Set<Course> courses;
}
