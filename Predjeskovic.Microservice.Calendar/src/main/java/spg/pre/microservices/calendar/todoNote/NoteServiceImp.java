package spg.pre.microservices.calendar.todoNote;

import java.util.List;
import java.util.Optional;

public class NoteServiceImp implements NoteService {

    private final FileQueriesImpl fileQueries = new FileQueriesImpl();


    @Override
    public List<NoteDto> getAllNotes() {
        var notes = fileQueries.findAllNotes().values().stream()
                .map(f-> new NoteDto(f.getId(),f.getTitle(),f.getDescription(),f.getCalendarDate())).toList();
        return notes;
    }

    @Override
    public Optional<NoteDto> getNoteFromId(String id) {
        return Optional.of(fileQueries.findOneNote(id))
                .map(f-> new NoteDto(f.getId(),f.getTitle(),f.getDescription(),f.getCalendarDate()));
    }


    @Override
    public NoteDto addNote(NoteDto noteDto) {
        return null;
    }

    @Override
    public NoteDto deleteNode(String id) {
        return null;
    }
}
