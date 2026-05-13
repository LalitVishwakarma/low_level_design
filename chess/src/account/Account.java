package account;

public class Account {
    int id;
    String password;
    AccountStatus status;

    public Account(int id, String password, AccountStatus status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }

    public void resetPassword(){

    }
}
