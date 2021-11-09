package spg.pre.microservices.musicmanager.controller;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spg.pre.microservices.musicmanager.services.MusicDto;
import spg.pre.microservices.musicmanager.services.MusicService;

import java.util.List;

@RestController @RequestMapping(MusicController.MUSIC_ROUTE)
public class MusicController {

    public static final String MUSIC_ROUTE = "/music";

    public final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public List<MusicDto> getAllSongs(){
        return  musicService.getAllSongs();
    }

    @GetMapping(path = "/{id}")
    public MusicDto getOneSongById(@PathVariable @NonNull Long id){
        return musicService.getOneSong(id);
    }

    @PostMapping
    public MusicDto addMusic(@RequestBody MusicDto musicDto){
        return musicService.addMusic(musicDto);
    }

    @DeleteMapping({"/{id}"})
    public void deleteMusic(@PathVariable Long id){
        musicService.deleteMusic(id);
    }




}
