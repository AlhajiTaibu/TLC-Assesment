import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StocksTest {

    @Test
    public void testAddNewProduct() throws ProductAlreadyRegisteredException {
        Product product = mock(Product.class);
        Stocks stocks = mock(Stocks.class);
        stocks.addNewProduct(product);
        assertNotNull(stocks.getProductList(), "addition of product unsuccessful");

    }

    @Test
    public void testProductAlreadyRegisteredExceptionThrown() throws ProductAlreadyRegisteredException {
        Product product = mock(Product.class);
        List<Product> p = new ArrayList<>();
        Stocks stocks = mock(Stocks.class);
        stocks.addNewProduct(product);

        assertThrows(ProductAlreadyRegisteredException.class, ()->stocks.addNewProduct(product),"exception wasn't thrown");
    }

    @Test
    public void testSetTrade(){
        Product product = mock(Product.class);
        Stocks stocks = mock(Stocks.class);
        stocks.trade(product,5);
        System.out.println(stocks.getTradedProduct());
        assertEquals( 5,stocks.getTradedProduct().get(product));
    }

    @Test
    public void testTotalTradeQuantityForDay(){
        Product product = mock(Product.class);
        Product product2 = mock(Product.class);
        Stocks stocks = mock(Stocks.class);
        stocks.trade(product,5);
        stocks.trade(product,15);
        assertEquals(25, stocks.totalTradeQuantityForDay());
    }

    @Test
    public void testTotalValueOfDaysTradedProducts(){
        Product product = mock(Product.class);
        when(product.getValue()).thenReturn(100.00);
        Stocks stocks = mock(Stocks.class);
        stocks.trade(product,5);
        assertEquals(500.00, stocks.totalValueOfDaysTradedProducts());
    }

}