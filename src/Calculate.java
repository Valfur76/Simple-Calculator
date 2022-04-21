public class Calculate {
    public String getResult(String expression) throws ExpressionException, NumberException {
        float[] arabicNumbers = {0, 0};
        String[] romanNumbers = {"", ""};
        Integer maxNumber = 10;
        Integer minNumber = 1;
        String symbol;
        String op  = "";
        boolean isRomanNumbers = false;
        boolean isArabicNumbers = false;
        int index = 0;
        float result;
        for (int j = 0; j < expression.length(); j++) {
            symbol = expression.substring(j, j + 1);
            if ((symbol.equals("I") || symbol.equals("V")) || symbol.equals("X") || symbol.equals("L") || symbol.equals("C") || symbol.equals("D") || symbol.equals("M")) {
                if (isArabicNumbers) throw new ExpressionException();
                isRomanNumbers = true;
                romanNumbers[index] += symbol;
            } else if (symbol.equals("0") || symbol.equals("1") || symbol.equals("2") || symbol.equals("3") || symbol.equals("4") || symbol.equals("5") || symbol.equals("6") || symbol.equals("7") || symbol.equals("8") || symbol.equals("9")) {
                      if (isRomanNumbers) throw new ExpressionException();
                      isArabicNumbers = true;
                      arabicNumbers[index] = arabicNumbers[index] * 10 + Integer.parseInt(symbol);
                    } else if (( symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/") ) && (index == 0)) {
                           op = symbol;
                           index++;
                           } else if (!symbol.equals(" ")) throw new ExpressionException();
        }
        if (isRomanNumbers) {
            RomanToArabic number = new RomanToArabic();
            arabicNumbers[0] = number.getNumber(romanNumbers[0]);
            arabicNumbers[1] = number.getNumber(romanNumbers[1]);
        }
        if (arabicNumbers[0] >= minNumber && arabicNumbers[0] <= maxNumber && arabicNumbers[1] >= minNumber && arabicNumbers[1] <= maxNumber) {
            switch (op) {
                case "+":
                    result = arabicNumbers[0] + arabicNumbers[1];
                    break;
                case "-":
                    result = arabicNumbers[0] - arabicNumbers[1];
                    break;
                case "*":
                    result = arabicNumbers[0] * arabicNumbers[1];
                    break;
                case "/":
                    if (arabicNumbers[1] != 0) result = arabicNumbers[0] / arabicNumbers[1];
                    else throw new ArithmeticException();
                    break;
                default:
                    result = arabicNumbers[0];
            }
            if (isRomanNumbers) {
                if (result < 4000 && result > 0) {
                    ArabicToRoman res = new ArabicToRoman();
                    return res.getNumber((int) result);
                } else throw new NumberException();
            }
        } else throw new NumberException();
        return String.valueOf(result);
    }
}
