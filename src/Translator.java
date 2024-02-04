import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Translator {
    public int romanToArabic(String romanNumber){
        ArrayList<String> arabicArray = new ArrayList<>();
        ArrayList<String> romanArray = new ArrayList<>();
        for(int i = 0; i < 3999; i++){
            arabicArray.add(i,Integer.toString(i+1));
        }
        //Заполним массив цифрами
        for(int i = 0; i < 3999; i++) romanArray.add(getRomanNumber(i));
        return Integer.parseInt(arabicArray.get(romanArray.indexOf(romanNumber) - 1));
    }


    public String getRomanNumber(int arabicNumber) {
        //Помощник по переводу из арабской цифры в римскую
        List<String> smallRoman = Arrays.asList( "M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" );
        List<Integer> smallArabic = Arrays.asList( 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

//        System.out.println("\n" + arabicNumber);
            StringBuilder romanNumber = new StringBuilder();
            int arrayLevel = 0;

            while (arrayLevel < smallRoman.size()) {

                while (arabicNumber >= smallArabic.get(arrayLevel)){

                    int minuend = arabicNumber / smallArabic.get(arrayLevel);
                    arabicNumber = arabicNumber - (smallArabic.get(arrayLevel) * minuend);

                    for(int i = 0; i < minuend; i++) romanNumber.append(smallRoman.get(arrayLevel));
                }
                arrayLevel++;
            }
        return romanNumber.toString();
    }

}
