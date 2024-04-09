package com.esprit.examen.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest

public class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        // Given
        List<Stock> stocks = new ArrayList<>() ;
        stocks.add(new Stock(/* provide necessary constructor arguments */));
        stocks.add(new Stock(/* provide necessary constructor arguments */));
        when(stockRepository.findAll()).thenReturn(stocks);

        // When
        List<Stock> result = stockService.retrieveAllStocks();

        // Then
        assertEquals(2, result.size());
        // Add more assertions as needed
    }

    @Test
    public void testAddStock() {
        // Given
        Stock stock = new Stock(/* provide necessary constructor arguments */);
        when(stockRepository.save(stock)).thenReturn(stock);

        // When
        Stock result = stockService.addStock(stock);

        // Then
        assertEquals(stock, result);
        // Add more assertions as needed
    }
    @Test
    public void testDeleteStock() {
        // Given
        Long stockId = 1L;

        // When
        stockService.deleteStock(stockId);

        // Then
        verify(stockRepository, times(1)).deleteById(stockId);
    }

    @Test
    public void testUpdateStock() {
        // Given
        Stock stock = new Stock(/* provide necessary constructor arguments */);
        when(stockRepository.save(stock)).thenReturn(stock);

        // When
        Stock result = stockService.updateStock(stock);

        // Then
        assertEquals(stock, result);
        // Add more assertions as needed
    }

    @Test
    public void testRetrieveStock() {
        // Given
        Long stockId = 1L;
        Stock expectedStock = new Stock(/* provide necessary constructor arguments */);
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(expectedStock));

        // When
        Stock result = stockService.retrieveStock(stockId);

        // Then
        assertEquals(expectedStock, result);
    }


    // Add similar test methods for other service methods like deleteStock, updateStock, retrieveStock, retrieveStatusStock
}

