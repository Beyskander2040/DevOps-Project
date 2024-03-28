package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        // Création de données de test
        Stock stock1 = new Stock("Stock 1", 10, 20);
        Stock stock2 = new Stock("Stock 2", 15, 25);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);

        // Mock du comportement attendu du repository
        when(stockRepository.findAll()).thenReturn(stocks);

        // Appel de la méthode à tester
        List<Stock> result = stockService.retrieveAllStocks();

        // Vérification du résultat
        assertEquals(2, result.size());
        assertEquals("Stock 1", result.get(0).getLibelleStock());
        assertEquals("Stock 2", result.get(1).getLibelleStock());
    }

    @Test
    public void testAddStock() {
        // Création de données de test
        Stock stock = new Stock("Stock test", 10, 20);

        // Mock du comportement attendu du repository
        when(stockRepository.save(stock)).thenReturn(stock);

        // Appel de la méthode à tester
        Stock result = stockService.addStock(stock);

        // Vérification du résultat
        assertNotNull(result);
        assertEquals("Stock test", result.getLibelleStock());
    }

    // Ajoutez d'autres méthodes de test pour couvrir les autres méthodes de StockServiceImpl
}
