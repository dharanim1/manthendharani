package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
 
class OrderService2MultiThreadTest {
	private OrderService2 orderService2;

 
@BeforeEach
public void setUp() {
	orderService2 = new OrderService2();
}
 
@Test
public void  testPlaceOrderMultiThread() throws InterruptedException {

	int threadCount = 10;
	ExecutorService executor = Executors.newFixedThreadPool(threadCount);
	CountDownLatch latch = new CountDownLatch(threadCount);
	for(int i=0; i<threadCount;i++) {
		executor.execute(()->{
			try {
				orderService2.placeOrder(1);
			}catch(Exception Ignored) {
			}
			latch.countDown();
		});
	}
	latch.await();
	executor.shutdown();
	assertEquals(0,orderService2.getstock());	
}
@BeforeAll
public static void beforeAllTests() {
    System.out.println("Before all tests - runs once for all tests");
}
@AfterAll
public static void afterAllTests() {
    System.out.println("After all tests - runs once after all tests");
}
@AfterEach
public void afterEachTest() {
    System.out.println("After each test - running after every test");
}
 
@Test
@Disabled("Test disabled for demonstration purposes")
public void testDisabled() {
    System.out.println("This test is disabled and will not run");
}
}

