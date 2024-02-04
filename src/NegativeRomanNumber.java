
public class NegativeRomanNumber extends Exception {
    public NegativeRomanNumber (String value){
        super(String.format("Выражение сформировано не верно: отрицательные римские числа не существуют"));
    }
}