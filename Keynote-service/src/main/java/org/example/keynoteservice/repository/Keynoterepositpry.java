package org.example.keynoteservice.repository;

import org.example.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Keynoterepositpry extends JpaRepository<Keynote,Long> {
}
