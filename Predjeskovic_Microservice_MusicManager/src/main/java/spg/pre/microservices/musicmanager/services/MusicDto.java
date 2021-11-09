package spg.pre.microservices.musicmanager.services;

import spg.pre.microservices.musicmanager.domain.documents.Music;

import java.time.LocalDate;

public record MusicDto(String musicTitle, String artistName, LocalDate createdOn) {

    public static MusicDto fromMusic(Music music){
        return new MusicDto(music.getMusicTitle(), music.getArtist().getArtistName(),
                music.createdOn);
    }

}
