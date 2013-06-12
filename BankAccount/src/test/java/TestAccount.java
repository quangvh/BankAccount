import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * User: quangvh
 * Date: 6/11/13
 */
public class TestAccount {
    BankAccountDao mockBankAccountDao = mock(BankAccountDao.class);

    @Test
    public void testNewAccountWithBalanceZero() {
        BankAccount.addMock(mockBankAccountDao);
        BankAccount.openAccount("0942778166");
        ArgumentCaptor<BankAccountDTO> listAccounts = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDao).save(listAccounts.capture());
        assertEquals(listAccounts.getValue().getAccountNumber(), "0942778166");
        assertEquals(listAccounts.getValue().getBalance(), 0.0);
    }

    @Test
    public void testGetAccountByAccountNumber() {
        BankAccount.addMock(mockBankAccountDao);
        BankAccount.getAccount("1234567890");
        verify(mockBankAccountDao).getAccount("1234567890");
    }

    @Test
    public void testChangeBalance() {
        BankAccount.addMock(mockBankAccountDao);
        ArgumentCaptor<BankAccountDTO> listAccounts = ArgumentCaptor.forClass(BankAccountDTO.class);
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.changeBalance(50, account);
        verify(mockBankAccountDao, times(2)).save(listAccounts.capture());
        assertEquals(listAccounts.getValue().getBalance(), 50.0);
        BankAccount.changeBalance(-10, account);
        verify(mockBankAccountDao, times(3)).save(listAccounts.capture());
        assertEquals(listAccounts.getValue().getBalance(), 40.0);
    }

}
