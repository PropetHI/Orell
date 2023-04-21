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
       Calculate addition = (int a, int b) -> {

           return a + b;
       };


        Calculate decrement = (int a, int b) -> {
           return a - b;
       };
       Calculate division = (int a, int b) -> {
           return a / b;
       };
       Calculate multiplication = (int a, int b) -> {
           return a * b;
       };


       }




    @Test
    void reset() {
    }
}