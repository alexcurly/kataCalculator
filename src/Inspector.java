import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {

    Translator mrTranslator = new Translator();
    List<String> sig = Arrays.asList("+", "-", "*", "/");
    public enum TypeOfExpression {
        ARABIC,
        ROMAN,
        ERROR
    }
    TypeOfExpression currentTypeOfExpression;

    ArrayList<String> allowedSymbolsArrayForTestInspector = new ArrayList<>();
    ArrayList<String> romanNumbersArrayForTestInspector = new ArrayList<>();
    ArrayList<String> arabicNumbersArrayForTestInspector = new ArrayList<>();



    //==========================================================================================================

    //Проверка на допустимые символы и правильность формы записи
    public ArrayList<String> allowedSymbolsOfExpression(String str) throws SignAbsenceException, MixedNumbersInputException, NegativeRomanNumber {
        ArrayList<String> solvedExpression = new ArrayList<>();
        ArrayList<String> romanSolvedExpression = new ArrayList<>();
        ArrayList<String> expression = new ArrayList();


        Calculator mrCalculator = new Calculator();
        int sigIndexInStr = 0;
        boolean test = false;
        int numberOfSpacesInExpression = 0;


        //Сформируем массив допустимых значений
        for( int i = 0; i <= 10; i++){
            allowedSymbolsArrayForTestInspector.add(String.valueOf(i));
            arabicNumbersArrayForTestInspector.add(String.valueOf(i));
            if( i > 0){
                allowedSymbolsArrayForTestInspector.add(mrTranslator.getRomanNumber(i));
                romanNumbersArrayForTestInspector.add(mrTranslator.getRomanNumber(i));
            }
            if(i < sig.size()){
                allowedSymbolsArrayForTestInspector.add(sig.get(i));
            }
        }
        allowedSymbolsArrayForTestInspector.add(" ");

        //Пробежимся по созданному массиву, проверим выражение на допустимые символы
        for(int i = 0; i < str.length(); i++){
            if( !allowedSymbolsArrayForTestInspector.contains(String.valueOf(str.charAt(i)))
                    ||  " ".equals(String.valueOf(str.charAt(0)))
                    || " ".equals(String.valueOf(str.charAt(str.length() - 1)))
                    || numberOfSpacesInExpression > 2
            ){
                test = false;
                throw new SignAbsenceException("Выражение сформировано не верно: не верно введен знак или окрестности знака операции");
            } else {
                if(" ".equals(String.valueOf(str.charAt(i)))){
                    numberOfSpacesInExpression = numberOfSpacesInExpression + 1;
                }
                test = true;

            }
        }
        if (test){
            boolean isPositionOfSignFind = false;
            //Найдем позицию мат.знака выражения
            for(int i = 0; i < str.length(); i++){
                if( " ".equals(String.valueOf(str.charAt(i))) &&
                        sig.contains(String.valueOf(str.charAt(i+1))) &&
                        " ".equals(String.valueOf(str.charAt(i+2)))){
                    //Нахождение позиции знака мат.операции в введенном пользователем выражении
                    sigIndexInStr = i + 1;
                    isPositionOfSignFind = true;
                    break;
                }
            }
//            String surroundingsOfSign = str.substring(sigIndexInStr - 1, sigIndexInStr + 2);
//            if(isPositionOfSignFind){
//                test = true;
//            } else {
//                test = false;
//            }
        }


        if(test) {
            //Тип членов выражения: арабские или римские.
            String stringExpressionNumber1 = (str.substring(0, sigIndexInStr - 1)).replaceAll("\\s", "");
            String stringExpressionNumber2 = (str.substring(sigIndexInStr + 1, str.length())).replaceAll("\\s", "");


            if(arabicNumbersArrayForTestInspector.contains(stringExpressionNumber1) &&
                    arabicNumbersArrayForTestInspector.contains(stringExpressionNumber2)){
                currentTypeOfExpression = TypeOfExpression.ARABIC;

                expression.add(stringExpressionNumber1);
                expression.add(String.valueOf(str.charAt(sigIndexInStr)));
                expression.add(stringExpressionNumber2);

                solvedExpression.addAll(mrCalculator.calculator(expression));

//                for(int i = 0; i < solvedExpression.size(); i++) System.out.print(solvedExpression.get(i));
                System.out.println(solvedExpression.get(4));

            } else if (romanNumbersArrayForTestInspector.contains(stringExpressionNumber1) &&
                    romanNumbersArrayForTestInspector.contains(stringExpressionNumber2)){
                currentTypeOfExpression = TypeOfExpression.ROMAN;

                int intNumber1 = mrTranslator.romanToArabic(stringExpressionNumber1);
                int intNumber2 = mrTranslator.romanToArabic(stringExpressionNumber2);


                expression.add(String.valueOf(intNumber1));
                expression.add(String.valueOf(str.charAt(sigIndexInStr)));
                expression.add(String.valueOf(intNumber2));


                solvedExpression.addAll(mrCalculator.calculator(expression));

                if(Integer.parseInt(solvedExpression.get(4)) <= 0 ){
                    test = false;
                    throw new NegativeRomanNumber("Выражение сформировано не верно: отрицательные римские числа не существуют");
                }

                romanSolvedExpression.add(mrTranslator.getRomanNumber(Integer.parseInt(solvedExpression.get(0))));
                romanSolvedExpression.add(solvedExpression.get(1));
                romanSolvedExpression.add(mrTranslator.getRomanNumber(Integer.parseInt(solvedExpression.get(2))));
                romanSolvedExpression.add(solvedExpression.get(3));
                romanSolvedExpression.add(mrTranslator.getRomanNumber(Integer.parseInt(solvedExpression.get(4))));

//                for(int i = 0; i < romanSolvedExpression.size(); i++) System.out.print(romanSolvedExpression.get(i));
                System.out.print(romanSolvedExpression.get(4));

            } else {
                currentTypeOfExpression = TypeOfExpression.ERROR;
                test = false;
                throw new MixedNumbersInputException ("Выражение сформировано не верно: не верно введен знак или окрестности знака операции");
            }
        }
        return expression;
    }
}



