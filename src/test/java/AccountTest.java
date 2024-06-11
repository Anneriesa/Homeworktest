import org.example.Account;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("123", 1000);
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-500);
        });
        assertEquals("Сумма депозита должна быть положительной", exception.getMessage());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-500);
        });
        assertEquals("Сумма вывода должна быть положительной", exception.getMessage());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500);
        });
        assertEquals("Недостаточный баланс", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 100, 200, 300 })
    public void testParameterizedDeposit(double amount) {
        account.deposit(amount);
        assertEquals(1000 + amount, account.getBalance());
    }
}
