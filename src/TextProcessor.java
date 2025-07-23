public class TextProcessor {

    public static void main(String[] args) {
        countWords("Java with Programming");
        replaceWord("Java is fun and Java is powerful", "Java", "Programming");
    }

    public static String replaceWord(String text, String oldWord, String newWord) {
        text= text.replace(oldWord, newWord);
        System.out.println("Old Word: " + oldWord + "\nNew word: "+ newWord);
        System.out.println("Text: "+ text);
        return text;
    }

    public static int countWords(String sentence) {
        String[] arr_int = sentence.split(" ");
        if (sentence.isEmpty()){
            System.out.println("Empty String");
        }
        else {
            System.out.println("Total number of words in sentence is " + arr_int.length);
        }
        return arr_int.length;
    }
}
