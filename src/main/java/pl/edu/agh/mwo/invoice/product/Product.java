package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;


    protected Product(String name, BigDecimal price, BigDecimal tax) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;

        if (price == null || price.signum() == -1) {
            throw new IllegalArgumentException();
        }
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return this.price.add(this.price.multiply(this.taxPercent));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        if (!name.equals(product.name)) {
            return false;
        }
        if (!price.equals(product.price)) {
            return false;
        }
        return Objects.equals(taxPercent, product.taxPercent);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + (taxPercent != null ? taxPercent.hashCode() : 0);
        return result;
    }
}
