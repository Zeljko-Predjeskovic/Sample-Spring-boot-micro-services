package spg.pre.microservices.calendar.controller;

import spg.pre.microservices.calendar.todoNote.NoteDto;
import spg.pre.microservices.calendar.todoNote.NoteServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@WebServlet(urlPatterns = "/create")
public class CalendarServletViewNote extends HttpServlet {

    private final NoteServiceImp noteServiceImp = new NoteServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("notes", noteServiceImp.getAllNotes());

        req.getRequestDispatcher("/calendar/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title =  req.getParameter("title");
        String description =  req.getParameter("description");
        String date = req.getParameter("date");


        NoteDto noteDto = new NoteDto(UUID.randomUUID().toString(),title,
                description,
                 LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        System.out.println(noteDto);
        noteServiceImp.addNote(noteDto);

        resp.sendRedirect("/Predjeskovic_Microservice_Calendar_war/create");
    }

    protected boolean isExpired(LocalDate noteDate){
        if(noteDate.isBefore(LocalDate.now()))
            return true;
        return false;
    }
}
