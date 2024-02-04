import java.util.ArrayList;

public class Calculator {
    public ArrayList<String> calculator(ArrayList<String> expression) {
        ArrayList<String> solvedExpression = new ArrayList<>();
        int number1 = Integer.parseInt(expression.get(0));
        int number2 = Integer.parseInt(expression.get(2));
        String significant = expression.get(1);


        String sum = null;
        switch (significant) {
            case ("+"): sum = Integer.toString(number1 + number2);
                break;

            case ("-"): sum = Integer.toString(number1 - number2);
                break;

            case ("*"): sum = Integer.toString(number1 * number2);
                break;

            case ("/"): sum = Integer.toString(number1 / number2);
                break;
        }

        solvedExpression.add(expression.get(0));
        solvedExpression.add(" " + expression.get(1) + " ");
        solvedExpression.add(expression.get(2));
        solvedExpression.add(" = ");
        solvedExpression.add(sum);
        return solvedExpression;
    }
}
