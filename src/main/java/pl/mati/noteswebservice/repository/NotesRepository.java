package pl.mati.noteswebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mati.noteswebservice.model.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}
