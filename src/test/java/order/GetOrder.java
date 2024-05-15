package order;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GetOrder {

    private OrderCreate orderCreate;
    private OrdersGet ordersList;
    private int track1;
    private int track2;
    private int track3;

    @Before
    public void setOrderCreate() {
        orderCreate = new OrderCreate();
        ordersList = new OrdersGet();
    }

    @Test
    public void createOrderWithDifferentColour() {
        ValidatableResponse responseCreateOrderWithOneColour = orderCreate.createOrder(OrderGenerator.getOrderWithOneColour());
        ValidatableResponse responseCreateOrderWithTwoColour = orderCreate.createOrder(OrderGenerator.getOrderWithTwoColour());
        ValidatableResponse responseCreateOrderWithoutColour = orderCreate.createOrder(OrderGenerator.getOrderWithoutColour());
        track1 = responseCreateOrderWithOneColour.extract().path("track");
        track2 = responseCreateOrderWithTwoColour.extract().path("track");
        track3 = responseCreateOrderWithoutColour.extract().path("track");
        ValidatableResponse response = ordersList.getOrder();
        List<Order> orderList = response.extract().path("orders");
        assertTrue(response.extract().statusCode() == 200
                && !orderList.isEmpty());
    }

    @After
    public void cleanUp() {
        orderCreate.cancelOrder(track1);
        orderCreate.cancelOrder(track2);
        orderCreate.cancelOrder(track3);
    }
}
