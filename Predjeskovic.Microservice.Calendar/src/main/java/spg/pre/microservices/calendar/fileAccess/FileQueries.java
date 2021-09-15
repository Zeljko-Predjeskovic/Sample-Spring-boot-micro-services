package spg.pre.microservices.calendar.fileAccess;

import spg.pre.microservices.calendar.fileAccess.Note;

import java.util.HashMap;
import java.util.List;

public interface FileQueries {

    public List<Note> findAllNotes();

    public Note findOneNote(String id);

    public void addNote(Note note);

    public void deleteNote(String id);

}
