package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@RunWith(MockitoJUnitRunner.class)
public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    private Fournisseur fournisseur;

    @Before
    public void setUp() {
        fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(1L);
        fournisseur.setCode("F1");
        fournisseur.setLibelle("Fournisseur Test");
        // Set other properties as needed
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(fournisseur);

        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        List<Fournisseur> retrievedFournisseurs = fournisseurService.retrieveAllFournisseurs();

        assertEquals(fournisseurs.size(), retrievedFournisseurs.size());
        assertEquals(fournisseur.getLibelle(), retrievedFournisseurs.get(0).getLibelle());
    }

    @Test
    public void testAddFournisseur() {
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        Fournisseur savedFournisseur = fournisseurService.addFournisseur(fournisseur);

        assertNotNull(savedFournisseur);
        assertEquals(fournisseur.getLibelle(), savedFournisseur.getLibelle());
    }
}
