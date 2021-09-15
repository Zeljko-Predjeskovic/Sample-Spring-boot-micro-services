package spg.pre.microservices.calendar.fileAccess;

import java.io.File;

public interface FileStreamer{

    void fileWriteline(Note note);

    Note fileReadOneLine(String id);
}
