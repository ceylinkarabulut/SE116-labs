public class Bank {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("qwe", "12345678900");
        BankAccount account2 = new BankAccount("asd", "98765432100");
        account1.deposit(5000);
        account2.withdraw(10);
        account1.sendMoney(30, "98765432100", account2);
        account2.displayAccountInfo();
        account1.displayAccountInfo();
    }
}
