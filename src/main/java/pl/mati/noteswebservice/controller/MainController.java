package pl.mati.noteswebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mati.noteswebservice.model.Note;
import pl.mati.noteswebservice.repository.NotesRepository;

@Controller
public class MainController {

    private final NotesRepository notesRepository;

    @Autowired
    public MainController(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("notes", notesRepository.findAll());
        return "greeting";
    }

    @PostMapping("/")
    public String greetingSubmit(Model model, @ModelAttribute("noteform") Note newNote) {
        notesRepository.save(newNote);
        model.addAttribute("notes", notesRepository.findAll());
        return "greeting";
    }

}
