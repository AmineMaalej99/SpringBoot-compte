package tn.iit.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import tn.iit.exception.RessourceNotFoundException;
import tn.iit.model.Compte;
import tn.iit.repository.CompteRepository;

@RestController
@RequestMapping("/api/v1/")
public class CompteController {

	@Autowired
	private CompteRepository compteRep;
	
	
	@GetMapping("/comptes")
	public List <Compte> getAllComptes(){
		return compteRep.findAll();
	}
	
		@PostMapping("/comptes")
		public Compte createCompte(@RequestBody Compte compte) {
			return compteRep.save(compte);
		}
		
	
		@GetMapping("/comptes/{id}")
		public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
		    Compte compte = compteRep.findById(id)
		            .orElseThrow(() -> new RessourceNotFoundException("Compte not found with id: " + id));
		    
		    return ResponseEntity.ok(compte);
		}
		
		
		@PutMapping("/comptes/{id}")
		public ResponseEntity<Compte> updateCompte(@PathVariable Long id , @RequestBody Compte compteDetails) {
		    Compte compte = compteRep.findById(id)
		            .orElseThrow(() -> new RessourceNotFoundException("Compte not found with id: " + id));
		    
		    compte.setNomClient( compteDetails.getNomClient());
		    compte.setPrenomClient( compteDetails.getPrenomClient());
		    compte.setAdresseClient( compteDetails.getAdresseClient());
		    compte.setSolde( compteDetails.getSolde());
		    compte.setRib( compteDetails.getRib());
		  
		    Compte updatedCompte = compteRep.save(compte);
		    return ResponseEntity.ok(updatedCompte);
		}
		
		@DeleteMapping("/comptes/{id}")
		public ResponseEntity<Map<String, Boolean>>deleteCompte(@PathVariable Long id){
			 Compte compte = compteRep.findById(id)
			            .orElseThrow(() -> new RessourceNotFoundException("Compte not found with id: " + id));
			 compteRep.delete(compte);
			 Map<String, Boolean> response = new HashMap<>();
			 response.put("deleted", Boolean.TRUE);
			 return ResponseEntity.ok(response);
			    
		}
	

}
