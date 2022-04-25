package com.example.bibliotheque_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotheque_api.entities.Livre;
import com.example.bibliotheque_api.repos.LivreRepo;
import com.example.bibliotheque_api.service.LivreService;



@Service
public class LivreService{
	
	@Autowired
	private LivreRepo livreRepo;



	public Livre saveLivre(Livre livre) {
		return livreRepo.save(livre);
	}

	public List<Livre> getAllLivres(){
		return livreRepo.findAll();
	}
	

	public Livre getLivreById(long id) {
		Optional<Livre> livre = livreRepo.findById(id);
		if(livre.isPresent()) {
			return livre.get();
		}
		return null;
		
	}

	
	public Livre updateLivre(Livre livre,long id) {
		Livre existingLivre = livreRepo.findById(id).orElseThrow(null);
		
		existingLivre.setTitre(livre.getTitre());
		existingLivre.setDateDeSortie(livre.getDateDeSortie());
		existingLivre.setAuteur(livre.getAuteur());
		existingLivre.setNombreDePage(livre.getNombreDePage());
		existingLivre.setDisponible(livre.isDisponible());
		// save existingLivre to DB
		livreRepo.save(existingLivre);
		return existingLivre;
		
		
	}


	public void deleteLivre(long id) {
		livreRepo.findById(id).orElseThrow(null);
		livreRepo.deleteById(id);
		
	}
	
}
