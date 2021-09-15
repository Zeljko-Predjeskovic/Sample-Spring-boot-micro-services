package spg.pre.microservices.calendar.fileAccess;

import java.io.File;
import java.util.List;

public interface FileStreamer{



    void fileWriteline(Note note);

    Note fileReadOneLine(String id);

    List<Note> fileReadAllLines();
}
