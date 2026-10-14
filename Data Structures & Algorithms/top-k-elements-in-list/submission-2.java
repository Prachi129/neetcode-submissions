class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each element
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        // Step 2: Maintain a min heap of size k
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) ->
                map.get(a) - map.get(b));

        for (int ele : map.keySet()) {
            pq.offer(ele);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 3: Extract the k most frequent elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
