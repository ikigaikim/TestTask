import java.util.Map;
import java.util.TreeMap;

class CalcsCheck {

    private final static TreeMap < Integer, String > romanToarabian = new TreeMap<>();

    static {
        romanToarabian.put(1, "I");
        romanToarabian.put(4, "IV");
        romanToarabian.put(5, "V");
        romanToarabian.put(9, "IX");
        romanToarabian.put(10, "X");
        romanToarabian.put(40, "XL");
        romanToarabian.put(50, "L");
        romanToarabian.put(90, "XC");
        romanToarabian.put(100, "C");

    }

    static NumberIde parseAndValidate(String symbol) throws Exception {

        int value;
        NumberType type;

        try {
            value = Integer.parseInt(symbol);
            type = NumberType.ARABIC;
        }catch (NumberFormatException e) {
            value = toArabicNumber(symbol);
            type = NumberType.ROMAN;
        }

        if (value < 1 || value > 10) {
            throw new Exception("Используйте числа от 1 до 10 включительно");
        }

        return new NumberIde(value, type);
    }

    static NumberIde parseAndValidate(String symbol, NumberType type) throws Exception {

        NumberIde NumberIde = parseAndValidate(symbol);
        if (NumberIde.getType() != type) {
            throw new Exception("Используйте один тип чисел");
        }

        return NumberIde;
    }

    private static int letterToNumber(char letter) {

        int result = -1;

        for (Map.Entry < Integer, String > entry: romanToarabian.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    static String toRomanNumber(int NumberIde) {

        int i = romanToarabian.floorKey(NumberIde);

        if (NumberIde == i) {
            return romanToarabian.get(NumberIde);
        }
        return romanToarabian.get(i) + toRomanNumber(NumberIde - i);
    }

    static int toArabicNumber(String roman) throws Exception {
        int result = 0;

        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int num = letterToNumber(letter);

            if (num < 0) throw new Exception("Укажите верный римский символ");

            i++;
            if (i == roman.length()) {
                result += num;
            }else {
                int nextNum = letterToNumber(roman.charAt(i));
                if(nextNum > num) {
                    result += (nextNum - num);
                    i++;
                }
                else result += num;
            }
        }
        return result;
    }
}
