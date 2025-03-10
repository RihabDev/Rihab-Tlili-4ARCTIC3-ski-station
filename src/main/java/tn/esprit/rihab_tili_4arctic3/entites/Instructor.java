package tn.esprit.rihab_tili_4arctic3.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.rihab_tili_4arctic3.repositories.IInstructorRepository;

import java.time.LocalDate;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numInstructor;
    String firstName;
    String lastName;
    LocalDate birthHire;
    @OneToMany
    Set<Course> courses;
}
