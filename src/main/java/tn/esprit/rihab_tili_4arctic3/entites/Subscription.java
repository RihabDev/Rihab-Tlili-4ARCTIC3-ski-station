package tn.esprit.rihab_tili_4arctic3.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numSub;
    LocalDateTime startDate;
    LocalDateTime endDate;
    float price;
    @Enumerated(EnumType.STRING)
    TypeSubscription typeSub;
}
