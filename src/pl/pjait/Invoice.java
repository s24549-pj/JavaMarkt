package pl.pjait;

import java.util.ArrayList;

public class Invoice {


    private String productName;
    private int productAmonut;
    private double basePriceNetto;
    private double summedPriceNetto = productAmonut * basePriceNetto;
    private double vat;
    private double summedPriceBrutto;
    private int dateOfInvoice;
    private int dateOfPayment;
    private int invoiceNumber;

    private ArrayList<InvoicePosition> positions = new ArrayList<>();

    public ArrayList<InvoicePosition> getPositions() {
        return positions;
    }

    public void addPosition(InvoicePosition position){
        positions.add(position);
    }

    public void addPosition(Product product){
        InvoicePosition position = positionWithProduct(product);
        if(position == null){
            addPosition(new InvoicePosition(product));
            return;
        }
        position.setCount(position.getCount()+1);
    }

    private InvoicePosition positionWithProduct(Product product){
        for(InvoicePosition position : positions){
            if (position.getProduct().getCode().equals(product.getCode())){
                return position;
            }
        }
        return null;
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

    public int getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(int dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public int getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(int dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
