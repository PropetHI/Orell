package adrian.roszkowski.orell.frontend;


import adrian.roszkowski.orell.backend.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/******************************************************************************
 *  Nafn    : Adrian Roszkowski
 *  T-póstur: adr11@hi.is
 *
 *  Lýsing  : The controller used to interact with the calculator.
 *
 *
 *****************************************************************************/
public class reiknivelController {

    private reiknivel _reiknivel = new reiknivel();

    // Using a string instead of multiplying the value by ten is a readability improvement for me. Also, something
    // A little different than the obvious answer.
    private String numberString = "";
    private String totalString = "";

    private int[] values = new int[2];

    public void updateInput(){
        label_output.setText(totalString);
    }

    @FXML
    Label label_output;

    // Instead of having each button having its own function, I could write a single function that then reads the text of the button
    // As the value, after all the text of button_1 would be "1" and so on. But I'm going to keep it this way. Reason: Rewriting this
    // Would add no value. Also, this is slightly more human friendly in my opinion, though maybe not programmer friendly.
    @FXML
    private void button_1_pressed(){
        numberString += "1";
        totalString += "1";
        updateInput();
    }


    @FXML
    private void button_2_pressed(){
        numberString += "2";
        totalString += "2";
        updateInput();
    }

    @FXML
    private void button_3_pressed(){
        numberString += "3";
        totalString += "3";
        updateInput();
    }


    @FXML
    private void button_4_pressed(){
        numberString += "4";
        totalString += "4";
        updateInput();
    }


    @FXML
    private void button_5_pressed(){
        numberString += "5";
        totalString += "5";
        updateInput();
    }


    @FXML
    private void button_6_pressed(){
        numberString += "6";
        totalString += "6";
        updateInput();
    }


    @FXML
    private void button_7_pressed(){
        numberString += "7";
        totalString += "7";
        updateInput();
    }


    @FXML
    private void button_8_pressed(){
        numberString += "8";
        totalString += "8";
        updateInput();
    }


    @FXML
    private void button_9_pressed(){
        numberString += "9";
        totalString += "9";
        updateInput();
    }

    @FXML
    private void button_0_pressed(){
        numberString += "0";
        totalString += "0";
        updateInput();
    }

    @FXML
    private void button_clear_pressed(){
        reset();
    }

    @FXML
    private void button_decrement_pressed(){
        if (numberString.equals("")) return;
        _reiknivel.setValue(numberString);
        numberString = "";
        _reiknivel.setFunction(_reiknivel.decrement, 0);
        totalString += " - ";
        updateInput();
    }

    @FXML
    private void button_addition_pressed(){
        if (numberString.equals("")) return;
        _reiknivel.setValue(numberString);
        numberString = "";
        _reiknivel.setFunction(_reiknivel.addition, 1);
        totalString += " + ";
        updateInput();
    }

    @FXML
    private void button_division_pressed(){
        if (numberString.equals("")) return;
        _reiknivel.setValue(numberString);
        numberString = "";
        _reiknivel.setFunction(_reiknivel.division, 2);
        totalString += " / ";
        updateInput();
    }

    @FXML
    private void button_multiplication_pressed(){
        if (numberString.equals("")) return;
        _reiknivel.setValue(numberString);
        numberString = "";
        _reiknivel.setFunction(_reiknivel.multiplication, 3);
        totalString += " * ";
        updateInput();
    }

    @FXML
    private void button_result_pressed(){
        if (numberString != ""){
            _reiknivel.setValue(numberString);
        }
        int value = _reiknivel.calculate();
        totalString = Integer.toString(value);
        updateInput();
        _reiknivel.reset();

        numberString = Integer.toString(value);
    }

    private void reset() {
        _reiknivel.reset();
        totalString = "";
        numberString = "";
        updateInput();
    }


}

