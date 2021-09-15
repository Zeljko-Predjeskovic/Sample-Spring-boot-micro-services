package spg.pre.microservices.calendar.fileAccess;

import java.io.File;

public interface FileStreamer{

    void fileWriteline(File f);

    Note fileReadOneLine(File f, String id);
}
