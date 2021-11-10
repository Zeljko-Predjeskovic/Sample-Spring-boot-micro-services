package spg.pre.microservices.musicmanager.domain.documents;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import spg.pre.microservices.musicmanager.domain.models.Persistable;
import spg.pre.microservices.musicmanager.domain.models.Playlist;

import java.util.ArrayList;
import java.util.List;

@Document
@Builder
@Getter @Setter
public class User extends Persistable {

    public String firstname;
    public String lastname;
    public List<Playlist> playlists;


    public User(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String firstname, String lastname, List<Playlist> playlists){
        this.firstname = firstname;
        this.lastname = lastname;
        this.playlists = playlists;
    }

    public void addPlaylist(Playlist playlist){
        if(playlists == null){
            playlists = new ArrayList<Playlist>();
        }
        playlists.add(playlist);
    }

}
