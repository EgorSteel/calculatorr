import java.math.BigDecimal;


public class SupMath extends Calculator {

    private String firstSum = "0";
    private String lastSum = "0";
    private char lastSign = '=';
    private char lastChar = '=';

    public char getLastSign() {
        return lastSign;
    }

    public void setLastSign(char c) {
        lastSign = c;
    }

    public char getLastChar() {
        return lastChar;
    }

    public void setLastChar(char c) {
        lastChar = c;
    }

    public String getLastSum() {
        return lastSum;
    }

    public void setLastSum(String f) {
        lastSum = f;
    }

    public void setFirstSum(String g) {
        firstSum = g;
    }

    public String summa() {
        if (firstSum == "0" && (!(lastSign == '+'))) {
            firstSum = lastSum;
            lastSum = "0";
            lastSign = '+';
            lastChar = '+';
            return firstSum;
        }

        if ((!(firstSum == "0") && (lastSign == '+')) && ((lastSum == "0") && (lastSign == '+'))) {
            lastChar = '+';
            return firstSum;
        } else if ((!(firstSum == "0") && (!(lastSum == "0") && (lastSign) == '+')) && lastChar == '+') {
            lastChar = '+';
            return firstSum;
        } else {
            String r;
            BigDecimal x;
            BigDecimal y = new BigDecimal(firstSum);
            BigDecimal z = new BigDecimal(lastSum);
            x = y.add(z);
            r = "" + x.stripTrailingZeros().toPlainString();
            firstSum = r;
            lastSum = "0";
            lastSign = '+';
            lastChar = '+';
            return r;
        }
    }

    public String minus() {
        if (firstSum == "0" && (!(lastSign == '-'))) {
            firstSum = lastSum;
            lastSum = "0";
            lastSign = '-';
            lastChar = '-';
            return firstSum;
        } else if ((!(firstSum == "0") && (lastSign == '-')) && ((lastSum == "0") && (lastSign == '-'))) {
            lastChar = '-';
            lastSign = '-';
            return firstSum;
        } else if ((!(firstSum == "0") && (!(lastSum == "0") && (lastSign == '-') && lastChar == '-'))) {
            lastChar = '-';
            lastSign = '-';
            return firstSum;
        } else {
            String r;
            BigDecimal x;
            BigDecimal y = new BigDecimal(firstSum);
            BigDecimal z = new BigDecimal(lastSum);
            x = y.subtract(z);
            r = x.stripTrailingZeros().toPlainString();
            firstSum = r;
            lastSum = "0";
            lastChar = '-';
            lastSign = '-';
            return r;
        }
    }

    public String mult() {
        if (firstSum == "0" && (!(lastChar == '×'))) {
            firstSum = lastSum;
            lastSign = '×';
            lastChar = '×';
            lastSum = "0";
            return firstSum;
        } else if ((!(firstSum == "0") && ((lastSum == "0") && (lastSign == '×'))) && lastChar == '×') {
            lastChar = '×';
            return firstSum;
        } else if ((!(firstSum == "0") && (!(lastSum == "0") && (lastSign == '×'))) && lastChar == '×') {
            lastChar = '×';
            return firstSum;
        } else if ((!(firstSum == "0") && ((lastSum == "0") && (lastSign == '×'))) && lastChar == '=') {
            lastChar = '×';
            return firstSum;
        } else {
            String r;
            BigDecimal x;
            BigDecimal y = new BigDecimal(firstSum);
            BigDecimal z = new BigDecimal(lastSum);
            x = y.multiply(z);
            r = x.stripTrailingZeros().toPlainString();
            if (x.signum() == 0) {
                lastSum = "0";
                lastSign = '=';
                lastChar = '=';
                setFirstSum("0");
            } else {
                firstSum = r;
                lastSign = '×';
                lastChar = '×';
                lastSum = "0";
            }
            return r;
        }
    }

    public String shared() {
        try {
            if (firstSum == "0" && (!(lastSign == '÷'))) {
                setFirstSum(lastSum);
                lastSign = '÷';
                lastChar = '÷';
                lastSum = "0";
                return firstSum;
            } else if ((!(firstSum == "0") && ((lastSum == "0") && (lastSign == '÷'))) && lastChar == '÷') {
                lastChar = '÷';
                return firstSum;
            } else if ((!(firstSum == "0") && (!(lastSum == "0") && (lastSign == '÷'))) && lastChar == '÷') {
                lastChar = '÷';
                return firstSum;
            } else if ((!(firstSum == "0") && ((lastSum == "0") && (lastSign == '÷'))) && lastChar == '=') {
                lastChar = '÷';
                return firstSum;
            } else if (((!(firstSum == "0") && lastSum == "0")) && (!(lastChar == '÷'))) {
                firstSum = "0";
                lastSum = "0";
                lastSign = '=';
                lastChar = '=';
                return "На 0 делить нельзя";
            } else {
                String r;
                BigDecimal x;
                BigDecimal y = new BigDecimal(firstSum);
                BigDecimal z = new BigDecimal(lastSum);
                x = y.divide(z, 10, BigDecimal.ROUND_HALF_UP);
                r = x.stripTrailingZeros().toPlainString();
                firstSum = r;
                lastSum = "0";
                lastSign = '÷';
                lastChar = '÷';
                return r;
            }
        } catch (Exception ex) {
            return "Fuck";
        }
    }

    public String sqrt() {

        if (!(lastSign == '√') && lastChar == '=') {
            String r;
            BigDecimal rootSqrt = new BigDecimal(firstSum);
            r = BigDecimal.valueOf(Math.sqrt(rootSqrt.doubleValue())).stripTrailingZeros().toPlainString();
            lastSum = r;
            firstSum = "0";
            lastSign = '√';
            lastChar = '=';
            return r;
        } else if (lastSign == '√' && lastChar == '=') {
            lastSign = '√';
            return lastSum;
        } else if ((!(firstSum == "0") && lastSum == "0") && lastChar == '=') {
            String r;
            BigDecimal rootSqrt = new BigDecimal(firstSum);
            r = BigDecimal.valueOf(Math.sqrt(rootSqrt.doubleValue())).stripTrailingZeros().toPlainString();
            lastSum = r;
            firstSum = "0";
            lastSign = '√';
            lastChar = '=';
            return r;
        } else {
            String r;
            BigDecimal rootSqrt = new BigDecimal(lastSum);
            r = BigDecimal.valueOf(Math.sqrt(rootSqrt.doubleValue())).stripTrailingZeros().toPlainString();
            lastSum = r;
            lastSign = '√';
            lastChar = '√';
            return r;
        }
    }

    public String gerPercent() {
        String r = "0";
        BigDecimal x;
        BigDecimal y = new BigDecimal("100");
        BigDecimal z = new BigDecimal(firstSum);
        BigDecimal a = new BigDecimal(lastSum);
        if (lastSign == '+') {
            x = z.divide(y, 10, BigDecimal.ROUND_HALF_UP);
            x = x.multiply(a);
            y = z.add(x);
            r = y.stripTrailingZeros().toPlainString();
            firstSum = r;
            lastSum = "0";
        }
        if (lastSign == '-') {
            x = z.divide(y, 10, BigDecimal.ROUND_HALF_UP);
            x = x.multiply(a);
            y = z.subtract(x);
            r = y.stripTrailingZeros().toPlainString();
        }
        if (lastSign == '×') {
            x = z.divide(y, 10, BigDecimal.ROUND_HALF_UP);
            x = x.multiply(a);
            r = x.stripTrailingZeros().toPlainString();
        }
        if (lastSign == '÷') {
            x = z.divide(y, 10, BigDecimal.ROUND_HALF_UP);
            x = x.multiply(a);
            x = z.divide(x, 10, BigDecimal.ROUND_HALF_UP);
            x = x.multiply(z);
            r = x.stripTrailingZeros().toPlainString();
        }
        lastSign = '=';
        lastChar = '=';
        firstSum = r;
        lastSum = "0";
        return r;
    }

    public String negateSign() {
        if (firstSum == "0" && (!(lastSum == "0"))) {
            BigDecimal a = new BigDecimal(lastSum);
            firstSum = a.negate().stripTrailingZeros().toPlainString();
            lastSum = "0";
            lastSign = '±';
            return firstSum;
        } else if ((!(firstSum == "0") && lastSum == "0") && lastChar == '=') {
            BigDecimal a = new BigDecimal(firstSum);
            firstSum = a.negate().stripTrailingZeros().toPlainString();
            //lastSum="0";
            lastSign = '±';
            return firstSum;
        }
        else if ((!(firstSum == "0") &&(!(lastSum == "0") && (!(lastChar == '='))))) {
            BigDecimal a = new BigDecimal(lastSum);
            lastSum = a.negate().stripTrailingZeros().toPlainString();
            //lastSum="0";
            lastSign = '±';
            return lastSum;
        }


        else
        {
            BigDecimal a = new BigDecimal(lastSum);
            lastSum = a.negate().stripTrailingZeros().toPlainString();
            lastSign = '±';
            return lastSum;}
    }

    public String degree2() {
        if (firstSum == "0" && (!(lastSum == "0"))) {
            BigDecimal a = new BigDecimal(lastSum);
            firstSum = a.multiply(a).stripTrailingZeros().toPlainString();
            lastSum = "0";
            lastSign = 'q';
            return firstSum;
        } else if ((!(firstSum == "0") && lastSum == "0") && lastChar == '=') {
            BigDecimal a = new BigDecimal(firstSum);
            firstSum = a.multiply(a).stripTrailingZeros().toPlainString();
            //lastSum="0";
            lastSign = 'q';
            return firstSum;
        }
        else if ((!(firstSum == "0") &&(!(lastSum == "0") && (!(lastChar == '='))))) {
            BigDecimal a = new BigDecimal(lastSum);
            lastSum = a.multiply(a).stripTrailingZeros().toPlainString();
            //lastSum="0";
            lastSign = 'q';
            return lastSum;
        }


        else
        {
            BigDecimal a = new BigDecimal(lastSum);
            lastSum = a.multiply(a).stripTrailingZeros().toPlainString();
            lastSign = 'q';
            return lastSum;}
    }
}







