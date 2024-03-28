package com.esprit.examen.services;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for (Produit produit : produits) {
			log.info(" Produit : " + produit);
		}
		return produits;
	}

	@Transactional
	public Produit addProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
<<<<<<< HEAD
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

=======
	public Produit updateProduit(Produit updatedProduit) {
		Produit existingProduit = produitRepository.findById(updatedProduit.getIdProduit()).orElse(null);
		if (existingProduit != null) {
			existingProduit.setLibelleProduit(updatedProduit.getLibelleProduit());
			existingProduit.setPrix(updatedProduit.getPrix());

			return produitRepository.save(existingProduit);
		} else {
			// Gérer le cas où le produit n'est pas trouvé
			return null;
		}
	}


>>>>>>> 77d303792fc7bc1a61377e13cbbdf005e3536264
	@Override
	public Produit retrieveProduit(Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		log.info("produit :" + produit);
		return produit;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		produit.setStock(stock);
		produitRepository.save(produit);

	}


<<<<<<< HEAD
=======

>>>>>>> 77d303792fc7bc1a61377e13cbbdf005e3536264
}