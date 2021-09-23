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
                throw new Exception("Используйте только эти символы для операций +, -, *, /");
        }

        if (one.getType() == NumberType.ROMAN & result < 0) {
            return "-" + CalcsCheck.toRomanNumber(result * -1);
        }
        if (one.getType() == NumberType.ROMAN & result > 0) {
            return CalcsCheck.toRomanNumber(result);
        }
        else return String.valueOf(result);
    }
}
