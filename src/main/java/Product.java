public class Product implements ProductPricingService {
    private String productId;
    private double value;
    private String exchange;
    private String ticker;
    private String contractCode;
    private int month;
    private int year;


    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setValue(MontrealTradedProducts productType) {
        if(productType.showProductType().equals("This is a stocks product type")){
            this.value = this.price(this.getExchange(), this.getTicker());
        }else{
            this.value = this.price(this.getExchange(), this.getContractCode(), this.getMonth(), this.getYear());
        }
    }

    public String getProductId() {
        return productId;
    }

    public double getValue() {
        return value;
    }

    public String getExchange() {
        return exchange;
    }

    public String getTicker() {
        return ticker;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public double price(String exchange, String ticker) {
        return 0;
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        return 0;
    }
}
