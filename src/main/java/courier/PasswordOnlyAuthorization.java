package courier;

public class PasswordOnlyAuthorization {
    private String password;

    public PasswordOnlyAuthorization(String password) {
        this.password = password;
    }

    public static PasswordOnlyAuthorization fromOnlyPassword(Courier courier) {
        return new PasswordOnlyAuthorization(courier.getPassword());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
