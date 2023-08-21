package ru.markina.laptop.repository;

import ru.markina.laptop.model.Product;

import java.util.List;

public interface ProductRepository<T extends Product, F extends ProductFilter> {

    List<T> products(F filter);
}
