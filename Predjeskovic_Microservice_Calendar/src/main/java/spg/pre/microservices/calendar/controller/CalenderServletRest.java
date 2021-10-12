package spg.pre.microservices.calendar.controller;

import com.google.gson.*;
import spg.pre.microservices.calendar.configs.LocalDateAdapter;
import spg.pre.microservices.calendar.fileAccess.Note;
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
import java.util.Scanner;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (getRequestType(req)){
            case "insert" : insertNote(req,resp);
                break;
            case "delete" : deleteNote(req, resp);
                break;
        }
    }


    protected void getAllNotes(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(noteServiceImp.getAllNotes()));
        out.flush();
    }

    protected void insertNote(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        NoteDto noteDto = new NoteDto(UUID.randomUUID().toString(),
                req.getParameter("title"),
                req.getParameter("description"),
                LocalDate.parse(req.getParameter("date"),DateTimeFormatter.ofPattern("MM/dd/yyyy")));

            noteServiceImp.addNote(noteDto);
            resp.setStatus(201);
            resp.addHeader("Insert Status","Inserted" + noteDto.id());


    }

    protected void deleteNote(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("ID");
        noteServiceImp.deleteNode(id);
        resp.setStatus(201);
        resp.addHeader("Insert Status","Deleted " + id);
    }

    protected String getRequestType(HttpServletRequest req){
        String[] s = req.getPathInfo().split("/");
        return s[1];
    }
}
