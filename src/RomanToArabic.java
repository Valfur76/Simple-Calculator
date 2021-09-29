public class RomanToArabic {
    public int getNumber(String romanNumber) throws ExpressionException {
        int n = 0;
        String symbol;
        for (int j = 0; j < romanNumber.length(); j++) {
            symbol = romanNumber.substring(j, j + 1);
            switch (symbol) {
                case "M":
                    if (n%1000 == 0 && n<3000) n += 1000;
                    else if (n%1000 == 100) n += 800;
                         else throw new ExpressionException();
                    break;
                case "D":
                    if (n%1000 == 0) n += 500;
                    else if (n%1000 == 100) n += 300;
                         else throw new ExpressionException();
                    break;
                case "C":
                    if (n%1000 == 0 || n%1000 == 100 || n%1000 == 200 || n%1000 == 500 || n%1000 == 600 || n%1000 == 700) n += 100;
                    else if (n%100 == 10) n += 80;
                         else throw new ExpressionException();
                    break;
                case "L":
                    if (n%100 == 0) n += 50;
                    else if (n%100 == 10) n += 30;
                         else throw new ExpressionException();
                    break;
                case "X":
                    if (n%100 == 0 || n%100 == 10 || n%100 == 20 || n%100 == 50 || n%100 == 60 || n%100 == 70) n += 10;
                    else if (n%10 == 1) n += 8;
                         else throw new ExpressionException();
                    break;
                case  "V":
                    if (n%10 == 0) n += 5;
                    else if (n%10 == 1) n += 3;
                         else throw new ExpressionException();
                    break;
                case "I":
                    if ( n%10 == 0 || n%10 == 1 || n%10 == 2 || n%10 == 5 || n%10 == 6 || n%10 == 7) n++;
                    else throw new ExpressionException();
                    break;
                default:
                    throw new ExpressionException();
            }
        }
    return n;
    }
}
