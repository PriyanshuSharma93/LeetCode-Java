import java.util.Arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Input arrays must not be null.");
        }

        int[] a = nums1, b = nums2;
        if (a.length > b.length) {
            int[] tmp = a; a = b; b = tmp;
        }

        int m = a.length;
        int n = b.length;
        int halfLen = (m + n + 1) / 2;

        int lo = 0, hi = m;

        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = halfLen - i;

            if (i < m && b[j - 1] > a[i]) {
                lo = i + 1;
            } else if (i > 0 && a[i - 1] > b[j]) {
                hi = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = b[j - 1];
                } else if (j == 0) {
                    maxLeft = a[i - 1];
                } else {
                    maxLeft = Math.max(a[i - 1], b[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = b[j];
                } else if (j == n) {
                    minRight = a[i];
                } else {
                    minRight = Math.min(a[i], b[j]);
                }

                return ((double) maxLeft + minRight) / 2.0;
            }
        }

        // unreachable: the binary search on a valid partition space always terminates in the else branch above
        return 0.0;
    }

}