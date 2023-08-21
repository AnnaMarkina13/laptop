package ru.markina.laptop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = { "barCodeNumber" })
@ToString
@Getter
@Setter
public abstract class Product {
    protected final @NonNull String barCodeNumber;
    protected final @NonNull Category category;

    protected @NonNull String name;
    protected @NonNull Double price;
}
