package pl.pjait;

public class DataOfClient {
    private String name;
    private String address;
    private String nipNumber;
    private String accountNumber;

    public DataOfClient(String name, String address, String nipNumber, String accountNumber) {
        this.name = name;
        this.address = address;
        this.nipNumber = nipNumber;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNipNumber() {
        return nipNumber;
    }

    public void setNipNumber(String nipNumber) {
        this.nipNumber = nipNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
