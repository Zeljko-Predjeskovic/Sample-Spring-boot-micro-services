package spg.pre.microservices.musicmanager.domain.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import spg.pre.microservices.musicmanager.domain.models.Persistable;

import java.util.List;

@Document
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Artist extends Persistable {

    public String artistName;

    public List<Music> producedSongs;

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
