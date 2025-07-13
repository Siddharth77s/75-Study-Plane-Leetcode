class Solution {
      public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length; // Number of spells
            int m = potions.length; // Number of potions
            int[] result = new int[n]; // To store count of successful pairs for each spell

            Arrays.sort(potions); // Sort potions for binary search

            for (int i = 0; i < n; i++) {
                  int spell = spells[i]; // Current spell
                  int left = 0, right = m - 1; // Binary search bounds

                  // Binary search to find first valid potion
                  while (left <= right) {
                        int mid = left + (right - left) / 2;
                        long product = (long) spell * potions[mid];

                        if (product >= success) {
                              right = mid - 1;
                        } else {
                              left = mid + 1;
                        }
                  }

                  // All potions from index 'left' to end are valid
                  result[i] = m - left;
            }

            return result; // Return successful pairs for all spells
      }
}