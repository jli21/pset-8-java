public class ATM {


    final static int DEFAULT = 1;   
    final static int FORMAL = 2;    
    final static int SORTABLE = 3;  

    final static int SUCCESS = 1;
    final static int INVALID_AMOUNT = 2;
    final static int INSUFFICIENT_FUNDS = 3;
    final static int ACCOUNT_NOT_FOUND = 4;

    private static BankAccount[] database = new BankAccount[2];     


    public ATM() {
        ATM.populate();
    }


    public void run() {
        BankAccount active = database[0];      
        BankAccount destination = database[1];  

        simulateShowDetails(active);
        simulateValidDeposit(active);
        simulateInvalidDeposit(active);
        simulateValidWithdrawal(active);
        simulateInvalidWithdrawal(active);
        simulateInsufficientWithdrawal(active);
        simulateValidTransfer(active, destination);
        simulateInvalidTransfer(active, destination);
        simulateInsufficientTransfer(active, destination);
        simulateAccountNotFoundTransfer(active);
        simulationChangeInformation(active);
    }

    private void simulateShowDetails(BankAccount account) {
        System.out.println("Owner: " + account.getAccountOwner().getName(ATM.SORTABLE));
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Email: " + account.getAccountOwner().getEmailAddress());
        System.out.println("Phone: " + account.getAccountOwner().getFormattedPhoneNumber());
        System.out.println("Mailing Address : " + pad(18, account.getAccountOwner().getMailingAddress().getFormattedAddress()));
        System.out.println();
    }

    private void simulateValidDeposit(BankAccount account) {
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Balance (before): " + account.getFormattedBalance());
        System.out.println("Status: " + getStatus(account.deposit(250)));
        System.out.println("Balance (after): " + account.getFormattedBalance());
        System.out.println();
    }

    private void simulateInvalidDeposit(BankAccount account) {
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Balance (before): " + account.getFormattedBalance());
        System.out.println("Status: " + getStatus(account.deposit(0)));
        System.out.println("Balance (after): " + account.getFormattedBalance());
        System.out.println();
    }

    private void simulateValidWithdrawal(BankAccount account) {
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Balance (before): " + account.getFormattedBalance());
        System.out.println("Status: " + getStatus(account.withdraw(250)));
        System.out.println("Balance (after): " + account.getFormattedBalance());
        System.out.println();
    }


    private void simulateInvalidWithdrawal(BankAccount account) {
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Balance (before): " + account.getFormattedBalance());
        System.out.println("Status: " + getStatus(account.withdraw(-1)));
        System.out.println("Balance (after): " + account.getFormattedBalance());
        System.out.println();
    }


    private void simulateInsufficientWithdrawal(BankAccount account) {
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Balance (before): " + account.getFormattedBalance());
        System.out.println("Status: " + getStatus(account.withdraw(5000)));
        System.out.println("Balance (after): " + account.getFormattedBalance());
        System.out.println();
    }


    private void simulateValidTransfer(BankAccount origin, BankAccount destination) {
        System.out.println("Origin: " + origin.getMaskedAccountNumber());
        System.out.println("Balance (before): " + origin.getFormattedBalance());
        System.out.println("Destination: " + destination.getMaskedAccountNumber());
        System.out.println("Balance (before): " + destination.getFormattedBalance());
        System.out.println("Status: " + getStatus(origin.transfer(destination.getAccountNumber(), 500)));
        System.out.println("Balance (after, origin): " + origin.getFormattedBalance());
        System.out.println("Balance (after, destination): " + destination.getFormattedBalance());
        System.out.println();
    }


    private void simulateInvalidTransfer(BankAccount origin, BankAccount destination) {
        System.out.println("Origin: " + origin.getMaskedAccountNumber());
        System.out.println("Balance (before): " + origin.getFormattedBalance());
        System.out.println("Destination: " + destination.getMaskedAccountNumber());
        System.out.println("Balance (before): " + destination.getFormattedBalance());
        System.out.println("Status: " + getStatus(origin.transfer(destination.getAccountNumber(), -1)));
        System.out.println("Balance (after, origin): " + origin.getFormattedBalance());
        System.out.println("Balance (after, destination): " + destination.getFormattedBalance());
        System.out.println();
    }


    private void simulateInsufficientTransfer(BankAccount origin, BankAccount destination) {
        System.out.println("Origin: " + origin.getMaskedAccountNumber());
        System.out.println("Balance (before): " + origin.getFormattedBalance());
        System.out.println("Destination: " + destination.getMaskedAccountNumber());
        System.out.println("Balance (before): " + destination.getFormattedBalance());
        System.out.println("Status: " + getStatus(origin.transfer(destination.getAccountNumber(), 5000)));
        System.out.println("Balance (after, origin): " + origin.getFormattedBalance());
        System.out.println("Balance (after, destination): " + destination.getFormattedBalance());
        System.out.println();
    }


    private void simulateAccountNotFoundTransfer(BankAccount origin) {
        System.out.println("Origin: " + origin.getMaskedAccountNumber());
        System.out.println("Balance (before): " + origin.getFormattedBalance());
        System.out.println("Destination: 1000009");
        System.out.println("Balance (before): N/A");
        System.out.println("Status: " + getStatus(origin.transfer(10000009L, 500)));
        System.out.println("Balance (after, origin): " + origin.getFormattedBalance());
        System.out.println("Balance (after, destination): N/A");
        System.out.println();
    }

    private void simulationChangeInformation(BankAccount account) {
        account.getAccountOwner().setSalutation("Ms");
        account.getAccountOwner().setFirstName("Paulina");
        account.getAccountOwner().setLastName("Bridges");
        account.getAccountOwner().setEmailAddress("pbridges@example.com");
        account.getAccountOwner().setPhoneNumber(5557773333L);
        account.getAccountOwner().getMailingAddress().setPrimaryStreet("456 Center Street");
        account.getAccountOwner().getMailingAddress().setSecondaryStreet("Building 7, Apartment G");
        account.getAccountOwner().getMailingAddress().setCity("New York");
        account.getAccountOwner().getMailingAddress().setState("New York");
        account.getAccountOwner().getMailingAddress().setPostalCode("10027");

        System.out.println("Owner: " + account.getAccountOwner().getName(ATM.FORMAL));
        System.out.println("Account No.: " + account.getMaskedAccountNumber());
        System.out.println("Email: " + account.getAccountOwner().getEmailAddress());
        System.out.println("Phone: " + account.getAccountOwner().getFormattedPhoneNumber());
        System.out.println("Mailing Address : " + pad(18, account.getAccountOwner().getMailingAddress().getFormattedAddress()));
    }


    public static BankAccount lookup(long accountNumber) {
        for (BankAccount account : database) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }


    private static void populate() {
        database[0] = new BankAccount(
                new AccountOwner(
                        "Mr",
                        "James",
                        "Stewart",
                        "jstewart@example.com",
                        5551232244L,
                        new MailingAddress(
                                "123 Main Street",
                                "Apartment 1A",
                                "Scotch Plains",
                                "NJ",
                                "07076"
                        )
                ),
                1000
        );
        database[1] = new BankAccount(
                new AccountOwner(
                        "Mrs",
                        "Henrietta",
                        "Phillips",
                        "henphillips@example.com",
                        5551236688L,
                        new MailingAddress(
                                "2467 Hemlock Road",
                                null,
                                "North Arlington",
                                "Texas",
                                "76006"
                        )
                ),
                2500
        );
    }


    private String pad(int pad, String text) {
        int length = text.length() + pad;
        String[] parts = text.split("\n");
        StringBuilder sb = new StringBuilder();

        if (parts.length == 3) {
            while (sb.length() < length - text.length()) {
                sb.append(" ");
            }

            return parts[0] + "\n" + sb.toString() + parts[1] + "\n" + sb.toString() + parts[2];
        } else if (parts.length == 2) {
            while (sb.length() < length - text.length()) {
                sb.append(" ");
            }

            return parts[0] + "\n" + sb.toString() + parts[1];
        } else {
            return text;
        }
    }


    private String getStatus(int code) {
        switch (code) {
            case ATM.SUCCESS: return "Success.";
            case ATM.INVALID_AMOUNT: return "Invalid amount.";
            case ATM.INSUFFICIENT_FUNDS: return "Insufficient funds.";
            case ATM.ACCOUNT_NOT_FOUND: return "Account not found.";
            default: return "Unknown.";
        }
    }

    public static void main(String[] args) {
        new ATM().run();
    }
}