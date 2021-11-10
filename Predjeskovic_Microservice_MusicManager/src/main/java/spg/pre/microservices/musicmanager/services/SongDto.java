package spg.pre.microservices.musicmanager.services;

import spg.pre.microservices.musicmanager.domain.models.Artist;
import spg.pre.microservices.musicmanager.domain.documents.Song;

import java.time.LocalDate;

public record SongDto(String id, String musicTitle, String artistName, LocalDate createdOn) {

    public static SongDto fromMusic(Song music){
        return new SongDto(music.getId(), music.getMusicTitle(), music.getArtist().getArtistName(),
                music.createdOn);
    }

    public Song toMusic(){
        return Song.builder()
                .musicTitle(musicTitle)
                .artist(new Artist(artistName))
                .createdOn(createdOn)
                .build();
    }

}
