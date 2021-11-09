package spg.pre.microservices.musicmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spg.pre.microservices.musicmanager.domain.Exceptions.ServiceException;
import spg.pre.microservices.musicmanager.persistence.MusicRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service @Transactional(rollbackFor = ServiceException.class)
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<MusicDto> getAllSongs(){
        return StreamSupport.stream(musicRepository.findAll().spliterator(),false)
                .map(MusicDto::fromMusic)
                .collect(Collectors.toList());
    }

    public MusicDto getOneSong(Long id){
        return musicRepository.findById(id)
                .map(MusicDto::fromMusic)
                .orElseThrow(()->
                        new ServiceException("Music can not be found"));
    }

    public MusicDto addMusic(MusicDto musicDto){
        var music = Optional.ofNullable(musicDto)
                .map(MusicDto :: toMusic)
                .map(musicRepository::insert)
                .map(MusicDto :: fromMusic)
                .orElseThrow(()->
                        new ServiceException("Music can not be added"));

        return music;
    }

    public void deleteMusic(Long id) throws ServiceException {
        var song = getOneSong(id);
        musicRepository.deleteById(id);
    }
}
