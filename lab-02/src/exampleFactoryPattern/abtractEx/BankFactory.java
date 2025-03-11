package exampleFactoryPattern.abtractEx;

public class BankFactory {
    public static Bank getBank(BankAbstractFactory factory) {
        return factory.createBank();
    }
}
