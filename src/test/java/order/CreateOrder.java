package order;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrder {

    private OrderCreate orderCreate;
    private Order order;
    private int statusCode;
    private int track;

    public CreateOrder(Order order, int statusCode) {
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
        assertTrue(statusCode == actualStatusCode
                && track != 0);
    }

    @After
    public void cleanUp() {
        orderCreate.cancelOrder(track);
    }
}
