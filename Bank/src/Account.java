public class Account {

    private int accountNumber;
    private double accountbalance;
    private String customerName;
    private String customerEmail;
    private int pin;
    private double interestRate;


    public Account(){

    }


    /**
     *
     * Creates a new account object
     *
     * @param interestRate
     * @param pin
     * @param customerEmail
     * @param customerName
     * @param accountbalance
     * @param accountNumber
     */
    public Account(double interestRate, int pin, String customerEmail, String customerName, double accountbalance, int accountNumber) {
        this.interestRate = interestRate;
        this.pin = pin;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.accountbalance = accountbalance;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(double accountbalance) {
        this.accountbalance = accountbalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * deposits funds to the account balance.
     * @param x
     */
    public boolean deposit(double x){
        if (x <0){
            return false;
        }
        this.accountbalance = this.accountbalance + x;
        return true;
    }

}
