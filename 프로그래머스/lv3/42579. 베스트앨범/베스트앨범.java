import java.util.*;

class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = new int[genres.length];

            Map<String, List<Node>> map = new HashMap();


            for (int i = 0; i < plays.length; i++) {
                if (!map.containsKey(genres[i])) {
                    map.put(genres[i], new ArrayList<>());
                }
                map.get(genres[i]).add(new Node(genres[i],i, plays[i]));
            }

            Queue<Node> queue = new PriorityQueue<>((a, b) -> b.sum-a.sum);


            for (String key : map.keySet()) {
                int sum = map.get(key).stream().map(m -> m.sum).mapToInt(i -> i).sum();
                queue.offer(new Node(key,0,sum));
            }

            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                List<Node> nodes = map.get(node.genreName);

                Collections.sort(nodes,(a,b)->b.sum-a.sum);

                for (int i = 0; i < 2 && !nodes.isEmpty() ; i++) {
                    Node remove = nodes.remove(0);
                    list.add(remove.index);
                }
            }


            return list.stream().mapToInt(i -> i).toArray();
        }

        static class Node {
            String genreName;
            int index;
            int sum;

            public Node(String genreName,int index, int sum) {
                this.genreName =genreName;
                this.sum = sum;
                this.index = index;
            }
        }
    }