package spg.pre.microservices.musicmanager.domain.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import spg.pre.microservices.musicmanager.domain.models.Artist;
import spg.pre.microservices.musicmanager.domain.models.Persistable;

import java.time.LocalDate;

@Document
@Builder
@Getter @Setter
public class Song extends Persistable {

    public String musicTitle;
    public Artist artist;
    public String trackUrl;
    public String genre;
    public LocalDate createdOn;

    public Song(String musicTitle, Artist artist, String trackUrl, String genre, LocalDate createdOn) {
        this.musicTitle = musicTitle;
        this.artist = artist;
        this.trackUrl = trackUrl;
        this.genre = genre;
        this.createdOn = createdOn;
    }

}
