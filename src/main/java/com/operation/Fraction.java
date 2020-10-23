package com.operation;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Slf4j
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction addFraction(Fraction fraction){
        Fraction result = new Fraction();
        result.numerator += (numerator * fraction.getDenominator() + denominator * fraction.getNumerator());
        result.denominator += (fraction.getDenominator() * denominator);

        if(canBeSimplified(result))
            result.simplify();

        return result;
    }

    private void simplify(){
        int gcd;

        if(numerator > denominator)
            gcd = computeGcd(denominator, numerator);
        else gcd = computeGcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;
    }

    private int computeGcd(int smaller, int largest){
        if(largest == 0)
            return smaller;

        return  computeGcd(largest, smaller % largest);
    }

    private boolean canBeSimplified(Fraction fraction){
        return fraction.getNumerator() != 0 && fraction.getDenominator() != 1;
    }

    public String toString(){
        return numerator == 0 ?  "0" : denominator == 1 ?  String.valueOf(numerator) :  numerator+" / "+denominator;
    }

    public Integer getSimplifiedFraction() throws NumberFormatException {
        if (numerator == 0)
            return 0;
        else if (denominator == 1)
            return numerator;
        else if (numerator % denominator == 0)
            return numerator / denominator;
        else
            throw new NumberFormatException("This fraction can't be simplified");
    }
}
