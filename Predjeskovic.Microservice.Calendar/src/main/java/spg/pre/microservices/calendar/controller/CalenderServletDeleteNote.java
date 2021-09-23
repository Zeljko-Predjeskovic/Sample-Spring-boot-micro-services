package spg.pre.microservices.calendar.controller;

import spg.pre.microservices.calendar.todoNote.NoteServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteNote/*")
public class CalenderServletDeleteNote extends HttpServlet {

    private final NoteServiceImp noteServiceImp = new NoteServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] s = req.getPathInfo().split("/");

        for(String t : s)
            System.out.println(t);

        String id = s[1];

        noteServiceImp.deleteNode(id);

        resp.sendRedirect("/Predjeskovic_Microservice_Calendar_war/create");



    }

}
