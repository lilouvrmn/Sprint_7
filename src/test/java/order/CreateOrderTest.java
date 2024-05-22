package order;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private OrderCreate orderCreate;
    private final Order order;
    private final int statusCode;
    private Integer track;

    public CreateOrderTest(Order order, int statusCode) {
        this.order = order;
        this.statusCode = statusCode;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {OrderGenerator.getOrderWithOneColour(), SC_CREATED},
                {OrderGenerator.getOrderWithTwoColour(), SC_CREATED},
                {OrderGenerator.getOrderWithoutColour(), SC_CREATED}
        };
    }

    @Before
    public void setOrderCreate() {
        orderCreate = new OrderCreate();
    }

    @Test
    public void createOrderWithDifferentColour() {
        ValidatableResponse responseCreateOrder = orderCreate.createOrder(order);
        track = responseCreateOrder.extract().path("track");
        int actualStatusCode = responseCreateOrder.extract().statusCode();
        if (statusCode == actualStatusCode) {
            assertTrue(track != 0);
        } else {
            fail("Wrong status code: " + actualStatusCode);
        }

    }

    @After
    public void cleanUp() {
        if (track != null) {
            orderCreate.cancelOrder(track);
        }
    }
}
