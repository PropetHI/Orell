package adrian.roszkowski.orell.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class reiknivelTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void calculate() {
        //TODO make a test for this function
        Calculate calculator = new Calculate() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        double result = calculator.calculate(2, 3);
        assertEquals(5.0, result, 0.0001);

            Calculate calculator1 = new Calculate() {
                @Override
                public int calculate(int a, int b) {
                    return a-b;
                }
            };
            double result2 = calculator.calculate(5,  3);
            assertEquals(2.0, result, 0.0001);

            Calculate calculator3 = new Calculate() {
                @Override
                public int calculate(int a, int b) {
                    return a*b;
                }
            };
            double result3 = calculator.calculate(2,  3);
            assertEquals(6, result, 0.0001);

            Calculate calculate4 = new Calculate() {
                @Override
                public int calculate(int a, int b) {
                    return a/b;
                }
            };
            double result4 = calculator.calculate(10,  2);
            assertEquals(5, result, 0.0001);






    }




























    @Test
    void reset() {

    }
}