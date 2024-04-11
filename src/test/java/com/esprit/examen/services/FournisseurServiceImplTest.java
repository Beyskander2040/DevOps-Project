package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@SpringBootTest
public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Test
    public void testRetrieveAllFournisseurs() {
        // Given
        List<Fournisseur> fournisseurs = new ArrayList<>();
        // Add some dummy suppliers to the list
        fournisseurs.add(new Fournisseur());
        fournisseurs.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // When
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Then
        assertEquals(2, result.size());
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    public void testAddFournisseur() {
        // Given
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // When
        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Then
        assertEquals(fournisseur, result);
        verify(fournisseurRepository, times(1)).save(fournisseur);
    }

    // Add other tests for other service methods if needed
}
