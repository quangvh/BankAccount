import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * User: quangvh
 * Date: 6/11/13
 */
public class TestAccount {
    BankAccountDao mockBankAccountDao = mock(BankAccountDao.class);

    @Test
    public void newAccountWithBalanceZero() {
        BankAccount.addMock(mockBankAccountDao);
        BankAccount.openAccount("0942778166");
        ArgumentCaptor<BankAccountDTO> listAccounts = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDao).save(listAccounts.capture());
        assertEquals(listAccounts.getValue().getAccountNumber(), "0942778166");
        assertEquals(listAccounts.getValue().getBalance(), 0.0);
    }
}
