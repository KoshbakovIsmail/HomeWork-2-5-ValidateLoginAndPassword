public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        String login = "jhA";
        String password = "123445_";
        String canfirmPassword = "123445_";
        validateLoginAndPassword(login, password, canfirmPassword);
    }

    public static void validateLoginAndPassword(String login, String password, String canfirmPassword)
            throws WrongLoginException, WrongPasswordException {
        String symbolsAllowed = "qwertyuiopasdfghjklzxcvbnm_QWERTYUIOPASDFGHJKLZXCVBNM_0123456789";
        try {
            if (login.length() > 20 || !login.matches("[" + symbolsAllowed + "]+")) {
                throw new WrongLoginException("Wrong login format! ");
            } else {
                System.out.println("Login accepted");
            }
            if (password.length() > 20 || !password.matches("[" + symbolsAllowed + "]+")) {
                throw new WrongPasswordException("Wrong password format! ");
            } else {
                System.out.println("Password accepted");
            }
            if (!password.equals(canfirmPassword)) {
                throw new WrongCanfirmPasswordException("Error validate password!");
            } else {
                System.out.println("Password confirmed correctly");
            }
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException | WrongCanfirmPasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}

