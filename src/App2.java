//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class App2 {

    public static void main(String[] args) throws Exception {
        App2 app = new App2();

        //int[] nums = new int[] { 1,2,3,4,6,8,3,4,5 };
        int[] nums = new int[]{1,3,5,4,7,8};
        //int[] nums = new int[]{3,1,2};

        int rs = app.findNumberOfLIS(nums);

        System.out.println(rs);
    }

    public int findNumberOfLIS(int[] nums) {
        int maxLen = 0, rs = 0;
        int[] lens = new int[nums.length];
        int[] cnt = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++) {
            int value = nums[i];

            lens[i] = cnt[i] = 1;
            for(int k = 0; k < i; k++) {
                int valueK = nums[k], lenK = lens[k];
                if(valueK < value ) {
                    if (lens[i] == lens[k] + 1 ) {
                        cnt[i] += cnt[k];
                    } else if(lens[i] <= lenK) {
                        lens[i] = lenK + 1;
                        cnt[i] = cnt[k];
                    }                   
                }
            }

            if(maxLen < lens[i]) {
                maxLen = lens[i];
                rs = cnt[i];
            } else if (maxLen == lens[i]) {
                rs += cnt[i];
            }
        }

        return rs;
    }
}
