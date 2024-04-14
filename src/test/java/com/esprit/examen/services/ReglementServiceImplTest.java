package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ReglementRepository;

public class ReglementServiceImplTest {

    @Mock
    private ReglementRepository reglementRepository;

    @Mock
    private FactureRepository factureRepository;

    @InjectMocks
    private ReglementServiceImpl reglementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllReglements() {
        List<Reglement> mockReglements = new ArrayList<>();
        // Ajouter des éléments factices à la liste mockée
        // par exemple : mockReglements.add(new Reglement());
        when(reglementRepository.findAll()).thenReturn(mockReglements);

        List<Reglement> result = reglementService.retrieveAllReglements();

        assertEquals(mockReglements, result);
    }

    @Test
    public void testAddReglement() {
        Reglement reglement = new Reglement();
        when(reglementRepository.save(reglement)).thenReturn(reglement);

        Reglement result = reglementService.addReglement(reglement);

        assertEquals(reglement, result);
    }

    @Test
    public void testRetrieveReglement() {
        Reglement expectedReglement = new Reglement();
        when(reglementRepository.findById(1L)).thenReturn(Optional.of(expectedReglement));

        Reglement result = reglementService.retrieveReglement(1L);

        assertEquals(expectedReglement, result);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        List<Reglement> mockReglements = new ArrayList<>();
        // Ajouter des éléments factices à la liste mockée
        // par exemple : mockReglements.add(new Reglement());
        when(reglementRepository.retrieveReglementByFacture(1L)).thenReturn(mockReglements);

        List<Reglement> result = reglementService.retrieveReglementByFacture(1L);

        assertEquals(mockReglements, result);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        float expectedChiffreAffaire = 1000.0f;
        // Ajouter la logique de simulation pour la méthode getChiffreAffaireEntreDeuxDate
        when(reglementRepository.getChiffreAffaireEntreDeuxDate(any(Date.class), any(Date.class))).thenReturn(expectedChiffreAffaire);

        float result = reglementService.getChiffreAffaireEntreDeuxDate(new Date(), new Date());

        assertEquals(expectedChiffreAffaire, result);
    }

    // Ajoutez d'autres tests pour chaque méthode de votre service

}
