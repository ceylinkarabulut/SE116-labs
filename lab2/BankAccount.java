// Question 1: What does a constructor do in java?
// Constructors initialize/builds the object that we created.
// Question 2: What is the difference between static and non-static methods in java?
// Static methods belong to the class; non-static methods belong to instances.

class BankAccount {
    private String ownerName;
    private String iban;
    private double balance;

    public BankAccount(String ownerName, String iban) {
        this.ownerName = ownerName;
        if (iban.length() == 11) {
            this.iban = iban;
        } else {
            this.iban = "00000000000";
        }
        this.balance = 0.0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Deposited " + amount + " to your account, " + getOwnerName() + " your new balance is " + balance);
    }

    public void withdraw(int amount) {
        this.balance -= amount;
        System.out.println("Withdrawn " + amount + " from your account, " + getOwnerName() + " your new balance is " + balance);
    }

    public void sendMoney(double amount, String receivingIban, BankAccount receiver) {
        if (!receiver.getIban().equals(receivingIban)) {
            System.out.println("IBAN not found!!");
            return;
        }
        if (amount < 0) {
            System.out.println("amount has to be positive!");
        } else if (amount > balance) {
            System.out.println("insufficient funds! :(");
        } else {
            balance -= amount;
            System.out.println("Sent " + amount + ". Your new balance is " + balance);
            receiver.balance += amount;
        }
    }

    public void displayAccountInfo() {
        System.out.println(getOwnerName() + " your balance is " + balance + " and your iban is " + iban);
    }
}
