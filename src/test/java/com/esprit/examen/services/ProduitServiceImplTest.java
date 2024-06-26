package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.ProduitServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProduitServiceImplTest {

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Test
    public void testRetrieveProduit() {
        Produit produit = new Produit();
        produit.setIdProduit(1L);
        produit.setLibelleProduit("Test Produit");
        when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));
        Produit retrievedProduit = produitService.retrieveProduit(1L);
        assertNotNull(retrievedProduit);
        assertEquals("Test Produit", retrievedProduit.getLibelleProduit());
    }

    @Test
    public void testAddProduit() {
        Produit produit = new Produit();
        produit.setLibelleProduit("Nouveau Produit");
        produit.setDateCreation(new Date());
        when(produitRepository.save(any(Produit.class))).thenReturn(produit);
        Produit savedProduit = produitService.addProduit(produit);
        assertNotNull(savedProduit);
        assertEquals("Nouveau Produit", savedProduit.getLibelleProduit());
        assertNotNull(savedProduit.getDateCreation());
    }

//    @Test
//    public void testDeleteProduit() {
//        Produit produit = new Produit();
//        produit.setIdProduit(1L);
//        when(produitRepository.existsById(1L)).thenReturn(true);
//        produitService.deleteProduit(1L);
//        verify(produitRepository, times(1)).deleteById(1L);
//    }

    @Test
    public void testAssignProduitToStock() {
        Produit produit = new Produit();
        produit.setIdProduit(1L);

        Stock stock = new Stock();
        stock.setIdStock(1L);

        when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));

        produitService.assignProduitToStock(1L, 1L);

        assertNotNull(produit.getStock());
        assertEquals(Long.valueOf(1L), produit.getStock().getIdStock());
    }
}
