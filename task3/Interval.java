package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.*;

public class Interval  {
    private String filename;

    public String getFilename() {
        return filename;
    }


    public Interval(String filename){
        this.filename = filename;
    }


    public void inter() {

    ArrayList<Double> arr = new ArrayList<>();
    Map<LocalTime, Double> HashMap = new HashMap<>();

try {
    FileReader fr = new FileReader(this.filename);
    BufferedReader reader = new BufferedReader(fr);
    String line = reader.readLine();
    int index;

    while (line != null) {
        index = line.indexOf("n");
        line = line.substring(0, index - 1);
        arr.add(Double.valueOf(line));
        line = reader.readLine();
    }
    fr.close();
    reader.close();

}catch (Exception e){
    System.out.println(e.getMessage());
}

        //создаем временные отрезки и добавлеям к ним значение из файла.
        int interval = 30;
        java.sql.Time myTime = java.sql.Time.valueOf("8:00:00");
        LocalTime localtime = myTime.toLocalTime();

        for (int i = 0; i <= 15; i++) {

            HashMap.put(localtime, arr.get(i));
            localtime = localtime.plusMinutes(interval);

        }
        Collections.sort(arr);

        //находим в МАПЕ ключ который соответствует макс. значению arr.
        Iterator it = HashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getValue() == arr.get(arr.size() - 1)) {
                System.out.println("Found: " + pair.getKey() + " = " + pair.getValue());
            }
            it.remove();
        }

    }
}
