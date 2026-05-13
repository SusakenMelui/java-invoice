package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pl.edu.agh.mwo.invoice.product.InvoiceItem;
import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

    private List<InvoiceItem> products;


    static int NUMBER = 0;


    private final int number;

    public Invoice() {
        products = new ArrayList<>();
        number = NUMBER++;
    }

    public int getNumber() {
        return number;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }

        for (InvoiceItem item : products) {

            if (item.getProduct().getName().equals(product.getName())) {
                item.addMoreProduct(quantity);
                return;
            }
        }
        products.add((new InvoiceItem(product, quantity)));
    }

    public BigDecimal getSubtotal() {

        BigDecimal subtotal = BigDecimal.ZERO;

        for (InvoiceItem item : products) {
            BigDecimal price =
                    item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

            subtotal = subtotal.add(price);
        }

        return subtotal;
    }

    public BigDecimal getTax() {

        BigDecimal taxes = BigDecimal.ZERO;

        for (InvoiceItem item : products) {
            BigDecimal tax = item.getProduct().getPrice().multiply(item.getProduct().getTaxPercent())
                    .multiply(BigDecimal.valueOf(item.getQuantity()));


            taxes = taxes.add(tax);
        }
        return taxes;
    }

    public BigDecimal getTotal() {


        return getTax().add(getSubtotal());

    }


}


