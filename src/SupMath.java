import java.util.concurrent.Callable;

public class SupMath extends Calculator {

    private String firstSum = "0";
    private String lastSum = "0";
    private char lastChar = '=';

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

    public String getFirstSum() {
        return firstSum;
    }

    public String summa() {
        double x = Double.valueOf(getFirstSum()) + Double.valueOf(getLastSum());
        String r;
        if (x % 1 == 0) {
            int y = (int) x;
            setFirstSum("" + y);
            setLastSum("0");
            r = "" + y;
        } else {
            setFirstSum("" + x);
            setLastSum("0");
            r = "" + x;
        }
        setLastChar('+');
        return r;
    }

    public String minus() {
        if (getFirstSum() == "0" && (!(getLastChar() == '-'))) {
            setFirstSum(getLastSum());
            setLastSum("0");
            setLastChar('-');
            return getFirstSum();
        }
        else if ((!(getFirstSum()=="0")&&(getLastChar() == '-'))&&((getLastSum()=="0")&&(getLastChar() == '-'))){
            return getFirstSum();

        }
        else   {
            double x = Double.valueOf(getFirstSum()) - Double.valueOf(getLastSum());
            String r;
            if (x % 1 == 0) {
                int y = (int) x;
                setFirstSum("" + y);
                setLastSum("0");
                r = "" + y;
            } else {
                setFirstSum("" + x);
                setLastSum("0");
                r = "" + x;
            }
            setLastChar('-');
            return r;

        }
    }

    public String mult () {
        if (getFirstSum() == "0" && (!(getLastChar() == '×'))) {
            setFirstSum(getLastSum());
            setLastChar('×');
            setLastSum("0");
            return getFirstSum();
        }
       // else if ((!(getFirstSum()=="0"))&& getLastSum()=="0"){
         //   setLastChar('×');
         //   return getFirstSum();
        //}
        else if ((!(getFirstSum()=="0")&&(getLastChar() == '×'))&&((getLastSum()=="0")&&(getLastChar() == '×'))) {
            return getFirstSum();
        }
        else   {
            double x = Double.valueOf(getFirstSum()) * Double.valueOf(getLastSum());
            String r;
            if (x % 1 == 0) {
                int y = (int) x;
                setFirstSum("" + y);
                setLastSum("0");
                r = "" + y;
            } else {
                setFirstSum("" + x);
                setLastSum("0");
                r = "" + x;
            }
            setLastChar('×');
            return r;

        }

    }

    public String shared () {
        if (getFirstSum() == "0" && (!(getLastChar() == '÷'))) {
            setFirstSum(getLastSum());
            setLastChar('÷');
            setLastSum("0");
            return getFirstSum();
        }

        //else if (!(getFirstSum()=="0")&&((getLastSum()=="0")&&(getLastChar() == '÷'))) {
         //       setLastChar('=');
         //       return getFirstSum();
         //   }

        else if (((!(getFirstSum()=="0")&& getLastSum()=="0"))) {
        //    setLastSum("0");
        //    setFirstSum("0");
            setLastChar('=');
            return "На 0 делить нельзя";
        }


        else   {
            String r;
               double x = Double.valueOf(getFirstSum()) / Double.valueOf(getLastSum());

               if (x % 1 == 0) {
                   int y = (int) x;
                   setFirstSum("" + y);
                   setLastSum("0");
                   r = "" + y;
               } else {
                   setFirstSum("" + x);
                   setLastSum("0");
                   r = "" + x;
               }
               setLastChar('÷');
               return r;
            }

        }

    }



