package spg.pre.microservices.calendar.fileAccess;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileStreamerImp implements FileStreamer{

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final File file;

    public FileStreamerImp(File file) {
        this.file = file;
    }


    public void fileWriteline(Note note) {
        String line = ""+note.getId()+","+note.getTitle()+","+note.getDescription()+","
                +note.getCalendarDate().format(dateTimeFormatter)+"\n";

        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                out.print(line);
            }
         catch (Exception e) {
            throw new RuntimeException("Writing failed! ",e);
        }
    }

    @Override
    public Note fileReadOneLine(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
        throw new RuntimeException("Line could not be red!!");
    }

    @Override
    public List<Note> fileReadAllLines() {
        List<Note> notes = new ArrayList<Note>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] str = line.split(",");
                    notes.add(new Note(str[0],str[1],str[2], LocalDate.parse(str[3],dateTimeFormatter)));
            }
        } catch (Exception e) {
            throw new RuntimeException("Reading failed! ",e);
        }
        return notes;
    }

    public boolean checkId(String idWanted, String idReading){
        if(idWanted.equals(idReading))
            return true;
        throw new IllegalArgumentException("Is not the same id!!");
    }
}
