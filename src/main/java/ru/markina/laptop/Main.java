package ru.markina.laptop;

import ru.markina.laptop.repository.LaptopFilter;
import ru.markina.laptop.repository.LaptopRepository;

public class Main {
    public static void main(String[] args) {
        LaptopRepository laptopRepository = new LaptopRepository();
        //не стала ничего придумывать сложного, просто не смогла найти, как вызвать forEach с индексом(((
        final var index = new int[]{ 1 };
        laptopRepository.products(
                LaptopFilter.builder()
                        .minPrice(1000.0)
                        .maxPrice(100000.0)
                        .minMemory(2000)
                        .maxHdSize(1024)
                        .build()
        ).forEach(l -> System.out.println(index[0]++ + ".\t " + l.toString()));
    }
}
