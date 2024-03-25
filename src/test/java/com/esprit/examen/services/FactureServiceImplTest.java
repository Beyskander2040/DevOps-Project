//package com.esprit.examen.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import org.junit.Before;
//import org.junit.Test;
//import com.esprit.examen.entities.DetailFacture;
//import com.esprit.examen.entities.Facture;
//import com.esprit.examen.entities.Produit;
//import com.esprit.examen.repositories.DetailFactureRepository;
//import com.esprit.examen.repositories.FactureRepository;
//import com.esprit.examen.repositories.ProduitRepository;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@RunWith(MockitoJUnitRunner.class)
//
//@SpringBootTest
//public class FactureServiceImplTest {
//
//    private FactureServiceImpl factureService;
//    private FactureRepository factureRepository;
//    private ProduitRepository produitRepository;
//    private DetailFactureRepository detailFactureRepository;
//
//    @Before
//    public void setUp() {
//        factureRepository = mock(FactureRepository.class);
//        produitRepository = mock(ProduitRepository.class);
//        detailFactureRepository = mock(DetailFactureRepository.class);
//        factureService = new FactureServiceImpl(factureRepository, produitRepository, detailFactureRepository);
//    }
//
//    @Test
//    public void testRetrieveAllFactures() {
//        // Mocking data
//        List<Facture> factures = new ArrayList<>();
//        factures.add(new Facture());
//        factures.add(new Facture());
//        when(factureRepository.findAll()).thenReturn(factures);
//
//        // Testing the method
//        List<Facture> result = factureService.retrieveAllFactures();
//
//        // Assertions
//        assertNotNull(result);
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    public void testAddFacture() {
//        // Mocking data
//        Facture facture = new Facture();
//        when(factureRepository.save(facture)).thenReturn(facture);
//
//        // Testing the method
//        Facture result = factureService.addFacture(facture);
//
//        // Assertions
//        assertNotNull(result);
//    }
//
////    @Test
////    public void testCancelFacture() {
////        // Mocking data
////        Long factureId = 1L;
////        Facture facture = new Facture();
////        facture.setIdFacture(factureId);
////        when(factureRepository.findById(factureId)).thenReturn(java.util.Optional.of(facture));
////
////        // Testing the method
////        factureService.cancelFacture(factureId);
////
////        // Assertions
////        assertEquals(true, facture.isArchivee());
////    }
//
//    @Test
//    public void testRetrieveFacture() {
//        // Mocking data
//        Long factureId = 1L;
//        Facture facture = new Facture();
//        facture.setIdFacture(factureId);
//        when(factureRepository.findById(factureId)).thenReturn(java.util.Optional.of(facture));
//
//        // Testing the method
//        Facture result = factureService.retrieveFacture(factureId);
//
//        // Assertions
//        assertNotNull(result);
//        assertEquals(factureId, result.getIdFacture());
//    }
//
//    // Add other test methods as needed...
//}
