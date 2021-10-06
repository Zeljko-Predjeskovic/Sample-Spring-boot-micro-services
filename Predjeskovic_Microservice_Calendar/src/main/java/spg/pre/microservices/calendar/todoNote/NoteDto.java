package spg.pre.microservices.calendar.todoNote;

import spg.pre.microservices.calendar.fileAccess.Note;

import java.time.LocalDate;

public record NoteDto(String id, String title,String description,LocalDate calendarDate) {

    protected Note toNote(){
        return new Note(this.id, this.title,
                this.description,this.calendarDate);
    }

}
