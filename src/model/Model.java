package model;

import sample.ColorCode;
import sample.ModularCounter;
import java.util.Scanner;

public class Model {

    private static ModularCounter red = new ModularCounter(256);
    private static ModularCounter green = new ModularCounter(256);
    private static ModularCounter blue = new ModularCounter(256);

    private static Scanner sc = new Scanner(System.in);

    public static int getRed() {
        return red.getValue();
    }

    public static int getGreen() {
        return green.getValue();
    }

    public static int getBlue() {
        return blue.getValue();
    }

    public static void changeColorViaAbsoluteValue(ColorCode cc, int value)
    {
        if (value >= 0 && value <= 255)
        {
            switch (cc) {
                case RED:
                    red.reset(); //resets the value to zero
                    red.inc(value); //red = 0 + value
                    break;

                case GREEN:
                    green.reset();
                    green.inc(value);
                    break;

                case BLUE:
                    blue.reset();
                    blue.inc(value);
            }
        }
    }

    public static void changeColorViaRelativeValue(ColorCode cc, String operator)
    {
        if (operator.contains("+")) {
            if (cc == ColorCode.RED && red.getValue()+10 < red.getModulus()) {
                red.inc(10);
            } else if (cc == ColorCode.GREEN && green.getValue()+10 < green.getModulus()) {
                green.inc(10);
            } else {
                if (blue.getValue()+10 < blue.getModulus())
                    blue.inc(10);
            }
        }

        else if (operator.contains("-")){
            if (cc == ColorCode.RED && red.getValue()-10 >= 0) {
                red.dec(10);
            } else if (cc == ColorCode.GREEN && green.getValue()-10 >= 0) {
                green.dec(10);
            } else {
                if (blue.getValue()-10 >= 0)
                    blue.dec(10);
            }
        }

        else {
            //Nothing happens?
        }
    }

    public static String getHex()
    {
        String hexValue = "";

        String r = Integer.toHexString(red.getValue());
        if (r.length() == 1)
            hexValue += "0" + r;
        else
            hexValue += r;

        String g = Integer.toHexString(green.getValue());
        if (g.length() == 1)
            hexValue += "0" + g;
        else
            hexValue += g;

        String b = Integer.toHexString(blue.getValue());
        if (b.length() == 1)
            hexValue += "0" + b;
        else
            hexValue += b;

        return hexValue;
    }
}