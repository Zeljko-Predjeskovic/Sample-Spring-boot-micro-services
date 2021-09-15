package spg.pre.microservices.calendar.todoNote;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<NoteDto> getAllNotes();

    Optional<NoteDto> getNoteFromId(String id);

    abstract void addNote(NoteDto noteDto);

    abstract NoteDto deleteNode(String id);
}
