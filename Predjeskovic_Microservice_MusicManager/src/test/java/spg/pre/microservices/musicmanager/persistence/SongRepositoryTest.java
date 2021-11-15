package spg.pre.microservices.musicmanager.persistence;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import spg.pre.microservices.musicmanager.domain.documents.Song;
import spg.pre.microservices.musicmanager.domain.models.Artist;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Song song;

    private Faker faker = new Faker();

    @BeforeAll
    public void beforeAll(){
        mongoTemplate.dropCollection("song");
        mongoTemplate.dropCollection("album");
    }

    @Test @Order(1)
    public void assertInsertSong(){
        song = songRepository.insert(new Song(faker.name().title(), new Artist(faker.name().firstName()),
                faker.address().fullAddress(), faker.music().key(), LocalDate.now()));
        Assertions.assertTrue(song != null);
    }

    @Test @Order(2)
    public void assertUpdateSong(){
        song = songRepository.save(song);
        Assertions.assertTrue(song != null);
    }

    @Test @Order(3)
    public void assertPartialUpdateSong(){
        songRepository.partialUpdate(song.getId(),"genre","Rock");
    }

    @Test @Order(4)
    public void assertDeleteSong(){
        songRepository.delete(song);
    }


    @Test @Order(5)
    public void assertFalseGetSong(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {songRepository.findById(song.getId()).get();});
    }





}
