import java.util.*;

interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here
class AccountServiceImpl implements AccountService {
    public Account[] acc;

    AccountServiceImpl(Account[] accounts) {
        this.acc = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {

        for (Account a: acc) {
            if (a.getOwner().getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        for (Account a: acc) {
            if (a.getBalance() > value) {
                int c = 0;
                c++;
                return c;
            }
        }
        return 0;
    }
}

class Account{

    private  long id;
    private  long balance;
    private  User owner;

    public Account(long id, long balance, User owner) {

        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }
    public Account(){

    }

    public long getId() { 
        return id; 
    }

    public long getBalance() { 
        return balance; 
    }

    public User getOwner() {
        return owner; 
    }
}

class User {

    private  long id;
    private  String firstName;
    private  String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(){

    }
    public long getId() { 
        return id; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
}

class Main {
    public static void main(String[] args) {
        Account[] accounts = {new Account(12, 5847, new User(1, "user1", "xyz")), new Account(14, 5847, new User(5, "user2", "abz"))};


        System.out.println(Arrays.toString(accounts));
        AccountServiceImpl accountService = new AccountServiceImpl(accounts);
        System.out.println(accountService.findAccountByOwnerId(5));
        System.out.println(accountService.countAccountsWithBalanceGreaterThan(2454));
    }
}