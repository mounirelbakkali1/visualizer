package ma.visualiserr.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.TemporalType.DATE;
import static jakarta.persistence.TemporalType.TIME;

@Entity
@Table(name = "information")
@Getter
@Setter
public class Information {
    @Id
    @GeneratedValue(strategy = IDENTITY)
            @Column(name = "id",nullable = false)
    Integer id ;
    @Temporal(DATE)
    @Column(columnDefinition = "DATE DEFAULT NOW()",nullable = false)
    LocalDate date_en ;
    @Temporal(TIME)
    @Column(columnDefinition = "TIME WITHOUT TIME ZONE   DEFAULT CURRENT_TIMESTAMP",nullable = false)
    LocalTime heure;
    @Column(name = "emotion",nullable = false)
    String emotion ;
    @Column(name = "age",nullable = false)
    String age ;
    @Column(name = "sexe",nullable = false)
    String sexe ;
}
