package spg.pre.microservices.calendar.fileAccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileStreamerTest {

    private FileStreamerImp fileStreamer = new FileStreamerImp();

    @Test
    public void fileReadOnelineTest(){
        Assertions.assertTrue(fileStreamer
                .fileReadOneLine(new File(System.getProperty("testingFile")), "12sa")!=null);
        Assertions.assertTrue(fileStreamer
                .fileReadOneLine(new File(System.getProperty("testingFile")), "12sa").getId().equals("12sa"));
    }
}
