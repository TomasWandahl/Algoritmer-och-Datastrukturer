package se.kth.vandahl.project2;

/**
 * Created by Tomas Wändahl on 2016-12-31.
 * All rights reserved.
 * Yeah.
 */

public enum Operator {
    PLUS, OR, MINUS;

    public static Operator get (char c) {
        if (c == '-') {
            return Operator.MINUS;
        } else if (c == '|') {
            return Operator.OR;
        } else if (c == '+') {
            return Operator.PLUS;
        }
        return null;
    }

    @Override
    public String toString () {
        if (this == Operator.MINUS) {
            return "-";
        } else if (this == Operator.OR) {
            return "|";
        } else if (this == Operator.PLUS) {
            return "+";
        }
        return null;
    }
}
