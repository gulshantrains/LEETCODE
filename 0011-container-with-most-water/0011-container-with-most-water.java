class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // If we calculate area ie.(width*height) and height which
            // is smaller as water have to hold
            // as we will move pointer then width will decrease so we have to
            // increase height to counter balance MAXAREA
            // increase height means take height which is greater among two

            int area = Math.min(height[left], height[right]) * (right - left);

            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else
                right--;
        }
        return maxArea;

    }
}