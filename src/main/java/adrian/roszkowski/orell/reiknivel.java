package adrian.roszkowski.orell;

import java.util.Arrays;

/******************************************************************************
 *  Nafn    : Adrian Roszkowski
 *  T-póstur: adr11@hi.is
 *
 *  Lýsing  : The code for a functional calculator.
 *
 *
 *****************************************************************************/
public class reiknivel {
    // Instead of putting the Lambda functions in a array, I put them in an individual named format
    // For more comfortable reading. I understand the minor increase in efficiency / optimization
    // When opting to use an array instead. With it being more efficient the more Lambda operations
    // / functions there are.
    public final Reikna addition = (int a, int b) -> {
        return a + b;
    };
    public final Reikna decrement = (int a, int b) -> {
        return a - b;
    };
    public final Reikna division = (int a, int b) -> {
        return a / b;
    };
    public final Reikna multiplication = (int a, int b) -> {
        return a * b;
    };

    int[] values = new int[2];
    int lastOccupied = -1;
    FunctionContainer[] functions = new FunctionContainer[1];
    int lastOccupiedFunction = -1;
    // Can decrease ram / memory usage by removing sorted functions and just simply sorting functions
    // But, keeping it this way for readability.
    FunctionContainer[] sortedFunctions;

    /**
     * Adds a new mathematical function to the array and sets the priority of said function, ie higher priority means
     * it's executed first. It also checks if the array is at its end, and if it is doubles it.
     * @param _function
     * @param priority
     */
    public void setFunction(Reikna _function, int priority){
        if (functions[functions.length-1] != null)
        {
            FunctionContainer[] newFunctions = functions;
            functions = new FunctionContainer[functions.length * 2];
            for (int i = 0; i < newFunctions.length; i++) {
                functions[i] = newFunctions[i];
            }
        }
        FunctionContainer newFunction = new FunctionContainer();
        newFunction.initialize(priority, _function);
        functions[lastOccupiedFunction+1] = newFunction;
        lastOccupiedFunction++;
    }

    /**
     * Adds a new value to the array
     * @param a The string containing the value to add.
     */
    public void setValue(String a){
        if (lastOccupied + 1 == values.length)
        {
            int[] newValues = values;
            values = new int[values.length * 2];
            for (int i = 0; i < newValues.length; i++) {
                values[i] = newValues[i];
            }
        }
        values[lastOccupied+1] = Integer.parseInt(a);
        lastOccupied++;
    }

    /**
     * Calculates the end result of the whole expression.
     * @return returns the value that the total calculation makes.
     */
    public int calculate(){
        sortFunctionArray();

        for (int i = 0; i < sortedFunctions.length; i++) {
            try{
                int value = sortedFunctions[i].reikna.calculate(values[sortedFunctions[i].originalPosition], values[sortedFunctions[i].originalPosition + 1]);
                values[sortedFunctions[i].originalPosition] = value;
                values[sortedFunctions[i].originalPosition + 1] = Integer.MIN_VALUE;
                readjustValues();
                readjustSortedArrayPositions(sortedFunctions[i].originalPosition);
            }
            catch (Exception e){
                continue;
            }

        }

        return values[0];
    }

    /**
     * Sorts the array that contains the mathematical functions.
     */
    private void sortFunctionArray() {
        sortedFunctions = Arrays.copyOf(functions, lastOccupiedFunction+1);
        int latestPriority = 0;
        int latestLocation = 0;
        for (int i = sortedFunctions.length - 1; i > 0; i--) {
            // Checks if it is at the end of the array and if not checks if the priority is greater than the latest priority
            try{
                for (int j = i == sortedFunctions.length - 1 ? sortedFunctions[i].priority > latestPriority ? 0 : latestLocation : 1; j < functions.length; j++) {
                    if (sortedFunctions[i].priority < sortedFunctions[j].priority) continue;
                    if (j > i && sortedFunctions[i].priority > sortedFunctions[j].priority) continue;
                    if (i == j) continue;
                    latestLocation = j;
                    latestPriority = sortedFunctions[i].priority;
                    sortedFunctions[i].originalPosition = i;
                    if (sortedFunctions[j].priority == sortedFunctions[i].priority) continue;
                    sortedFunctions[j].originalPosition = j;
                    FunctionContainer temp = sortedFunctions[j];
                    sortedFunctions[j] = sortedFunctions[i];
                    sortedFunctions[i] = temp;
                }
            }
            catch (Exception e){
                continue;
            }

        }
    }

    /**
     * Repositions the values in an array.
     */
    private void readjustValues(){
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == Integer.MIN_VALUE) {
                values[i] = values[i+1];
                values[i+1] = Integer.MIN_VALUE;
            }
        }
    }

    /**
     * Readjusts the sorted array after a calculation to prevent out of bounds array exception.
     * @param originalPosition The original position of the mathematical function in the array,
     *                         necessary to ensure correct calculation.
     */
    private void readjustSortedArrayPositions(int originalPosition){
        for (int i = 0; i < sortedFunctions.length; i++) {
            if (sortedFunctions[i].originalPosition < originalPosition) continue;
            sortedFunctions[i].originalPosition--;
        }
    }

    /**
     * Resets the calculator. Makes all values default again.
     */
    public void reset(){
        values = new int[2];
        lastOccupied = -1;
        lastOccupiedFunction = -1;
        functions = new FunctionContainer[1];
        sortedFunctions = null;
    }


}

/**
 * Object class that contains the necessary information for the sorting and calculation.
 */
class FunctionContainer {
    int priority = 0;
    Reikna reikna;

    int originalPosition = 0;

    // Could also have a normal constructor, went about this way simply out of habit.
    void initialize(int priority, Reikna reikna){
        this.priority = priority;
        this.reikna = reikna;
    }

    void setOriginalPosition(int a) {originalPosition = a;}

    @Override
    public String toString() {
        return "functionContainer{" +
                "priority=" + priority +
                ", reikna=" + reikna +
                ", originalPosition=" + originalPosition +
                '}';
    }
}