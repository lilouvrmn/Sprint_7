package courier;

public class LoginOnlyAuthorization {
    private String login;
    private String password;

    public LoginOnlyAuthorization(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static LoginOnlyAuthorization fromOnlyLogin(Courier courier) {
        return new LoginOnlyAuthorization(courier.getLogin(), "");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
