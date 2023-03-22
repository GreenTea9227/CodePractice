import java.util.*;

class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;
            Queue<Truck> queue = new LinkedList<>();
            Queue<Truck> inBridge = new LinkedList<>();


            for (int truckWeight : truck_weights) {
                queue.offer(new Truck(0,truckWeight));
            }

            int bridgeWeight =0;

            while (!queue.isEmpty() || !inBridge.isEmpty()) {

                while (inBridge.size() >0 && inBridge.peek().time == bridge_length) {
                    Truck poll = inBridge.poll();
                    bridgeWeight-= poll.weight;
                }


                if (queue.size()>0 && queue.peek().weight + bridgeWeight <= weight) {

                    Truck poll = queue.poll();
                    inBridge.offer(poll);
                    bridgeWeight+= poll.weight;
                }

                for (Truck truck : inBridge) {
                    truck.time+=1;
                }


                time++;
            }

            return time;
        }
    }

    class Truck {
        public int time;
        public int weight;

        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }

      
    }