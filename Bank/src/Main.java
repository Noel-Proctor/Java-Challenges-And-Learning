//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Account account = new Account(1.2, 9259,
                "test@email.com", "Noel Proctor",
 Hot               100.00, 98 778767);

        System.out.println(account.getAccountbalance());

        boolean success = account.deposit(20.00);

        if (success){
            System.out.println("Funds deposited. Your new balance is: "+account.getAccountbalance());
        }else{
            System.out.println("There was an error depositing your funds. Please contact your local branch");
        }


    }
}