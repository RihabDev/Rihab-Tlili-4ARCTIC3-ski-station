package tn.esprit.rihab_tili_4arctic3.entites;

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

public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numCourse;
    int level;
    @Enumerated(EnumType.STRING)
    TypeCourse typeCourse;
    @Enumerated(EnumType.STRING)
    Support support;
    float price;
    int timeSolt;
    @OneToMany (mappedBy = "course")
    Set<Registration> registrations;

}
