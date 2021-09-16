package spg.pre.microservices.calendar.fileAccess;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileStreamerImp implements FileStreamer{

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private final File file;

    public FileStreamerImp(File file) {
        this.file = file;
    }


    public void fileWriteline(Note note) {
        String line = ""+note.getId()+","+note.getTitle()+","+note.getDescription()+","
                +note.getCalendarDate().format(dateTimeFormatter);


        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(line);
            bw.close();
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
                if(line.isEmpty())
                    break;
                String[] str = line.split(",");
                    notes.add(new Note(str[0],str[1],str[2], LocalDate.parse(str[3],dateTimeFormatter)));
            }
        } catch (Exception e) {
            throw new RuntimeException("Reading failed! ",e);
        }
        return notes;
    }

    @Override
    public void deleteLine(String id) {

    }

    public boolean checkId(String idWanted, String idReading){
        if(idWanted.equals(idReading))
            return true;
        throw new IllegalArgumentException("Is not the same id!!");
    }
}
