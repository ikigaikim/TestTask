import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = sc.nextLine();

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Ошибка, ознакомьтесь с правилами работы!");

                NumberIde firstNumber = CalcsCheck.parseAndValidate(symbols[0]);
                NumberIde secondNumber = CalcsCheck.parseAndValidate(symbols[2], firstNumber.getType());
                String result = Operand.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        sc.close();
    }

    private static void startCalc() {
        String multipleLines = "Добро пожаловать, Я простой калькулятор!"
                + System.lineSeparator() + " "
                + System.lineSeparator() + "СЛЕДУЮЩИЕ ФУНКЦИИ ДОСТУПНЫ:"
                + System.lineSeparator() + "Сложение(+), Вычитание(-), Умножение(*), Деление(/)"
                + System.lineSeparator() + " "
                + System.lineSeparator() + "ПРАВИЛА:"
                + System.lineSeparator() + "- выражение возможно либо арабскими, либо римскими цифрами"
                + System.lineSeparator() + "- можно использовать цифры от 1 до 10"
                + System.lineSeparator() + "- между символами и знаками должны быть пробелы"
                + System.lineSeparator() + " "
                + System.lineSeparator() + "Пример: 1 + 1 или V + VI"
                + System.lineSeparator() + " ";
        System.out.println(multipleLines);
    }

    private static void exitCalc() {

        System.out.println("Спасибо!");

    }
}


