public class ArabicToRoman {
    public String getNumber(int n) {
        StringBuilder s = new StringBuilder();
        for (byte j = 1; j <= n/1000; j++) s.append ("M");
        s.append(thousand(n%1000));
        return String.valueOf(s);
    }

    private String thousand(int number) {
        String s;
        if (number >= 900) {
            s = "CM" + hundred(number - 900);
        } else if (number >= 500) {
            s = "D" + fourHundred(number - 500);
        } else if (number >= 400) {
            s = "CD" + hundred(number - 400);
        } else {
            s = fourHundred(number);
        }
        return s;
    }

    private String fourHundred(int n) {
        StringBuilder s = new StringBuilder();
        for (byte j = 1; j <= n/100; j++) s.append ("C");
        s.append(hundred(n%100));
        return String.valueOf(s);
    }

    private String hundred(int number) {
        String s;
        if (number >= 90) {
            s = "XC" + ten(number - 90);
        } else if (number >= 50) {
            s = "L" + fourthy(number - 50);
        } else if (number >= 40) {
            s = "XL" + ten(number - 40);
        } else {
            s = fourthy(number);
        }
        return s;
    }

    private String fourthy(int n) {
        StringBuilder s = new StringBuilder();
        for (byte j = 1; j <= n/10; j++) s.append ("X");
        s.append(ten(n%10));
        return String.valueOf(s);
    }

    private String ten(int n) {
        String s;
        if (n == 9) {
            s = "IX";
        } else if (n >= 5) {
            s = "V" + three (n - 5);
        } else if (n == 4) {
            s = "IV";
        } else {
            s = three (n);
        }
        return s;
    }

    private String three(int n) {
        StringBuilder s = new StringBuilder();
        for (byte j = 1; j <= n; j++) s.append("I");
        return String.valueOf(s);
    }
}
