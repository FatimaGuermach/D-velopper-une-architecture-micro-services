package org.example.keynoteservice.repository;

import org.example.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface KeynoteRepository extends JpaRepository<Keynote,Long> {

}
