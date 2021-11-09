package spg.pre.microservices.musicmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spg.pre.microservices.musicmanager.domain.Exceptions.ServiceException;
import spg.pre.microservices.musicmanager.repository.MusicRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<MusicDto> getAllSongs(){
        return StreamSupport.stream(musicRepository.findAll().spliterator(),false)
                .map(MusicDto::fromMusic)
                .collect(Collectors.toList());
    }
}
