package org.example.conferenceservice.repository;

import org.example.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
