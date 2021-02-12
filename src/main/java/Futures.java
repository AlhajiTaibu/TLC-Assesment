import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Futures implements MontrealTradedProducts{
    private List<Product> productList = new ArrayList<>();
    private Map<Product, Integer> tradedProduct = new HashMap<>();

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        List<Product> newProductList = this.productList.stream()
                .filter(product1 -> product1.getProductId().equals(product.getProductId()))
                .collect(Collectors.toList());

        if(newProductList.isEmpty()){
            productList.add(product);
        }else{
            throw new ProductAlreadyRegisteredException();
        }
    }

    @Override
    public void trade(Product product, int quantity) {
        if(this.getProductList().contains(product)){
            this.tradedProduct.put(product, quantity);
        }else{
            this.tradedProduct.put(product, 0);
        }
    }

    @Override
    public int totalTradeQuantityForDay() {
        Stream<Integer> quantityStream = this.tradedProduct.values().stream();
        return quantityStream.mapToInt(quantity->quantity).sum();
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        Stream<Map.Entry<Product, Integer>> tradedValue = this.tradedProduct.entrySet().stream();
        return tradedValue.mapToDouble(product->product.getValue()*product.getKey().getValue()).sum();
    }

    @Override
    public String showProductType() {
        return "This is a future product";
    }

    public Map<Product, Integer> getTradedProduct() {
        return tradedProduct;
    }
}
