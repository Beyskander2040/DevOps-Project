package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@RunWith(MockitoJUnitRunner.class)
public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    private Fournisseur fournisseur;
    private DetailFournisseur detailFournisseur;

    @Before
    public void setUp() {
        // Create a Fournisseur object
        fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(1L);
        fournisseur.setCode("F1");
        fournisseur.setLibelle("Fournisseur Test");

        // Create a DetailFournisseur object
        detailFournisseur = new DetailFournisseur();
        detailFournisseur.setIdDetailFournisseur(1L);
        detailFournisseur.setEmail("test@example.com");
        detailFournisseur.setDateDebutCollaboration(new Date());

        // Set the DetailFournisseur to the Fournisseur
        fournisseur.setDetailFournisseur(detailFournisseur);

        // Initialize the secteurActivites field with an empty set
        fournisseur.setSecteurActivites(new HashSet<>());
    }


    @Test
    public void testRetrieveAllFournisseurs() {
        // Mock the behavior of fournisseurRepository.findAll()
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(fournisseur);
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // Call the service method
        List<Fournisseur> retrievedFournisseurs = fournisseurService.retrieveAllFournisseurs();

        // Verify the result
        assertEquals(fournisseurs.size(), retrievedFournisseurs.size());
        assertEquals(fournisseur.getLibelle(), retrievedFournisseurs.get(0).getLibelle());
    }

    @Test
    public void testAddFournisseur() {
        // Mock the behavior of fournisseurRepository.save()
        when(fournisseurRepository.save(any())).thenReturn(fournisseur);

        // Call the service method
        Fournisseur savedFournisseur = fournisseurService.addFournisseur(fournisseur);

        // Verify the result
        assertNotNull(savedFournisseur);
        assertEquals(fournisseur, savedFournisseur);
    }

    @Test
    public void testUpdateFournisseur() {
        // Mock the behavior of fournisseurRepository.save()
        when(fournisseurRepository.save(any())).thenReturn(fournisseur);

        // Call the service method
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(fournisseur);

        // Verify the result
        assertNotNull(updatedFournisseur);
        assertEquals(fournisseur, updatedFournisseur);
    }

    @Test
    public void testDeleteFournisseur() {
        // Call the service method
        fournisseurService.deleteFournisseur(1L);

        // Verify that fournisseurRepository.deleteById() is called once
        verify(fournisseurRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testRetrieveFournisseur() {
        // Mock the behavior of fournisseurRepository.findById()
        when(fournisseurRepository.findById(1L)).thenReturn(Optional.of(fournisseur));

        // Call the service method
        Fournisseur retrievedFournisseur = fournisseurService.retrieveFournisseur(1L);

        // Verify the result
        assertNotNull(retrievedFournisseur);
        assertEquals(fournisseur, retrievedFournisseur);
    }

    /*
    @Test
    public void testAssignSecteurActiviteToFournisseur() {
        // Mock the behavior of fournisseurRepository.save() to capture the saved Fournisseur object
        when(fournisseurRepository.save(any())).thenAnswer(invocation -> {
            Fournisseur savedFournisseur = invocation.getArgument(0);
            // Ensure that the saved Fournisseur object has the same ID as the one passed to it
            savedFournisseur.setIdFournisseur(fournisseur.getIdFournisseur());
            return savedFournisseur;
        });

        // Mock the behavior of secteurActiviteRepository.findById()
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        when(secteurActiviteRepository.findById(1L)).thenReturn(Optional.of(secteurActivite));

        // Call the service method
        fournisseurService.assignSecteurActiviteToFournisseur(1L, 1L);

        // Verify that the secteurActivite is assigned to the fournisseur
        assertEquals(1, fournisseur.getSecteurActivites().size());
        assertEquals(secteurActivite, fournisseur.getSecteurActivites().iterator().next());
    }*/





}
