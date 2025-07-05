import java.util.Scanner;

public class ConverserDeMoedasService {

    private final Scanner sc = new Scanner(System.in);

    ConverserDeMoedasService(){}

    public void mainMenu(boolean option) {
        if (!option) {
            System.out.println("************************************************ ");
            System.out.println("Bem vindo ao conversor de Moedas!\n");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("************************************************\n");
        }
        else {
            System.out.println("Digite o valor que deseja converter: ");
        }
    }

    public boolean callConvertorMenu() {
        mainMenu(false);
        String option = sc.nextLine();
            int optionInt = Integer.parseInt(option);
            String amount;
            String baseCurrency;
            String toExchange;

            switch (optionInt) {
                case 1, 3, 5 -> { // USD to [ARS, BRL, COP]
                    mainMenu(true);
                    amount = sc.nextLine();
                    baseCurrency = "USD";
                    toExchange = getTargetCurrency(optionInt);
                }
                case 2, 4, 6 -> { // [ARS, BRL, COP] to USD
                    mainMenu(true);
                    amount = sc.nextLine();
                    toExchange = "USD";
                    baseCurrency = getSourceCurrency(optionInt);
                }
                case 7 -> {
                    System.out.println("Até logo! =]");
                    return false;
                }
                default -> {
                    System.out.println("Opção inválida!");
                    return true;
                }
            }
            assert amount != null;

            Requestor requestor = new Requestor(baseCurrency, Double.parseDouble(amount), toExchange);
            ExternalApiRequestor externalApiRequestor = new ExternalApiRequestor();
            ConversorJsonHandler jsonHandler = new ConversorJsonHandler();

            jsonHandler.jSonToMap(externalApiRequestor.callExternalApi(requestor));

        double result = requestor.getAmount() * jsonHandler.getConversion_rates().get(toExchange);
        System.out.println("Valor " + requestor.getAmount() +
                            " [" + requestor.getCurrency() + "] " +
                            "corresponde ao valor final de =>>> " +
                            result + " [" +requestor.getToCurrency() + "]");
        return true;
    }

    private String getTargetCurrency(int option) {
        return switch (option) {
            case 1 -> "ARS";
            case 3 -> "BRL";
            case 5 -> "COP";
            default -> throw new IllegalArgumentException("Invalid option for target currency");
        };
    }

    private String getSourceCurrency(int option) {
        return switch (option) {
            case 2 -> "ARS";
            case 4 -> "BRL";
            case 6 -> "COP";
            default -> throw new IllegalArgumentException("Invalid option for source currency");
        };
    }
}
