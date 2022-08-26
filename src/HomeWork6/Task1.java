package HomeWork6;

public class Task1 {

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }

}

class ParkingSystem {

    int[] parkingPlaces;

    public ParkingSystem(int big, int medium, int small) {
        this.parkingPlaces = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (parkingPlaces[carType - 1] == 0) {
            return false;
        } else {
            parkingPlaces[carType - 1] -= 1;
        }
        return true;
    }
}
