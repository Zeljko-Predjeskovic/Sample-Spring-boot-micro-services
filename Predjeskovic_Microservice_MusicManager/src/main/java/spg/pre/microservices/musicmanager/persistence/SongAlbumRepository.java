package spg.pre.microservices.musicmanager.persistence;

import spg.pre.microservices.musicmanager.domain.documents.Album;
import spg.pre.microservices.musicmanager.domain.documents.Song;

import java.util.List;

public interface SongAlbumRepository {

    void createAlbumWithSongs(String albumName, List<Song> songs);
}
