package Chapter1Section2.ChapterExercises;

public class Exe126CircularString {
    public static void main(String[] args) {
        String string1 = "ACTGACG";
        String string2 = "TGACGAC";
        if (isCircularString2(string1, string2)) System.out.println("They are Circular!");
        else System.out.println("No they are not circular!");
    }
    // stupid solution
    public static boolean isCircularString(String string1, String string2){
        int count = 0;
        while (count < string1.length() ){
            String currChar = string1.substring(string1.length() - 1);
            string1 = string1.substring(0, string1.length() - 1);
            string1 = currChar + string1;
            if (string1.equals(string2)) return true;
            count+=1;
        }
        return false;
    }
    // one liner solution that doesn't check null values
    public static boolean isCircularString2(String string1, String string2){
        return string1.length() == string2.length() && (string1 + string2).contains(string2);
    }
}
