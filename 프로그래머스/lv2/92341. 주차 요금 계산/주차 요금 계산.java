import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
     HashMap<String, String> carMap = new HashMap<>();
        HashMap<String, Integer> answerTime = new HashMap<>();

        int bTime = fees[0];
        int bPay = fees[1];
        int mMinute = fees[2];
        int mPay = fees[3];

        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");

            String time = split[0];
            String carNumber = split[1];

            if (split[2].equals("IN")) {
                carMap.put(carNumber, time);
                continue;
            }

            String inTime = carMap.get(carNumber);
            int differTime = checkTime(inTime, time);
            answerTime.put(carNumber, answerTime.getOrDefault(carNumber, 0) + differTime);
            carMap.remove(carNumber);
        }

        for (Map.Entry<String, String> entry : carMap.entrySet()) {
            String carNumber = entry.getKey();
            String value = entry.getValue();
            int differTime = checkTime("23:59", value);
            answerTime.put(carNumber, answerTime.getOrDefault(carNumber, 0) + differTime);
        }
        
       return answerTime.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(i -> {
            Integer time = i.getValue();
            int pay =0;
            if (time > bTime) {
                   pay = (int)Math.ceil(((double)time - bTime) / mMinute) * mPay;
            }
            return pay + bPay;
        }).mapToInt(i -> i).toArray();
            
    }


    public int checkTime(String first, String second) {
        return Math.abs(calculateMinute(first) - calculateMinute(second));
    }

    private int calculateMinute(String first) {
        String[] firstArr = first.split(":");
        int f1 = Integer.parseInt(firstArr[0]) * 60;
        int f2 = Integer.parseInt(firstArr[1]);
        return f1 + f2;
    }
}