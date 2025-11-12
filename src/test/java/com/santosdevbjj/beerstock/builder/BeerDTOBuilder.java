package com.santosdevbjj.beerstock.builder;

import com.santosdevbjj.beerstock.dto.BeerDTO;

public class BeerDTOBuilder {

    private Long id = 1L;
    private String name = "Heineken";
    private String brand = "Heineken";
    private int max = 50;
    private int quantity = 10;

    public BeerDTOBuilder() {}

    public BeerDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public BeerDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BeerDTOBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public BeerDTOBuilder withMax(int max) {
        this.max = max;
        return this;
    }

    public BeerDTOBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BeerDTO build() {
        return new BeerDTO(id, name, brand, max, quantity);
    }
}
