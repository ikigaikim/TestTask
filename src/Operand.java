public class Operand {

    public static String calculate(NumberIde one, NumberIde two, String action) throws Exception {

        int result;

        switch (action) {
            case "+":
                result = one.getValue() + two.getValue();
                break;
            case "-":
                result = one.getValue() - two.getValue();
                break;
            case "*":
                result = one.getValue() * two.getValue();
                break;
            case "/":
                result = one.getValue() / two.getValue();
                break;
            default:
                throw new Exception("Используйте следующие символы для операций +, -, *, /");
        }

        if (one.getType() == NumberType.ROMAN) {
            return CalcsCheck.toRomanNumber(result);
        } else return String.valueOf(result);
    }
}
