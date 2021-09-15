package spg.pre.microservices.calendar.controller;

import spg.pre.microservices.calendar.todoNote.NoteServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/")
public class CalendarServletViewCreateNote extends HttpServlet {

    private final NoteServiceImp noteServiceImp = new NoteServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //impement create note
    }

    protected boolean isExpired(LocalDate noteDate){
        if(noteDate.isBefore(LocalDate.now()))
            return true;
        return false;
    }
}
