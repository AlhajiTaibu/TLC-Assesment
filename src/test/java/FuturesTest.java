import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
//        assertEquals( 5,stocks.getTradedProduct().get(product));

    }

}