package ru.markina.laptop.repository;

import lombok.Builder;
import lombok.Getter;
import ru.markina.laptop.model.Laptop;
import ru.markina.laptop.model.OperatingSystem;
import ru.markina.laptop.model.Product;

import java.util.function.Function;
import java.util.function.Predicate;

@Builder
@Getter
public class LaptopFilter implements ProductFilter {

    private Double minPrice;
    private Double maxPrice;

    private Integer minMemory;
    private Integer maxMemory;

    private Integer minHdSize;
    private Integer maxHdSize;

    private Laptop.Model model;
    private OperatingSystem operatingSystem;

    public Predicate<Laptop> priceFilter() {
        return filterBetween(minPrice, maxPrice, Product::getPrice);
    }

    public Predicate<Laptop> memoryFilter() {
        return filterBetween(minMemory, maxMemory, Laptop::getMemory);
    }

    public Predicate<Laptop> hdSizeFilter() {
        return filterBetween(minHdSize, maxHdSize, Laptop::getHdSize);
    }

    public Predicate<Laptop> modelFilter() {
        if (this.model != null) {
            return laptop -> laptop.getModel().equals(this.model);
        } else {
            return laptop -> true;
        }
    }

    public Predicate<Laptop> operatingSystemFilter() {
        if (this.operatingSystem != null) {
            return laptop -> laptop.getOperatingSystem().equals(this.operatingSystem);
        } else {
            return laptop -> true;
        }
    }

    private <T extends Comparable<T>> Predicate<Laptop> filterBetween(T from, T to, Function<Laptop, T> valueProvider) {
        if (from != null) {
            if (to != null) {
                return laptop -> valueProvider.apply(laptop).compareTo(from) >= 0 && valueProvider.apply(laptop).compareTo(to) <= 0;
            } else {
                return laptop -> valueProvider.apply(laptop).compareTo(from) >= 0;
            }
        } else if (to != null) {
            return laptop -> valueProvider.apply(laptop).compareTo(to) <= 0;
        } else {
            return laptop -> true;
        }
    }
}
