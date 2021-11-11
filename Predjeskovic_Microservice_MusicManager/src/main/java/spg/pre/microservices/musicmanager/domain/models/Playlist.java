package spg.pre.microservices.musicmanager.domain.models;

import lombok.*;
import spg.pre.microservices.musicmanager.domain.documents.Song;

import java.util.List;

@Builder
@Getter @Setter
public class Playlist {

    private String playlistName;
    private List<Song> Songs;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public Playlist(String playlistName, List<Song> songs) {
        this.playlistName = playlistName;
        Songs = songs;
    }
}
