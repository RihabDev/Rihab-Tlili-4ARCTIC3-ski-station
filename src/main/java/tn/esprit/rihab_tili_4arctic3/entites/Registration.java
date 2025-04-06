package tn.esprit.rihab_tili_4arctic3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numRegistration;
    int numWeek;
    @JsonIgnore
@ManyToOne
    Skier skier;
@ManyToOne
    Course course;
}
