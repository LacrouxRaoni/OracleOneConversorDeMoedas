public class ConversorDeMoedasApp {

    public static void main(String[] args) {

        ConverserDeMoedasService service = new ConverserDeMoedasService();

        while(service.callConvertorMenu()){}
    }
}
