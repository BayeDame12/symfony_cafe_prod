package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Stock;
import com.example.cafetoubamarakhib.repository.StockRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock stock) {
        return null;
    }

    @Override
    public Stock updateStock(long id, Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(long id) {
       Stock stock=stockRepository.findById(id)
               .orElseThrow(()->new RuntimeException("la stock que vous tenter de supprimer existent pas"));
       stockRepository.delete(stock);
    }

    @Override
    public Stock getStockById(long id) {
        Optional<Stock>result=stockRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else {
            throw new ResourceNotFoundException("la Stock que vous chercher n existe pas");
        }
    }
}
