package spg.pre.microservices.giraffobot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spg.pre.microservices.giraffobot.Services.Client.ClientSongService;
import spg.pre.microservices.giraffobot.Services.Client.SongDto;

import java.util.List;

@RestController
@RequestMapping(SongController.MUSIC_ROUTE)
public class SongController {

    public static final String MUSIC_ROUTE = "/music";

    private final ClientSongService clientSongService;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    public SongController(ClientSongService clientSongService) {
        this.clientSongService = clientSongService;
    }


    @GetMapping
    public List<SongDto> getAllSongs(){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        return circuitBreaker.run(() -> clientSongService.getAllSongs());
    }
}
