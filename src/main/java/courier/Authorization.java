package courier;

public class Authorization {

        private String login;
        private String password;

        public Authorization(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public static Authorization from(Courier courier) {
            return new Authorization(courier.getLogin(), courier.getPassword());
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

