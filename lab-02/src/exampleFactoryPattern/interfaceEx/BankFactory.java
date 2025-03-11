package exampleFactoryPattern.interfaceEx;

public class BankFactory {
    private BankFactory() {
    }

    public static Bank getBank(BankType bankType) {
        return switch (bankType) {
            case TPBANK -> new TPBank();
            case VIETCOMBANK -> new VietComBank();
            default -> throw new IllegalArgumentException("This bank type is unsupported");
        };
    }
}
