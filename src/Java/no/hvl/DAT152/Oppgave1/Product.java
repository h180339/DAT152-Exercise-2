package no.hvl.DAT152.Oppgave1;

import java.util.ResourceBundle;


/**
 * Class that describes a product
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class Product {
    private String pNo;
    private String pName;
    private String priceInEuro;
    private String imageFile;
    private String resourceKey;
    private int amount;
    private Double totalPrice;

    /**
     * Constructs new Product
     *
     * @param pNo
     * @param pName
     * @param priceInEuro
     * @param imageFile
     * @param resourceKey
     */
    public Product(String pNo, String pName, String priceInEuro, String imageFile, String resourceKey) {
        this.pNo = pNo;
        this.pName = pName;
        this.priceInEuro = priceInEuro;
        this.imageFile = imageFile;
        this.resourceKey = resourceKey;
        this.amount = 1;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addToTotalPrice(int addAmout) {
        this.totalPrice += addAmout;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(String priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String toString(ResourceBundle bundle) {
        return bundle.getString(this.getpName()) + " | " + bundle.getString(this.getPriceInEuro()) + " | " + bundle.getString(this.getResourceKey());
    }

    public boolean compareTo(Product product) {
        return this.pName.equals(product.getpName());
    }
}
