package spg.pre.microservices.giraffobot.Services.Client;

import java.time.LocalDate;

public record NoteDto(String id, String title, String description, LocalDate calendarDate) {

}
