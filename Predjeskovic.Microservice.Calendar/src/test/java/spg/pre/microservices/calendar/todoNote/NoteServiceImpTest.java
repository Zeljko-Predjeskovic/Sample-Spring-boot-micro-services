package spg.pre.microservices.calendar.todoNote;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteServiceImpTest {

    private NoteServiceImp noteServiceImp = new NoteServiceImp();


    @Test
    public void getAllNotes(){
        Assertions.assertTrue(noteServiceImp.getAllNotes()!=null);
    }



}
