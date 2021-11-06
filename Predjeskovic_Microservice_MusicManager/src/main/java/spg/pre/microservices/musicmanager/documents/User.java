package spg.pre.microservices.musicmanager.documents;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import spg.pre.microservices.musicmanager.models.Persistable;
import spg.pre.microservices.musicmanager.models.Playlist;

import java.util.List;

@Document
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class User extends Persistable {

    public String firstname;
    public String lastname;
    public List<Playlist> playlists;

}
