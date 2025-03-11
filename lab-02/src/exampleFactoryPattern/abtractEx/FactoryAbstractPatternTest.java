package exampleFactoryPattern.abtractEx;

public class FactoryAbstractPatternTest {
    public static void main(String[] args) {
        Bank tpBank = BankFactory.getBank(new TPBankFactory());
        System.out.println(tpBank.getBankName());

        Bank vietComBank = BankFactory.getBank(new VietComBankFactory());
        System.out.println(vietComBank.getBankName());
    }
}
