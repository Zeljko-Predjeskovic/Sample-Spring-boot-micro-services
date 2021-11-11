package spg.pre.microservices.musicmanager.domain.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import spg.pre.microservices.musicmanager.domain.models.Persistable;

import java.util.ArrayList;
import java.util.List;

@Document
@Builder
@Setter @Getter
public class Album extends Persistable {

    private String albumName;

    private List<Song> songs;

    private Album(String albumName) {
        this.albumName = albumName;
    }

    public Album(String albumName, List<Song> songs) {
        this.albumName = albumName;
        this.songs = songs;
    }

    public void addSongIntoAlbum(Song song){
        if(songs == null){
            songs = new ArrayList<Song>();
        }
        songs.add(song);
    }
}
