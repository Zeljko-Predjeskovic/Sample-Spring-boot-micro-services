package spg.pre.microservices.musicmanager;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import spg.pre.microservices.musicmanager.domain.documents.Album;
import spg.pre.microservices.musicmanager.domain.documents.Song;
import spg.pre.microservices.musicmanager.domain.models.Artist;
import spg.pre.microservices.musicmanager.persistence.SongRepository;

import java.time.LocalDate;
import java.util.ArrayList;



@SpringBootApplication
@EnableMongoRepositories
@EnableEurekaClient
public class PredjeskovicMicroserviceMusicManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredjeskovicMicroserviceMusicManagerApplication.class, args);

    }
/*
    @Bean
    CommandLineRunner runner(SongRepository songRepository, MongoTemplate mongoTemplate){

      Faker faker = new Faker();

      return args -> {

          mongoTemplate.dropCollection("song");
          mongoTemplate.dropCollection("album");

          var songs = new ArrayList<Song>();

          for(int i = 0; i<11 ; i++){
              songs.add(new Song(faker.name().title(), new Artist(faker.name().firstName()),
                      faker.address().fullAddress(), faker.music().key(), LocalDate.now()));
          }

          songRepository.insert(songs);
          songRepository.createAlbumWithSongs(faker.name().title(), songs);
      };

    }
*/
}
