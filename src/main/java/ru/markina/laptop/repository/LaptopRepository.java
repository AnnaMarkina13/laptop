package ru.markina.laptop.repository;

import ru.markina.laptop.model.Category;
import ru.markina.laptop.model.Laptop;
import ru.markina.laptop.model.OperatingSystem;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LaptopRepository implements ProductRepository<Laptop, LaptopFilter>{

    private final Set<Laptop> laptops;

    public LaptopRepository() {
        final var random = new Random();
        this.laptops = Stream.generate(() -> {
            final var model = Laptop.Model.values()[random.nextInt(Laptop.Model.values().length)];
            final var os = OperatingSystem.values()[random.nextInt(OperatingSystem.values().length)];
            final var number = UUID.randomUUID().toString();
            return new Laptop(
                    number.replace("-", ""),
                    Category.LAPTOP_AND_PC,
                    model.name() + " Laptop x" + random.nextInt(100),
                    random.nextInt(5000, 100000) + 0.99,
                    number,
                    (int) Math.pow(2, random.nextInt(10, 13)),
                    (int) Math.pow(2, random.nextInt(8, 10)),
                    model,
                    os
            );
        }).limit(20).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public List<Laptop> products(LaptopFilter filter) {
        return this.laptops.stream()
                .filter(filter.priceFilter())
                .filter(filter.memoryFilter())
                .filter(filter.hdSizeFilter())
                .filter(filter.modelFilter())
                .filter(filter.operatingSystemFilter())
                .sorted(Comparator.comparing(Laptop::getPrice))
                .toList();
    }
}
