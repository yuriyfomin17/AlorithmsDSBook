package Chapter1Section4.Exercises;

public class Exe1424ThrowingEggsFromBuilding {
    public static void main(String[] args) {
        int[] floors = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int floor = throwEggFromBuildings(floors, 0 , floors.length - 1);
        System.out.println("Floor: " + floor + " Expected: 6");
        int[] lotOfFloors = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        floor = throwEggFromBuildings(lotOfFloors, 0, lotOfFloors.length - 1);
        System.out.println("Floor: " + floor + " Expected: 18");

    }

    public static int throwEggFromBuildings(int[] arr, int low, int high){
        int mid = low + (high - low) / 2;
        if (low > high) return -1;
        if (arr[mid] == 0) return throwEggFromBuildings(arr, mid + 1, high);
        else if (arr[mid] == 1 && arr[mid - 1] != 0) return throwEggFromBuildings(arr, low, mid - 1);
        else if (arr[mid] == 1 && arr[mid - 1] == 0) return mid;
        return -1;
    }
}
