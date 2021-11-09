package spg.pre.microservices.musicmanager.services;

import spg.pre.microservices.musicmanager.domain.documents.Artist;
import spg.pre.microservices.musicmanager.domain.documents.Music;

import java.time.LocalDate;
import java.util.Optional;

public record MusicDto(Long id, String musicTitle, String artistName, LocalDate createdOn) {

    public static MusicDto fromMusic(Music music){
        return new MusicDto(music.getId(), music.getMusicTitle(), music.getArtist().getArtistName(),
                music.createdOn);
    }

    public Music toMusic(){
        return Music.builder()
                .musicTitle(musicTitle)
                .artist(new Artist(artistName))
                .createdOn(createdOn)
                .build();
    }

}
