package spg.pre.microservices.calendar.fileAccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

public class FileStreamerTest {

    private FileStreamerImp fileStreamer = new FileStreamerImp(new File(System.getProperty("testingFile")));


    @Test
    public void writeFileAndReadIt(){
    fileStreamer.fileWriteline(new Note("ABC","Title","Descr", LocalDate.of(2000,12,5)));
        Assertions.assertTrue(fileStreamer
                .fileReadOneLine("ABC").getId().equals("ABC"));
    }

}
