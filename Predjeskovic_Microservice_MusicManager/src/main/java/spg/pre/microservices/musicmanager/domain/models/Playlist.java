package spg.pre.microservices.musicmanager.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import spg.pre.microservices.musicmanager.domain.documents.Music;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Playlist {

    public String playlistName;
    public List<Music> Songs;
}
