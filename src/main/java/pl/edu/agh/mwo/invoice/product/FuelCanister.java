package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FuelCanister extends Product {


    BigDecimal excise = new BigDecimal("5.56");

    protected FuelCanister(String name, BigDecimal price) {
        super(name, price, new BigDecimal(BigInteger.ZERO));
    }
    public BigDecimal getExcise() {
        return excise;
    }
}
