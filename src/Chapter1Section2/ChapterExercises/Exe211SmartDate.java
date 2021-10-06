package Chapter1Section2.ChapterExercises;

public class Exe211SmartDate {
    private final int day;
    private final int month;
    private final int year;

    public Exe211SmartDate(int aDay, int aMonth, int aYear){
        if (!isValidDate(aDay, aMonth, aYear)) throw new IllegalArgumentException("Not correct date");
        this.day = aDay;
        this.month = aMonth;
        this.year = aYear;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public static boolean isValidDate(int aDay, int aMonth, int aYear){
        // february has  28 days in a common year and 29 days in leap years
        int[] daysInMonthsCommon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInMonthsLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInMonths;
        if (isItLeapYear(aYear)) daysInMonths = daysInMonthsLeap;
        else daysInMonths = daysInMonthsCommon;
        if (aYear < 1) return false;
        if (aMonth < 1 || aMonth > 12) return false;
        if (aDay < 1 || aDay > daysInMonths[aMonth -1]) return false;
        return true;
    }
    public static boolean isItLeapYear(int aYear){
        if (aYear % 4 == 0 && aYear % 100 != 0) return true;
        if (aYear % 4 == 0 && aYear % 100 == 0 && aYear % 400 == 0 ) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Exe211SmartDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public static void main(String[] args) {
        for (int i = 2020; i <= 2050 ; i++) {
            if (isItLeapYear(i)) System.out.printf("%d is leap year\n", i);
            else System.out.printf("%d is not leap year\n", i);
        }
        Exe211SmartDate smartDate1 = new Exe211SmartDate(4, 18, 1989);
        Exe211SmartDate invalidDate = new Exe211SmartDate(2, 30, 2016);
    }
}
