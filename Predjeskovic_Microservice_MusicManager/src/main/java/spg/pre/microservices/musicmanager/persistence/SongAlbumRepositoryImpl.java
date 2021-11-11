package spg.pre.microservices.musicmanager.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import spg.pre.microservices.musicmanager.domain.documents.Album;
import spg.pre.microservices.musicmanager.domain.documents.Song;

import java.util.List;


public class SongAlbumRepositoryImpl implements SongAlbumRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void createAlbumWithSongs(String albumName, List<Song> songs ) {
        mongoTemplate.insert(new Album(albumName, songs));
    }
}
