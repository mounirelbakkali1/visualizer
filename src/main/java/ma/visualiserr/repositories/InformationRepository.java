package ma.visualiserr.repositories;

import ma.visualiserr.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List ;

@Repository
public interface InformationRepository extends JpaRepository<Information,Integer> {
    @Query("SELECT c FROM Information c where c.age =:age  and c.sexe =:sexe and c.date_en=:date")
    List<Information> calculateStatistics(String age , String sexe, LocalDate date);
}
