package spg.pre.microservices.calendar.fileAccess;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FileQueriesImpl implements FileQueries {

    private final FileStreamerImp fileStreamer = new FileStreamerImp(new File("Notes.txt"));


    @Override
    public List<Note> findAllNotes() {
        return fileStreamer.fileReadAllLines();
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
        List<Note> notes = findAllNotes();

        Note note = notes.stream().filter(f->f.getId().equals(id)).findFirst().get();

        notes.remove(note);

        fileStreamer.clearFile();

        for (Note n:notes) {
            fileStreamer.fileWriteline(n);
        }


    }
}
