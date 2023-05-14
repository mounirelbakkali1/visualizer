package ma.visualiserr.services;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ma.visualiserr.entities.Information;
import ma.visualiserr.repositories.InformationRepository;
import ma.visualiserr.requests.StatistiqueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {


    @Autowired
    InformationRepository repository ;
    public List<Object> findStatistic(StatistiqueRequest request){
        List<Information> information = repository.calculateStatistics(request.tranche_age(), request.sexe(),request.date());
        long e1_count = information.stream()
                .filter(i -> i.getEmotion().equals("Angry"))
                .count();
        long e2_count = information.stream()
                .filter(i -> i.getEmotion().equals("Disgust"))
                .count();
        long e3_count = information.stream()
                .filter(i -> i.getEmotion().equals("Fear"))
                .count();
        long e4_count = information.stream()
                .filter(i -> i.getEmotion().equals("Happy"))
                .count();
        long e5_count = information.stream()
                .filter(i -> i.getEmotion().equals("Neutral"))
                .count();
        long e6_count = information.stream()
                .filter(i -> i.getEmotion().equals("Sad"))
                .count();
        long e7_count = information.stream()
                .filter(i -> i.getEmotion().equals("Surprise"))
                .count();
        return List.of(e1_count,e2_count,e3_count,e4_count,e5_count,e6_count,e7_count) ;
    }
}
