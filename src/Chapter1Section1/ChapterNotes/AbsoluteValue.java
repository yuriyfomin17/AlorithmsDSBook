package Chapter1Section1.ChapterNotes;

public class AbsoluteValue {
    public static void main(String[] args) {
        long num = 1001231231;
        System.out.printf("ABS Integer %d\n", absInt(-5));
        System.out.printf("ABS Double %.1f", absDouble(-5.0));
        System.out.printf("Long %d",num );
    }

    public static int absInt(int x){
        if (x < 0) return  -x;
        else return x;
    }
    public static double absDouble(double x){
        if (x < 0.0) return  -x;
        else return x;
    }
}
// printf
// %d – for signed decimal integer
//
// %f – for the floating point
//
//  %o – octal number
//
//  %c – for a character
//
//  %s – a string
//
//  %i – use for integer base 10
//
//  %u – for unsigned decimal number
//
//  %x – hexadecimal number
//
//  %% – for writing % (percentage)
//
//  %n – for new line = \n
