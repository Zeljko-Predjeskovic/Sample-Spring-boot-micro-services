package spg.pre.microservices.giraffobot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spg.pre.microservices.giraffobot.Services.Client.ClientCalendarService;
import spg.pre.microservices.giraffobot.Services.Client.NoteDto;
import spg.pre.microservices.giraffobot.Services.Client.SongDto;

import java.util.List;

@RestController
@RequestMapping(NoteController.CALENDAR_ROUTE)
public class NoteController {

    public static final String CALENDAR_ROUTE="/calendar";

    private final ClientCalendarService clientCalendarService;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    public NoteController(ClientCalendarService clientCalendarService) {
        this.clientCalendarService = clientCalendarService;
    }


    @GetMapping
    public List<NoteDto> getAllSongs(){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        return circuitBreaker.run(() -> clientCalendarService.getAllNotes());
    }
}
