package spg.pre.microservices.giraffobot.Services.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(value = "Calendar", url = "localhost:8081/Predjeskovic_Microservice_Calendar_1_0_SNAPSHOT_war")
public interface ClientCalendarService {


    @RequestMapping(method = RequestMethod.GET, value = "/calendar/getAll")
    List<NoteDto> getAllNotes();


}
