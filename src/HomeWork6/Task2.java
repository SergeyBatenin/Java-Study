package HomeWork6;

import java.util.HashMap;
import java.util.Map;

public class Task2 {

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 21);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));

    }
}

class UndergroundSystem {
    // А в джаве нету такой структуры данных, как кортеж? В шарпе немного работал с ним и в питоне
    // Поэтому хотелось тоже здесь использовать, делать кортеж маршрута Начала и Конца, чтобы
    // можно было использовать как ключ, а то не очень хотелось работать со строкой(
    Map<String, int[]> routes = new HashMap<>();
    Map<Integer, String[]> onTheWay = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        onTheWay.put(id, new String[]{stationName, String.valueOf(t)});
    }

    public void checkOut(int id, String stationName, int t) {
        String stationStart = onTheWay.get(id)[0];
        int timeStart = Integer.parseInt(onTheWay.get(id)[1]);
        onTheWay.remove(id);
        String route = makeRoute(stationStart, stationName);
        if (routes.containsKey(route)) {
            // Можно ли как то более кратко записывать увеличение значения в мапе ?
            // А то почему то тоже кажется что как то более громоздко выглядит
            int numbersTrips = routes.get(route)[0] + 1;
            int timeTrips = routes.get(route)[1] + (t - timeStart);
            routes.put(route, new int[]{numbersTrips, timeTrips});
        } else {
            routes.put(route, new int[]{1, t - timeStart});
        }
    }

    public double getAverageTime(String stationStart, String stationEnd) {
        String route = makeRoute(stationStart, stationEnd);
        double timeTrips = routes.get(route)[1];
        int numberTrips = routes.get(route)[0];

        return timeTrips / numberTrips;
    }

    private String makeRoute(String startPoint, String endPoint) {
        return startPoint + "-" + endPoint;
    }
}
