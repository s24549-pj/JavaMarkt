package pl.pjait;

public class Invoice {
    private String productName;
    private int productAmonut;
    private double basePriceNetto;
    private double summedPriceNetto = productAmonut * basePriceNetto;
    private double vat;
    private double summedPriceBrutto;

    public Invoice(String productName, int productAmonut, double basePriceNetto, double summedPriceNetto,
                   double vat, double summedPriceBrutto) {
        this.productName = productName;
        this.productAmonut = productAmonut;
        this.basePriceNetto = basePriceNetto;
        this.summedPriceNetto = summedPriceNetto;
        this.vat = vat;
        this.summedPriceBrutto = summedPriceBrutto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductAmonut() {
        return productAmonut;
    }

    public void setProductAmonut(int productAmonut) {
        this.productAmonut = productAmonut;
    }

    public double getBasePriceNetto() {
        return basePriceNetto;
    }

    public void setBasePriceNetto(double basePriceNetto) {
        this.basePriceNetto = basePriceNetto;
    }

    public double getSummedPriceNetto() {
        return summedPriceNetto;
    }

    public void setSummedPriceNetto(double summedPriceNetto) {
        this.summedPriceNetto = summedPriceNetto;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getSummedPriceBrutto() {
        return summedPriceBrutto;
    }

    public void setSummedPriceBrutto(double summedPriceBrutto) {
        this.summedPriceBrutto = summedPriceBrutto;
    }

}
