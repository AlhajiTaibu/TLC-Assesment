import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductTest {

    @Test
    public void setProductValueOfStocksProduct(){
        Stocks tradedProducts = mock(Stocks.class);
        Product product = mock(Product.class);
        product.setValue(tradedProducts);
        when(product.getValue()).thenReturn(10.00);

        assertEquals(10.00, product.getValue());

    }

    @Test
    public void setProductValueOfFutureProduct(){
        Futures tradedProducts = mock(Futures.class);
        Product product = mock(Product.class);
        product.setValue(tradedProducts);
        when(product.getValue()).thenReturn(100.00);

        assertEquals(100.00, product.getValue());

    }

}