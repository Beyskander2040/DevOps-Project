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

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@Mock
	private StockRepository stockRepository;

	@InjectMocks
	private StockServiceImpl stockService;

	private Stock stock;

	@Before
	public void setUp() {
		stock = new Stock("stock test", 10, 100);
	}

	@Test
	public void testRetrieveAllStocks() {
		List<Stock> stocks = new ArrayList<>();
		stocks.add(stock);

		when(stockRepository.findAll()).thenReturn(stocks);

		List<Stock> retrievedStocks = stockService.retrieveAllStocks();

		assertEquals(stocks.size(), retrievedStocks.size());
		assertEquals(stock.getLibelleStock(), retrievedStocks.get(0).getLibelleStock());
	}

	@Test
	public void testAddStock() {
		when(stockRepository.save(stock)).thenReturn(stock);

		Stock savedStock = stockService.addStock(stock);

		assertNotNull(savedStock);
		assertEquals(stock.getLibelleStock(), savedStock.getLibelleStock());
	}
}
