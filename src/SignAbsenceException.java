public class SignAbsenceException extends Exception {
    public SignAbsenceException (String value){
        super(String.format("Выражение сформировано не верно: не верно введен знак или окрестности знака операции"));
    }
}
