import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class BankTest {
    @Test
    void bank_has_a_balance() {
        Bank bank1 = new Bank();
        Double result = bank1.balance();
        assertEquals(0.0, result);
        }

    @Test
    void bank_add_to_balance() {
        Bank bank1 = new Bank();
        bank1.deposit(500.0, LocalDate.of(2021, 1, 14));
        Double result = bank1.balance();
        assertEquals(500.0, result);
    }

    @Test
    void bank_add_andthen_withdraw_some_balance() {
        Bank bank1 = new Bank();
        bank1.deposit(500.0, LocalDate.of(2021, 1, 14));
        bank1.withdraw(300.0, LocalDate.of(2021, 1, 15));
        Double result = bank1.balance();
        assertEquals(200.0, result);
    }
    @Test
    void bank_add_andthen_withdraw_some_balance_and_print_statement() {
        Bank bank1 = new Bank();
        bank1.deposit(500.0, LocalDate.of(2021, 1, 14));
        bank1.withdraw(300.0, LocalDate.of(2021, 1, 15));
        String result = bank1.generatestatement();
        assertEquals("Entries in the format - DATE, +/-, IN/OUT, REMAINING BALANCE:\n\nEntry - 2021-01-14 || + || 500.0 || 500.0\nEntry - 2021-01-15 || - || 300.0 || 200.0", result);
    }
}
