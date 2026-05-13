package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends Product {

    BigDecimal excise = new BigDecimal("5.56");
    protected BottleOfWine(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
    }

    public BigDecimal getExcise() {
        return excise;
    }
}
