import java.util.ArrayList;
import java.util.Arrays;

public class GradeManager {

    public static void main(String[] args){
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        reverseStudentNames(students);
        getLetterGrade(89);
        findFailingStudents(students, scores);
    }

    public static ArrayList<String> reverseStudentNames(String[] names) {

        java.util.ArrayList<String> list = new java.util.ArrayList<>();

        for (int i = 0; i < names.length ; i ++){
            StringBuilder current_word = new StringBuilder(names[i]);
            current_word.reverse();
            list.add(String.valueOf(current_word));
        }
        System.out.println("Original array " + Arrays.toString(names) + " \nModified array " + list);
        return list;
    }

    public static char getLetterGrade(int score) {
        if(score > 90 && score < 100){
            System.out.println("Grade: A");
        } else if (score > 79) {
            System.out.println("Grade: B");
        } else if (score > 69) {
            System.out.println("Grade: C");
        }else if (score > 59) {
            System.out.println("Grade: D");
        }else if (score > -1) {
            System.out.println("Grade: F");
        }
        else {
            System.out.println("INVALID INPUT");
        }
        return (char) score;
    }

    public static String[] findFailingStudents(String[] names, int[] scores) {
        for (int i = 0; i < names.length; i++) {
            if (scores[i] < 60) {
                System.out.println(names[i] + " has failed the course");
            }
        }
        return names;
    }


}
