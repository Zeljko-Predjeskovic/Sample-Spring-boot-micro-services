package spg.pre.microservices.calendar.todoNote;

public interface CrudRepository {

    public Note getNoteFromDate();

    public Note addNote();

    public Note deleteNode();
}
