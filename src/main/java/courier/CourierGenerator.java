package courier;

public class CourierGenerator {

    public static Courier getCourier() {
        return new Courier("lilou", "lilou", "lilou");
    }

    public static Courier getCourierWithPasswordOnly() {
        return new Courier("", "lilou", "");
    }

    public static Courier getCourierWithLoginOnly() {
        return new Courier("lilou", "", "");
    }

    public static Courier getCourierWithSimilarLogin() {
        return new Courier("lilou", "lilou$lilou", "lilou");
    }
}
