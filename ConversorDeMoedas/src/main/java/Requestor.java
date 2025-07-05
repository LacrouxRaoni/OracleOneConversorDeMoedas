public class Requestor {

    private String currency;
    private Double amount;
    private String toCurrency;

    Requestor(String currency, Double amount, String toCurrency){
        this.currency = currency;
        this.amount = amount;
        this.toCurrency = toCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public String getToCurrency() {
        return toCurrency;
    }
}
