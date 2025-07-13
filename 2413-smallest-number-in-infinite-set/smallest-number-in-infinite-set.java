class SmallestInfiniteSet {
      PriorityQueue<Integer> pq; // Min-heap to store added-back numbers

      int nextNum; // The next smallest number to be returned

      public SmallestInfiniteSet() {
            pq = new PriorityQueue<>(); // Initialize priority queue
            nextNum = 1; // Start with the smallest positive integer
      }

      public int popSmallest() {
            if (pq.size() == 0) {
                  return nextNum++; // Return and increment nextNum
            }
            return pq.poll(); // Return and remove the smallest element from pq
      }

      public void addBack(int num) {
            if (num < nextNum && !pq.contains(num)) {
                  pq.add(num); // Add only if it's smaller than nextNum and not already in pq
            }
      }
}