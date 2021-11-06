package spg.pre.microservices.musicmanager.documents;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import spg.pre.microservices.musicmanager.models.Persistable;

import java.time.LocalDate;
import java.util.HashMap;

@Document
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Music extends Persistable {

    public String musicTitle;
    public Artist artist;
    public String trackUrl;
    public LocalDate createdOn;
    public HashMap<LocalDate,Long> weeklyClickedOn;

}
