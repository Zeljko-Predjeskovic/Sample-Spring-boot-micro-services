package spg.pre.microservices.calendar.todoNote;

import java.time.LocalDate;

public record NoteDto(String title,String description,LocalDate calendarDate) {
}
