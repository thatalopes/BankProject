package io.thatalopes.bank;

public class Account {

    private static final int MAX_LENGTH = 12;

    private String ag;
    private String cc;
    private String name;

    private double balance;

    private Log logger;

    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name){
        if (name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }

    }

    public void deposit(double value) {
        balance += value;
        logger.out("DEPOSITO - R$ " + value + " Sua conta agora tem o valor de R$ " + balance);
    }

    public boolean withDraw(double value) {
        if (balance < value) {
            logger.out("SAQUE -  R$ " + value + " Seu saldo atual é de R$ " + balance);
            return false;
        }
        balance -= value;
        logger.out("SAQUE -  R$ " + value + " Sua conta agora tem o valor de R$ " + balance);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        // String result = "A conta " + this.name + " " + this.ag + " / " + this.cc + " possui: R$ " + balance;
        // return result;
        return "A conta " + this.name + " " + this.ag + " / " + this.cc + " possui: R$ " + balance;
    }

}
