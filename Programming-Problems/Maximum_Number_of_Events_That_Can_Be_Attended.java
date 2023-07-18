/*
You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

Return the maximum sum of values that you can receive by attending events.
*/

class Solution {
    public static int maxValue(int[][] events, int k) {
         Arrays.sort(events, (a, b) -> a[1] - b[1]);
         int n = events.length;
         int[][] dp = new int[n + 1][k + 1];
         for (int i = 1; i <= n; i++) {
             int startDay = events[i - 1][0];
             int endDay = events[i - 1][1];
             int value = events[i - 1][2];
             int lastEventIndex = binarySearch(events, i, startDay);
             for (int j = 1; j <= k; j++) {
                 dp[i][j] = Math.max(dp[i - 1][j], dp[lastEventIndex][j - 1] + value);
            }
        }

    return dp[n][k];
}
    private static int binarySearch(int[][] events, int end, int target) {
        int left = 0;
        int right = end - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}