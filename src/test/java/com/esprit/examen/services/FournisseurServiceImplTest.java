package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@SpringBootTest
public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Test
    public void testRetrieveAllFournisseurs() {
        // Given
        List<Fournisseur> fournisseurs = new ArrayList<>();
        // Ajoutez des fournisseurs fictifs à la liste
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
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // When
        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Then
        assertEquals(fournisseur, result);
        verify(detailFournisseurRepository, times(1)).save(any(DetailFournisseur.class));
        verify(fournisseurRepository, times(1)).save(fournisseur);
    }

    // Ajoutez d'autres tests pour les autres méthodes du service si nécessaire
}
