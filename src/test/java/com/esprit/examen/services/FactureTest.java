package com.esprit.examen.services;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FactureTest {
    @InjectMocks
    private FactureServiceImpl factureService;
    @Mock
    private FactureRepository factureRepository;
    @Test
    public void test_retrieve_all_factures() {
        // Arrange
        List<Facture> expectedFactures = new ArrayList<>();
        Facture facture1 = new Facture();
        Facture facture2 = new Facture();
        expectedFactures.add(facture1);
        expectedFactures.add(facture2);

        when(factureRepository.findAll()).thenReturn(expectedFactures);

        // Act
        List<Facture> actualFactures = factureService.retrieveAllFactures();

        // Assert
        assertEquals(expectedFactures, actualFactures);
        verify(factureRepository, times(1)).findAll();
    }
}
