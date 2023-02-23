package com.example.cafetoubamarakhib.service;

import com.example.cafetoubamarakhib.model.Cafe;
import com.example.cafetoubamarakhib.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStock();
    Stock addStock(Stock stock);
    Stock updateStock(long id, Stock stock);
    void deleteStock(long id);
    Stock getStockById(long id);

}
