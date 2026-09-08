class Solution {
    public int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {
            long n = (long) num;

            // Skip duplicate numbers
            if ((first != null && n == first) || 
                (second != null && n == second) || 
                (third != null && n == third)) {
                continue;
            }

            // Update top 3 values
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        // If third distinct maximum exists, return it; otherwise return the maximum
        return third != null ? third.intValue() : first.intValue();
    }
}