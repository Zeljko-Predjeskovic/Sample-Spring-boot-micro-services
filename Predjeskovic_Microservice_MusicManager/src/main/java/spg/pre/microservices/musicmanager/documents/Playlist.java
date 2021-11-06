package spg.pre.microservices.musicmanager.documents;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Playlist {

    public String playlistName;
    public List<Music> Songs;
}
