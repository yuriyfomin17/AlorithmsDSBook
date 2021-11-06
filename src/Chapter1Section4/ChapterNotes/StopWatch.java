package Chapter1Section4.ChapterNotes;

public class StopWatch {
    long startTime = System.currentTimeMillis();
    public double elapsedTime(){
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;
    }
}
