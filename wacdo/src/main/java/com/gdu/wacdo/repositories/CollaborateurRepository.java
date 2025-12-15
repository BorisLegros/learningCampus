package com.gdu.wacdo.repositories;

import com.gdu.wacdo.entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long> {
}
