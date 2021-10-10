package spg.pre.microservices.calendar.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spg.pre.microservices.calendar.configs.LocalDateAdapter;
import spg.pre.microservices.calendar.todoNote.NoteDto;
import spg.pre.microservices.calendar.todoNote.NoteServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@WebServlet(urlPatterns = "/calendar/*")
public class CalenderServletRest extends HttpServlet
{

    private NoteServiceImp noteServiceImp = new NoteServiceImp();

    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class,new LocalDateAdapter())
            .create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(getRequestType(req).equals("getAll")){
            getAllNotes(resp);
        }
    }


    protected void getAllNotes(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(noteServiceImp.getAllNotes()));
        out.flush();
    }

    protected void deleteNote(){

    }

    protected void insertNote(){

    }

    protected String getRequestType(HttpServletRequest req){
        String[] s = req.getPathInfo().split("/");
        return s[1];
    }
}
