package adrian.roszkowski.orell.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {



    Calculator Calculator;
        @BeforeEach
        void setUp() {
            Calculator = new Calculator();
        }

        @Test
        void setFunction() {
            Calculator.setFunction(Calculator.addition, 1);
            assertEquals( 0, Calculator.values[1]);

        }

        @Test
        void setValue() {
            Calculator.setValue( "10");
            assertEquals(10, Calculator.values[0]);
        }

        @Test
        void calculate() {
            Calculator.setFunction(Calculator.addition, 1);
            Calculator.setValue("15");;
            Calculator.calculate();
            assertEquals(15, Calculator.values[0]);
        }

        @Test
        void reset() {
            Calculator.setFunction(Calculator.addition, 1);
            Calculator.setValue("15");;
            Calculator.calculate();
            Calculator.reset();
        }
    }

