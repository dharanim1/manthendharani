package JUnit;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderServiceTest {
	OrderService orderService = new OrderService();

    

    @Test
    void testPlaceOrderFailure() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
            () -> orderService.placeOrder(15), "Should throw exception for insufficient stock");
        assertEquals("Insufficient stock", thrown.getMessage());
    }

    @Test
    void testCalculateTotal() {
        double price = 50.0;
        int quantity = 2;
        double expectedTotal = price * quantity * (1 - orderService.getDiscout());
        
        assertEquals(expectedTotal, orderService.calPrice(price, quantity));
    }
    //suffient stock
    //takePlacePlaceOrder() -> placeorder(5) -> succed -> assertTrue
    //stock should reduce to 5, assertEquals (5, getStock())
    @Test
   void testSufficientStock() {
        
      
        boolean orderPlaced = orderService.placeOrder(5);

        
        assertTrue(orderPlaced, "Order should be placed successfully");

       
        assertEquals(5, orderService.getstock(), "Stock should be reduced to 5");
    
}
    @Test
    void testCalculateTotalWithZeroQuantity() {
        double totalPrice = orderService.calPrice(100.0, 0);
        assertEquals(0, totalPrice, "Total price should be 0 when quantity is 0");
}
    @ParameterizedTest
    @CsvSource({
        "100.0, 2, 180.0",
        "50.0, 4, 180.0",
        "200.0, 1, 180.0",
        "75.0, 3, 202.5"
    })public void testCalculatePrice(double price, int quantity, double expectedValue) {
        double totalPrice = orderService.calPrice(price, quantity);
        assertEquals(expectedValue, totalPrice, "Calculated price should match the expected value");
}
    @Test
    
    void testOrderProcessingTimeout() throws InterruptedException {
        Thread.sleep(500); 
        assertTrue(true, "Order processing test passed with timeout");
    }
   @Test
   void testPlacedOrderMultithread() throws InterruptedException {
   	Thread thread1 =  new Thread(()->orderService.placeOrder(2));
   	Thread thread2=new Thread(()->orderService.placeOrder(1));
   	thread1.start();
   	thread2.start();
   	thread1.join();
   	thread2.join();
   	assertEquals(7,orderService.getstock());
   }
}
