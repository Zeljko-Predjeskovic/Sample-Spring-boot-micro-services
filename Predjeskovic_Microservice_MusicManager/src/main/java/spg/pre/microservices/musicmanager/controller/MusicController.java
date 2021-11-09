package spg.pre.microservices.musicmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spg.pre.microservices.musicmanager.services.MusicService;

@RestController
@RequestMapping(MusicController.MUSIC_ROUTE)
public class MusicController {

    public static final String MUSIC_ROUTE = "/music";



    public final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }
}
