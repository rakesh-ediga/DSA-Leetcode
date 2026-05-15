import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Store nums1 elements in set
        for (int num : nums1) {
            set1.add(num);
        }

        // Check common elements
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        // Convert Set to array
        int[] ans = new int[result.size()];
        int index = 0;

        for (int num : result) {
            ans[index++] = num;
        }

        return ans;
    }
}