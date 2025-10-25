package org.example.conferenceservice.web;

import org.example.conferenceservice.entities.Conference;
import org.example.conferenceservice.repository.ConferenceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceRestController {

    private final ConferenceRepository conferenceRepository;

    public ConferenceRestController(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Conference getConferenceById(@PathVariable Long id) {
        return conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference id " + id + " not found"));
    }

    @PostMapping
    public Conference createConference(@RequestBody Conference conference) {
        return conferenceRepository.save(conference);
    }

    @PutMapping("/{id}")
    public Conference updateConference(@PathVariable Long id, @RequestBody Conference conferenceDetails) {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference id " + id + " not found"));

        conference.setTitre(conferenceDetails.getTitre());
        conference.setType(conferenceDetails.getType());
        conference.setDate(conferenceDetails.getDate());
        conference.setDuree(conferenceDetails.getDuree());
        conference.setNbrinscrit(conferenceDetails.getNbrinscrit());
        conference.setScore(conferenceDetails.getScore());
        conference.setReviews(conferenceDetails.getReviews());

        return conferenceRepository.save(conference);
    }

    @DeleteMapping("/{id}")
    public void deleteConference(@PathVariable Long id) {
        conferenceRepository.deleteById(id);
    }
}
