import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * User: quangvh
 * Date: 6/12/13
 */
public class TestTransaction {
    TransactionDao mockTransactionDao = mock(TransactionDao.class);

    @Test
    public void testDeposit() {
        Transaction.addMock(mockTransactionDao);
        Transaction.createTransaction("1234567890", 50, "deposit");
        ArgumentCaptor<TransactionDTO> listTransaction = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDao).create(listTransaction.capture());
        assertEquals(listTransaction.getValue().getAccountNumber(), "1234567890");
        assertEquals(listTransaction.getValue().getAmount(), 50.0);
        assertEquals(listTransaction.getValue().getDescription(), "deposit");
    }
}
