package spg.pre.microservices.musicmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spg.pre.microservices.musicmanager.domain.documents.Music;

public interface MusicRepository extends MongoRepository<Music,Long> {

}
