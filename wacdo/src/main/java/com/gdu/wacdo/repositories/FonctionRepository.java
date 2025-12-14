package com.gdu.wacdo.repositories;

import com.gdu.wacdo.entities.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long> {
}
