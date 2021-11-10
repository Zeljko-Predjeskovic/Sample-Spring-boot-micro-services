package spg.pre.microservices.musicmanager.domain.models;

import lombok.*;

@Builder
@Getter @Setter
public class Artist extends Persistable {

    public String artistName;

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
