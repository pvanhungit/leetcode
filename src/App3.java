//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class App3 {

    public static void main(String[] args) throws Exception {
        App3 app = new App3();
        int rs = app.lengthOfLongestSubstring("abcabcbb");
        System.out.println(rs);
    }

    public int lengthOfLongestSubstring(String s) {
        int rs = 0, lastIndex = 0;
        for(int i=0 ;i<s.length(); i++){
            char value = s.charAt(i);
            String subStr = s.substring(lastIndex, i);
            int findIdx = subStr.indexOf(value);
            if(findIdx >= 0) {
                lastIndex += findIdx + 1;
            }
            int len = i - lastIndex + 1;
            if(rs < len ) rs = len;
            
        }
        return rs;
    }
}
