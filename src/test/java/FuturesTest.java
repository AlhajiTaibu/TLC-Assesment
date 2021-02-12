import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FuturesTest {

    @Test
    public void testAddNewProduct() throws ProductAlreadyRegisteredException {
        Product product = mock(Product.class);
        Futures futures = mock(Futures.class);
        futures.addNewProduct(product);
        assertNotNull(futures.getProductList(), "addition of product unsuccessful");
    }

    @Test
    public void testProductAlreadyRegisteredExceptionThrown() throws ProductAlreadyRegisteredException {
        Product product = mock(Product.class);
        List<Product> p = new ArrayList<>();
        Futures futures = mock(Futures.class);
        futures.addNewProduct(product);

        assertThrows(ProductAlreadyRegisteredException.class, ()->futures.addNewProduct(product),"exception wasn't thrown");
    }

    @Test
    public void testSetTrade(){
        Product product = mock(Product.class);
        Futures futures = mock(Futures.class);
        futures.trade(product,5);
        System.out.println(futures.getTradedProduct());
        assertEquals( 5,futures.getTradedProduct().get(product));

    }

    @Test
    public void testTotalTradeQuantityForDay(){
        Product product = mock(Product.class);
        Product product2 = mock(Product.class);
        Futures futures = mock(Futures.class);
        futures.trade(product,5);
        futures.trade(product,15);
        assertEquals(25, futures.totalTradeQuantityForDay());
    }

    @Test
    public void testTotalValueOfDaysTradedProducts(){
        Product product = mock(Product.class);
        when(product.getValue()).thenReturn(100.00);
        Futures futures = mock(Futures.class);
        futures.trade(product,5);
        assertEquals(500.00, futures.totalValueOfDaysTradedProducts());
    }

}