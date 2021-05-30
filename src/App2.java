//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class App2 {

    public static void main(String[] args) throws Exception {
        App2 app = new App2();

        int[] nums = new int[] { 2, 2, 2, 2, 2 };
        //int[] nums = new int[]{1,3,5,4,7,8};
        //int[] nums = new int[]{3,1,2};

        int rs = app.findNumberOfLIS(nums);

        System.out.println(rs);
    }

    public int findNumberOfLIS(int[] nums) {
        int maxLen = 1;

        int[] lens = new int[nums.length];
        int[] times = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            // init
            lens[i] = 1;

            // find max len of i
            int value = nums[i];
            for (int k = i - 1; k >= 0; k--) {
                int valueK = nums[k];
                if (valueK < value && (lens[i] < lens[k] + 1)) {
                    lens[i] = lens[k] + 1;
                }
            }

            // update number of local Max Len
            int maxLocalLen = lens[i];
            for (int k = i - 1; k >= 0; k--) {
                int valueK = nums[k];
                if (valueK < value && (maxLocalLen == lens[k] + 1) ) {
                    times[i] += times[k];
                }
            }
            if(times[i] == 0) {
                times[i] = 1;
            }

            if (maxLocalLen > maxLen) {
                maxLen = maxLocalLen;
            }
        }
        int rs = 0;
        for(int i = 0; i< nums.length; i++) {
            if(lens[i] == maxLen) {
                rs += times[i];
            }
        }
        return rs;
    }
}
