/**
 * User: quangvh
 * Date: 6/12/13
 */
public class Transaction {
    private static TransactionDao transactionDao;

    public static void addMock(TransactionDao mockTransactionDao) {
        Transaction.transactionDao = mockTransactionDao;
    }

    public static TransactionDTO createTransaction(String accountNumber, int amount, String description) {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setAccountNumber(accountNumber);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transactionDao.create(transaction);
        return transaction;
    }
}
