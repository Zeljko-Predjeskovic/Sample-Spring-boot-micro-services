package spg.pre.microservices.musicmanager.documents;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Artist extends Persistable {

    public String artistName;

    public List<Music> producedSongs;

}
