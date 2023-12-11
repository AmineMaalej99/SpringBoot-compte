package tn.iit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.iit.model.Compte;




public interface CompteRepository extends JpaRepository<Compte, Long> {
    
}
