import com.operation.Fraction;
import org.junit.Test;
import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void testAddFractionsWithZeroAsNumerator(){
        Fraction fraction1 = new Fraction(0,1);
        Fraction fraction2 = new Fraction(0,5);

        assertEquals(Fraction.builder().numerator(0).denominator(5).build(), fraction1.addFraction(fraction2));
    }

    @Test
    public void testAddFractionsWithOneAsDenominator(){
        Fraction fraction1 = new Fraction(2,1);
        Fraction fraction2 = new Fraction(3,1);

        assertEquals(Fraction.builder().numerator(5).denominator(1).build(), fraction1.addFraction(fraction2));
    }

    @Test
    public void testAddFractionsWithSameDenominator(){
        Fraction fraction1 = new Fraction(5,7);
        Fraction fraction2 = new Fraction(3,7);

        assertEquals(Fraction.builder().numerator(8).denominator(7).build(), fraction1.addFraction(fraction2));
    }

    @Test
    public void testAddFractionsWithOneDenominatorAsGcd(){
        Fraction fraction1 = new Fraction(2,4);
        Fraction fraction2 = new Fraction(3,20);

        assertEquals(Fraction.builder().numerator(13).denominator(20).build(), fraction1.addFraction(fraction2));
    }

    @Test
    public void testAddFractionsWithDifferentDenominator(){
        Fraction fraction1 = new Fraction(2,4);
        Fraction fraction2 = new Fraction(3,7);

        assertEquals(Fraction.builder().numerator(13).denominator(14).build(), fraction1.addFraction(fraction2));
    }

    @Test(expected = NumberFormatException.class )
    public void testImpossibleSimplificationThrowsException() throws NumberFormatException {
        new Fraction(2,7).getSimplifiedFraction();
    }

    @Test
    public void testAddFractionsAndGetSimplifiedResult1() throws NumberFormatException {
        Fraction fraction1 = new Fraction(0,4);
        Fraction fraction2 = new Fraction(0,7);

        assertEquals(0, (fraction1.addFraction(fraction2)).getSimplifiedFraction().intValue());
    }

    @Test
    public void testAddFractionsAndGetSimplifiedResultScenario2() throws NumberFormatException {
        Fraction fraction1 = new Fraction(12,1);
        Fraction fraction2 = new Fraction(8,1);

        assertEquals(20, (fraction1.addFraction(fraction2)).getSimplifiedFraction().intValue());
    }

    @Test
    public void testAddFractionsAndGetSimplifiedResultScenario3() throws NumberFormatException {
        Fraction fraction1 = new Fraction(5,4);
        Fraction fraction2 = new Fraction(11,4);

        assertEquals(4, (fraction1.addFraction(fraction2)).getSimplifiedFraction().intValue());
    }

}
