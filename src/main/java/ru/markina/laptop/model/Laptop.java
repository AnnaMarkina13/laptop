package ru.markina.laptop.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Laptop extends Product {
    private final @NonNull String serialNumber;
    private final @NonNull Integer memory;
    private final @NonNull Integer hdSize;
    private final @NonNull Model model;

    private @NonNull OperatingSystem operatingSystem;

    public Laptop(
            @NonNull String barCodeNumber,
            @NonNull Category category,
            @NonNull String name,
            @NonNull Double price,
            @NonNull String serialNumber,
            @NonNull Integer memory,
            @NonNull Integer hdSize,
            @NonNull Model model,
            @NonNull OperatingSystem operatingSystem) {
        super(barCodeNumber, category, name, price);
        this.serialNumber = serialNumber;
        this.memory = memory;
        this.hdSize = hdSize;
        this.model = model;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return String.format(
                "Название: %s; Цена: %.2f; Модель: %s; ОЗУ: %dмб; HD: %dгб; Операционная система: %s",
                this.name, this.price, this.model.name(), this.memory, this.hdSize, this.operatingSystem.name()
        );
    }

    public enum Model {
        SAMSUNG,
        APPLE,
        HP,
        HUAWEI,
        ASUS,
        ACER
    }
}
