package spg.pre.microservices.musicmanager.domain.models;

import lombok.*;

@Builder
@Getter @Setter
public class Artist extends Persistable {

    private String artistName;

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
