package spg.pre.microservices.musicmanager.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spg.pre.microservices.musicmanager.domain.Exceptions.ServiceException;
import spg.pre.microservices.musicmanager.persistence.SongRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service @Transactional(rollbackFor = ServiceException.class)
public class SongService {

    private final SongRepository musicRepository;

    public SongService(SongRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<SongDto> getAllSongs(){
        return StreamSupport.stream(musicRepository.findAll().spliterator(),false)
                .map(SongDto::fromMusic)
                .collect(Collectors.toList());
    }

    public SongDto getOneSong(String id){
        return musicRepository.findById(id)
                .map(SongDto::fromMusic)
                .orElseThrow(()->
                        new ServiceException("Music can not be found"));
    }

    public SongDto addMusic(SongDto musicDto){
        var music = Optional.ofNullable(musicDto)
                .map(SongDto:: toMusic)
                .map(musicRepository::insert)
                .map(SongDto:: fromMusic)
                .orElseThrow(()->
                        new ServiceException("Music can not be added"));

        return music;
    }

    public void partialUpdate(String id, String fieldName, String fieldValue){
        musicRepository.partialUpdate(id,fieldName,fieldValue);
    }

    public void deleteMusic(String id) throws ServiceException {
        var song = getOneSong(id);
        musicRepository.deleteById(id);
    }
}
