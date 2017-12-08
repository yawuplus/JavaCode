package com.company.lexer;

public class Real extends Token{
    public final float value;

    Real(float v){
        super(Tag.REAL);
        value=v;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
