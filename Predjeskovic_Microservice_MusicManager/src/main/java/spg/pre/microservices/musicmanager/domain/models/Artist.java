package spg.pre.microservices.musicmanager.domain.models;

import lombok.*;
import spg.pre.microservices.musicmanager.domain.documents.Persistable;

@Builder
@Getter @Setter
public class Artist extends Persistable {

    private String artistName;

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
