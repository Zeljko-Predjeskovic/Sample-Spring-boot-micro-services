package spg.pre.microservices.musicmanager.domain.documents;

import lombok.*;
import spg.pre.microservices.musicmanager.domain.models.Persistable;

import java.time.LocalDate;
import java.util.HashMap;

@Getter
@Setter
public class Music extends Persistable {

    public String musicTitle;
    public Artist artist;
    public String trackUrl;
    public LocalDate createdOn;
    public HashMap<LocalDate,Integer> weeklyClickedOn;

    @Builder
    public Music(String musicTitle, Artist artist, String trackUrl, LocalDate createdOn) {
        this.musicTitle = musicTitle;
        this.artist = artist;
        this.trackUrl = trackUrl;
        this.createdOn = createdOn;
    }

    public void addClick(int clicks){
        if(weeklyClickedOn == null)
        {
            weeklyClickedOn = new HashMap<LocalDate,Integer>();
        }
        else {
            weeklyClickedOn.put(LocalDate.now(),clicks);
        }
    }
}
