package spg.pre.microservices.musicmanager.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import spg.pre.microservices.musicmanager.domain.documents.Song;

@Repository
public interface SongRepository extends MongoRepository<Song,String>{

    Song findByMusicTitle(String musicTitle);

}
