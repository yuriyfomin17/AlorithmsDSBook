package Chapter1Section2.ChapterExercises;

public class Exe211SmartDate {
    private final int day;
    private final int month;
    private final int year;
    private static final int[] centuryCode = { 4, 2, 0, 6}; // 1700, 1800, 1900, 2000 respectively
    private static final int[] monthsCode = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6}; // Jan, Feb, Mar, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec
    public enum WeekDays{
        // Caution order is important. Ordinal of Enum is equal to following codes  0, 1, 2, 3, 4, 5, 6
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        UNKNOWN;
        public static WeekDays getById(int id) {
            for (WeekDays dayOfWeek : WeekDays.values()){
                if (dayOfWeek.ordinal() + 1 == id) return dayOfWeek;
            }
            return UNKNOWN;
        }

    }

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
        return  day + "/" + month + "/" + year;

    }
    @Override public boolean equals(Object anotherSmartDate){
        if (this == anotherSmartDate) return true;
        if (anotherSmartDate == null) return false;
        if (getClass() != anotherSmartDate.getClass()){
            return false;
        }
        Exe211SmartDate exe211SmartDate = (Exe211SmartDate) anotherSmartDate;

        return this.day == exe211SmartDate.day && this.month == exe211SmartDate.month && this.year == exe211SmartDate.year;
    }
    @Override public final int hashCode(){
        int result = 17;
        return 31 * result + this.year + this.month + this.day;
    }

    public static WeekDays getDayOfWeek(Exe211SmartDate exe211SmartDate){
        int aDay = exe211SmartDate.getDay();
        int aMonth = exe211SmartDate.getMonth();
        int aYear = exe211SmartDate.getYear();

        // The key value method
        int lastTwoDigitOfYear = Integer.parseInt(Integer.toString(aYear).substring(2, 4));
        int runningTotal  = lastTwoDigitOfYear / 4 + aDay + monthsCode[aMonth - 1];
        if (isItLeapYear(aYear)) runningTotal -= 1;
        int currCentury = getCentury(aYear);
        int currYear = aYear;
        while (currCentury != 17 && currCentury != 18 && currCentury != 19 && currCentury != 20){
            currYear -= 400;
            currCentury = getCentury(currYear);
        }
        if (currCentury == 17) runningTotal += centuryCode[0];
        if (currCentury == 18) runningTotal += centuryCode[1];
        if (currCentury == 19) runningTotal += centuryCode[2];
        if (currCentury == 20) runningTotal += centuryCode[3];

        int dayRemainder = (runningTotal + lastTwoDigitOfYear)% 7;
        return WeekDays.getById(dayRemainder);
    }
    public static int getCentury(int aYear){
        return Integer.parseInt(Integer.toString(aYear).substring(0, 2));
    }

    public static void main(String[] args) {
        for (int i = 2020; i <= 2050 ; i++) {
            if (isItLeapYear(i)) System.out.printf("%d is leap year\n", i);
            else System.out.printf("%d is not leap year\n", i);
        }
        Exe211SmartDate smartDate1 = new Exe211SmartDate(6, 10, 2021);
        System.out.println(smartDate1 + " is " +getDayOfWeek(smartDate1));
    }
}
