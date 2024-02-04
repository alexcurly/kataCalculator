public class MixedNumbersInputException extends Exception {
    public MixedNumbersInputException(String value){
        super(String.format("Введенное выражение должно быть однообразным. Используете только арабские, либо римские цифры"));
    }
}