import java.util.*;

class Solution {
    private class Truck {
        int weight;
        int pos;
        
        Truck(int weight, int pos) {
            this.weight = weight;
            this.pos = pos;
        }
        
        @Override
        public String toString() {
            return "(" + this.weight + " " + this.pos + ")";
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            queue.add(truck_weight);
        }
        
        Queue<Truck> bridgeQueue = new LinkedList<>();
        int sum = 0, time = 0;
        
        while (!queue.isEmpty() || !bridgeQueue.isEmpty()) {
            // System.out.println(bridgeQueue + " " + sum + " " + time);
            if (!bridgeQueue.isEmpty()) {
                Truck truck = bridgeQueue.peek();
                if (truck.pos == bridge_length) {
                    bridgeQueue.poll();
                    sum -= truck.weight;
                }
                int size = bridgeQueue.size();
                while(size-- > 0) {
                    Truck t = bridgeQueue.poll();
                    bridgeQueue.add(new Truck(t.weight, t.pos + 1));
                }
            }
            
            if (!queue.isEmpty()) {
                int next = queue.peek();
                if (bridgeQueue.size() < bridge_length && sum + next <= weight) {
                    bridgeQueue.add(new Truck(next, 1));
                    queue.poll();
                    sum += next;
                }
            }
            
            time++;
        }
            
        int answer = 0;
        return time;
    }
}