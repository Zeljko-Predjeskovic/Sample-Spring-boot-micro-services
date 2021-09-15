package spg.pre.microservices.calendar.fileAccess;

import spg.pre.microservices.calendar.fileAccess.FileQueries;
import spg.pre.microservices.calendar.fileAccess.FileStreamerImp;
import spg.pre.microservices.calendar.fileAccess.Note;

import java.io.File;
import java.util.List;

public class FileQueriesImpl implements FileQueries {

    private final FileStreamerImp fileStreamer = new FileStreamerImp(new File(System.getProperty("appFile")));


    @Override
    public List<Note> findAllNotes() {
        return null;
    }

    @Override
    public Note findOneNote(String id) {
        return fileStreamer.fileReadOneLine(id);
    }

    @Override
    public void addNote(Note note) {
        fileStreamer.fileWriteline(note);
    }

    @Override
    public void deleteNote(String id) {

    }
}
