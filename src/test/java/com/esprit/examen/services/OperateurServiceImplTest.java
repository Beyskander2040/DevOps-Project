package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

public class OperateurServiceImplTest {

    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllOperateurs() {
        // Create a list of operateurs
        List<Operateur> operateurs = new ArrayList<>();
        operateurs.add(new Operateur(1L, "Operator1"));
        operateurs.add(new Operateur(2L, "Operator2"));

        // Mock the behavior of the repository
        when(operateurRepository.findAll()).thenReturn(operateurs);

        // Call the service method
        List<Operateur> result = operateurService.retrieveAllOperateurs();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddOperateur() {
        // Create a new operateur
        Operateur newOperateur = new Operateur(1L, "Operator1");

        // Mock the behavior of the repository
        when(operateurRepository.save(any(Operateur.class))).thenReturn(newOperateur);

        // Call the service method
        Operateur result = operateurService.addOperateur(newOperateur);

        // Verify the result
        assertNotNull(result);
        assertEquals(newOperateur, result);
    }

    @Test
    public void testDeleteOperateur() {
        // Call the service method
        operateurService.deleteOperateur(1L);

        // Verify that deleteById method of repository is called with correct argument
        verify(operateurRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateOperateur() {
        // Create an operateur to update
        Operateur updatedOperateur = new Operateur(1L, "UpdatedOperator");

        // Mock the behavior of the repository
        when(operateurRepository.save(any(Operateur.class))).thenReturn(updatedOperateur);

        // Call the service method
        Operateur result = operateurService.updateOperateur(updatedOperateur);

        // Verify the result
        assertNotNull(result);
        assertEquals(updatedOperateur, result);
    }

    @Test
    public void testRetrieveOperateur_ExistingId() {
        // Create a mock operateur
        Operateur mockOperateur = new Operateur(1L, "MockOperator");

        // Mock the behavior of the repository
        when(operateurRepository.findById(1L)).thenReturn(Optional.of(mockOperateur));

        // Call the service method
        Operateur result = operateurService.retrieveOperateur(1L);

        // Verify the result
        assertNotNull(result);
        assertEquals(mockOperateur, result);
    }

    @Test
    public void testRetrieveOperateur_NonExistingId() {
        // Mock the behavior of the repository
        when(operateurRepository.findById(1L)).thenReturn(Optional.empty());

        // Call the service method
        Operateur result = operateurService.retrieveOperateur(1L);

        // Verify the result
        assertNull(result);
    }
}
