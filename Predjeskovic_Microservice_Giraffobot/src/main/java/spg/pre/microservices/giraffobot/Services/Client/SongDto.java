package spg.pre.microservices.giraffobot.Services.Client;

import java.time.LocalDate;

public record SongDto(String id, String musicTitle, String artistName, LocalDate createdOn) {

}
