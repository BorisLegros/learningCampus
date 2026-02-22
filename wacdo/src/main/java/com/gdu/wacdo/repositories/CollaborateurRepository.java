package com.gdu.wacdo.repositories;

import com.gdu.wacdo.entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long> {
    Collaborateur getByEmail(String email);

    Optional<Collaborateur> findByEmail(String email);
}
