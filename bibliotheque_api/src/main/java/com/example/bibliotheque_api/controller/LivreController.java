package com.example.bibliotheque_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotheque_api.service.LivreService;
import com.example.bibliotheque_api.entities.Livre;


@RestController
@RequestMapping("/emsi_api/livres")
public class LivreController {

	private LivreService livreService;

	public LivreController(LivreService livreService) {
		super();
		this.livreService = livreService;
	}
	// build create Livre REST API
	@PostMapping()
	public ResponseEntity<Livre> saveLivre(@RequestBody Livre livre){
		return new ResponseEntity<Livre>(livreService.saveLivre(livre), HttpStatus.CREATED);
		
	}
	
	//build get all Livres REST API
	@GetMapping
	public List<Livre> getAllLivres(){
		return livreService.getAllLivres();
	}
	
	// build get Livre by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Livre> getLivreById(@PathVariable("id") long livreId){
			return new ResponseEntity<Livre>(livreService.getLivreById(livreId),HttpStatus.OK);
	}
	
	//build update Livre REST IPA
	//http://localhost:8080/Livres/1
	@PostMapping("{id}")
	public ResponseEntity<Livre> updateLivre(@PathVariable("id") long id ,@RequestBody Livre livre){
		return new ResponseEntity<Livre>(livreService.updateLivre(livre,id),HttpStatus.OK);
	}
	
	//build delete Livre REST IPA
	//http://localhost:8080/Livre/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLivre(@PathVariable("id") long id){
		
		//delete livre from DB
		livreService.deleteLivre(id);
		return new ResponseEntity<String>("Livre deleted successfully!",HttpStatus.OK);
	}
	
	
}
