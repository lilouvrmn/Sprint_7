package order;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GetOrderTest {

    private OrderCreate orderCreate;
    private OrdersGet ordersList;


    @Before
    public void setOrderCreate() {
        orderCreate = new OrderCreate();
        ordersList = new OrdersGet();
    }

    @Test
    public void createOrderWithDifferentColour() {
        orderCreate.createOrder(OrderGenerator.getOrderWithOneColour());
        orderCreate.createOrder(OrderGenerator.getOrderWithTwoColour());
        orderCreate.createOrder(OrderGenerator.getOrderWithoutColour());

        ValidatableResponse response = ordersList.getOrder();
        if (response.extract().statusCode() == 200) {
            List<Order> orderList = response.extract().path("orders");
            assertFalse(orderList.isEmpty());
        } else {
            fail("Wrong status code: " + response.extract().statusCode());
        }
    }
}
