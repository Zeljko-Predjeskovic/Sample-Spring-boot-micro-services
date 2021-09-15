package spg.pre.microservices.calendar.todoNote;

import spg.pre.microservices.calendar.fileAccess.Note;

import java.util.HashMap;

public interface FileQueries {

    public HashMap<String, Note> findAllNotes();

    public Note findOneNote(String id);

    public Note addNote(Note note);

    public void deleteNote(String id);

}
