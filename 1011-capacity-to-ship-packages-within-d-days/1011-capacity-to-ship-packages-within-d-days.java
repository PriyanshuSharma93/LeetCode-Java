class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Minimum capacity = maximum weight
        // Maximum capacity = sum of all weights
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // Binary Search
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                // This capacity works.
                // Try to find a smaller capacity.
                high = mid;
            } else {
                // Capacity is too small.
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int currentLoad = 0;
        int daysNeeded = 1;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {
                // Start a new day
                daysNeeded++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return daysNeeded <= days;
    }
}