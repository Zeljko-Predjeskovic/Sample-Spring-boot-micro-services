package spg.pre.microservices.giraffobot.Services.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(name = "Giraffobot-MusicManager")
public interface ClientSongService {

    @RequestMapping(method = RequestMethod.GET, value = "/music")
    List<SongDto> getAllSongs();

}
