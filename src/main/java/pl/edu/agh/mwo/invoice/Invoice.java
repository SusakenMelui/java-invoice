package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products;


    public Invoice() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product== null ) throw new IllegalArgumentException();
        products.add(product);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity <= 0) throw new IllegalArgumentException();

        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Product product : products) {
            subtotal = subtotal.add(product.getPrice());
        }

        return subtotal;
    }

    public BigDecimal getTax() {

        BigDecimal taxes = BigDecimal.ZERO;
        for (Product product : products) {
            BigDecimal tax = product.getPrice().multiply(product.getTaxPercent());
            taxes = taxes.add(tax);
        }
        return taxes;
    }

    public BigDecimal getTotal() {


        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getPriceWithTax());
        }
        return total;
    }
}
