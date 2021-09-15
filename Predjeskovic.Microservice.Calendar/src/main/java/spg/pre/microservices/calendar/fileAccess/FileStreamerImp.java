package spg.pre.microservices.calendar.fileAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileStreamerImp implements FileStreamer{

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public void fileWriteline(File f) {

    }

    @Override
    public Note fileReadOneLine(File f, String id) {

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] str = line.split(",");

                if(checkId(str[0],id)){
                    return new Note(str[0],str[1],str[2], LocalDate.parse(str[3],dateTimeFormatter));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Reading failed! ",e);
        }
        return null;
    }

    public boolean checkId(String idWanted, String idReading){
        if(idWanted.equals(idReading))
            return true;
        return false;
    }
}
