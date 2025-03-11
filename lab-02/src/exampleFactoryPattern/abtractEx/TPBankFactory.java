package exampleFactoryPattern.abtractEx;

public class TPBankFactory implements BankAbstractFactory{
    @Override
    public Bank createBank() {
        return new TPBank();
    }
}
