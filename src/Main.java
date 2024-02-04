import java.util.*;
public class Main {
    public static void main(String[] args) throws SignAbsenceException, MixedNumbersInputException, NegativeRomanNumber {

        Calculator mrCalculator = new Calculator();
        Inspector mrInspector = new Inspector();
        //Создаем примитивный словарь римских цифр на базе ArrayList (не хочу использовать HashMap and so on)
        Translator translator = new Translator();
        //Создадим Римский Массив
//        String str = null;

        //=========================================================================================
        System.out.println("Введите выражения для расчета по примеру: 2 + 1 , нажмите enter ");


                //Зафиксируем введенное выражение пользователя
                Scanner scan = new Scanner(System.in);

        while(true){
            mrCalculator.calculator(mrInspector.allowedSymbolsOfExpression(scan.nextLine()));
            System.out.println("");
        }

//                try{
//                    while(true){
//                        mrCalculator.calculator(mrInspector.allowedSymbolsOfExpression(scan.nextLine()));
//                        System.out.println("");
//                    }
//                }catch (RuntimeException | SignAbsenceException | MixedNumbersInputException | NegativeRomanNumber E) {
//                    System.out.println("Проблемма с вводом данных. Попробуете провести операцию снова.");
//                } finally {
//                    scan.close();
//        }

    }
}
