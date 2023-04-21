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
            Calculator.setValue("4");
            Calculator.setFunction(Calculator.addition, 1);
            Calculator.setValue("10");
            assertEquals( 14, Calculator.calculate());

        }

        @Test
        void setValue() {
            Calculator.setValue( "10");
            assertEquals(10, Calculator.values[0]);
        }

        @Test
        void calculate() {
            Calculator.setValue("10");
            Calculator.setFunction(Calculator.addition, 1);
            Calculator.setValue("15");;
            assertEquals(25, Calculator.values[0]);
        }

        @Test
        void reset() {
            Calculator.setFunction(Calculator.addition, 1);
            Calculator.setValue("15");;
            Calculator.calculate();
            Calculator.reset();
        }
    }

