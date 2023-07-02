package Java_lessons.HWJ_5;

/*Реализуйте структуру телефонной книги с помощью 
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов. */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HWJ_5 {

    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        putNewNumber(phoneBook, "+79005126982", "Иванов Саша");
        putNewNumber(phoneBook, "+79005155982", "Иванов Саша");
        putNewNumber(phoneBook, "+79005651651", "Иванова Маша");
        putNewNumber(phoneBook, "+71555541151", "Зайцев Сережа");
        putNewNumber(phoneBook, "+71616567161", "Сидоров Саша");
        putNewNumber(phoneBook, "+75159652528", "Трофимов Юра");
        putNewNumber(phoneBook, "+78954222413", "Радченко Надя");
        putNewNumber(phoneBook, "+78954227213", "Авруйская Катя");
        putNewNumber(phoneBook, "+71616567166", "Сидоров Саша");
        putNewNumber(phoneBook, "+71616567167", "Сидоров Саша");
        
        ArrayList<String> sortedNames = new ArrayList<>();
        phoneBook.keySet().forEach(name -> sortedNames.add(name));
        Collections.sort(sortedNames, new Comparator<>() {
            @Override
            public int compare(String name1, String name2) {
                return phoneBook.get(name2).size() - phoneBook.get(name1).size();
            }
        });
        for (String name : sortedNames){
            System.out.println(name + ": " + String.join(", ", phoneBook.get(name)));
        }


    }

    private static void putNewNumber(HashMap<String, ArrayList<String>> phoneBook, String number, String name) {
        phoneBook.putIfAbsent(name, new ArrayList<String>());
        phoneBook.get(name).add(number);
    }

}