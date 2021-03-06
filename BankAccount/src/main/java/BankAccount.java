/**
 * User: quangvh
 * Date: 6/11/13
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        bankAccountDao.save(account);
        return account;
    }

    public static void addMock(BankAccountDao mockBankAccountDao) {
        BankAccount.bankAccountDao = mockBankAccountDao;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDao.getAccount(accountNumber);
    }

    public static BankAccountDTO changeBalance(int amount, BankAccountDTO account) {
        account.setBalance(account.getBalance() + amount);
        bankAccountDao.save(account);
        return account;
    }
}
