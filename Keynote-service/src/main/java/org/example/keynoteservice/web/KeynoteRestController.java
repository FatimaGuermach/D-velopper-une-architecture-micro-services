package org.example.keynoteservice.web;

import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.repository.KeynoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteRestController {

    private final KeynoteRepository keynoteRepository;

    public KeynoteRestController(KeynoteRepository keynoteRepository) {
        this.keynoteRepository = keynoteRepository;
    }

    @GetMapping
    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Keynote getKeynoteById(@PathVariable Long id) {
        return keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote id " + id + " not found"));
    }

    @PostMapping
    public Keynote createKeynote(@RequestBody Keynote keynote) {
        return keynoteRepository.save(keynote);
    }

    @PutMapping("/{id}")
    public Keynote updateKeynote(@PathVariable Long id, @RequestBody Keynote keynoteDetails) {
        Keynote keynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote id " + id + " not found"));

        keynote.setNom(keynoteDetails.getNom());
        keynote.setPrenom(keynoteDetails.getPrenom());
        keynote.setEmail(keynoteDetails.getEmail());
        keynote.setFonction(keynoteDetails.getFonction());

        return keynoteRepository.save(keynote);
    }

    @DeleteMapping("/{id}")
    public void deleteKeynote(@PathVariable Long id) {
        keynoteRepository.deleteById(id);
    }
}
