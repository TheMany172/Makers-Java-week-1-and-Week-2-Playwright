import java.time.LocalDate;
public class Bank {
    public double currentbalance = 0.0;
//    public static void Transactions(String[] args) {
//        ArrayList<String> transaction_list = new ArrayList<String>();
//    }
    public String transactions_record = "Entries in the format - DATE, +/-, IN/OUT, REMAINING BALANCE:\n";

    public double balance() {
        return currentbalance;
    }

    public void deposit(Double moneyin, LocalDate of) {
        currentbalance += (moneyin);
        String deposit_entry = "\nEntry - " + of+"" + " " + "||" + " " + "+" + " " + "||"+ " " + moneyin+"" + " " + "||" + " " + currentbalance;
        transactions_record += deposit_entry;
    }
    public void withdraw(double moneyout, LocalDate of) {
        currentbalance -= (moneyout);
        String withdraw_entry = "\nEntry - " + of+"" + " " + "||" + " " + "-" + " " + "||"+ " " + moneyout+"" + " " + "||" + " " + currentbalance;
        transactions_record += withdraw_entry;
    }

    public String generatestatement() {
//        System.out.println("Entries in the format - DATE, +/-, IN/OUT, REMAINING BALANCE:");
        return transactions_record;
    }
}


