package order;

import java.util.List;

public class OrderGenerator {

    public static Order getOrderWithOneColour() {
        return new Order(
                "Юлия",
                "Верман",
                "Москва Большая Академическая",
                "Лихоборы",
                "8 888 888 88 88",
                "3",
                "2024.05.30",
                "Спасибо",
                List.of("BLACK")
        );
    }

    public static Order getOrderWithTwoColour() {
        return new Order(
                "Юлия",
                "Верман",
                "Москва Большая Академическая",
                "Лихоборы",
                "8 888 888 88 88",
                "6",
                "2024.05.30",
                "Спасибо",
                List.of("BLACK", "GREY")
        );
    }

    public static Order getOrderWithoutColour() {
        return new Order(
                "Юлия",
                "Верман",
                "Москва Большая Академическая",
                "Лихоборы",
                "8 888 888 88 88",
                "4",
                "2024.05.30",
                "Спасибо",
                List.of()
        );
    }
}
