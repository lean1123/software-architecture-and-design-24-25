package exampleFactoryPattern.abtractEx;

public class VietComBankFactory implements BankAbstractFactory{
    @Override
    public Bank createBank() {
        return new VietComBank();
    }
}
