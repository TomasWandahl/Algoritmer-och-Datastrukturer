package se.kth.vandahl.project2;

/**
 * Created by Tomas Wändahl on 2016-12-31.
 * All rights reserved.
 * Yeah.
 */
public class Query {
    QueryExpression expression;
    private String property;
    private String direction;

    public Query (QueryExpression ex, String property, String direction) {
        this.expression = ex;
        this.property = property;
        this.direction = direction;
    }

    public String getProperty () {
        return this.property;
    }

    public String getDirection () {
        return this.direction;
    }

    public String infix () {
        return this.expression.infix();
    }

    public String prefix () {
        return this.expression.prefix();
    }

    public String postfix () {
        return this.expression.postfix();
    }

    @Override
    public String toString () {
        return this.infix() + " ORDER BY " + this.property + " " + this.direction;
    }
}