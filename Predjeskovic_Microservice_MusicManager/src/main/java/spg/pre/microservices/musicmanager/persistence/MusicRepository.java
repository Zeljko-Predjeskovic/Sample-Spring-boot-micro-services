package spg.pre.microservices.musicmanager.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import spg.pre.microservices.musicmanager.domain.documents.Music;

@Repository
public interface MusicRepository extends MongoRepository<Music,Long> {

}
