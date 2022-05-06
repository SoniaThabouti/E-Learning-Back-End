package ElearningBack.controller;


import ElearningBack.exception.ResourceNotFoundException;
import ElearningBack.model.SchoolEvent;
import ElearningBack.repository.SchoolEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class SchoolEventController {

    @Autowired
    private SchoolEventRepository schoolEventRepository;

    //get all events
    @GetMapping("/schoolevents")
    public List<SchoolEvent> getAllEvents(){
        return schoolEventRepository.findAll();
    }

    //create a new event rest api
    @PostMapping("/schoolevents")
    public SchoolEvent createEvent(@Valid @RequestBody SchoolEvent schoolEvent){
        return schoolEventRepository.save(schoolEvent);
    }

    //get event by id rest api & return error if not found
    @GetMapping("/schoolevents/{id}")
    public ResponseEntity<SchoolEvent> getEventById(@PathVariable Long id){
        SchoolEvent schoolEvent = schoolEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("event does not exist with this id: "+ id));
        return ResponseEntity.ok(schoolEvent);
    }

    //update event rest api
    @PutMapping("/schoolevents/{id}")
    public ResponseEntity<SchoolEvent> updateEvent(@PathVariable Long id, @Valid @RequestBody SchoolEvent schoolEventDetails) {
        SchoolEvent schoolEvent = schoolEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("event not exists wih id :" + id));

       schoolEvent.setDayEvent(schoolEventDetails.getDayEvent());
       schoolEvent.setMonthEvent(schoolEventDetails.getMonthEvent());
       schoolEvent.setYearEvent(schoolEvent.getYearEvent());
       schoolEvent.setLink(schoolEventDetails.getLink());
       schoolEvent.setDescription(schoolEventDetails.getDescription());
       schoolEvent.setNameEvent(schoolEventDetails.getNameEvent());
       schoolEvent.setDuration(schoolEventDetails.getDuration());

        SchoolEvent updatedSchoolEvent = schoolEventRepository.save(schoolEvent);
        return ResponseEntity.ok(updatedSchoolEvent);
    }

    //delete event rest api
    @DeleteMapping("/schoolevents/{id}")
    public ResponseEntity <Map<String,Boolean>>  deleteEvent(@PathVariable Long id){
        SchoolEvent schoolEvent = schoolEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("event not exists with id:" + id));
        schoolEventRepository.delete(schoolEvent);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }


}
