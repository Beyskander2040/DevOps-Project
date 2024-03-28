package com.esprit.examen.services;

import static org.junit.Assert.*;
<<<<<<< HEAD
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
=======
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

@ExtendWith(SpringExtension.class)

public class StockServiceImplTest {
    @Mock
    private IStockService stockService;

    @Test
    public void testAddStock() {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testAddStockOptimized() {

        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);
        assertNotNull(savedStock.getIdStock());
        assertSame(10, savedStock.getQte());
        assertTrue(savedStock.getQteMin()>0);
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testDeleteStock() {
        Stock s = new Stock("stock test",30,60);
        Stock savedStock= stockService.addStock(s);
        stockService.deleteStock(savedStock.getIdStock());
        assertNull(stockService.retrieveStock(savedStock.getIdStock()));
    }

}
>>>>>>> 77d303792fc7bc1a61377e13cbbdf005e3536264
