//https://leetcode.com/problems/longest-palindromic-substring/
public class App4 {

    public static void main(String[] args) throws Exception {
        App4 app = new App4();
        String rs = app.longestPalindrome("cccc");
        System.out.println(rs);
    }

    public String longestPalindrome(String s) {
        String rs = "";
        int maxLen = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            int l = i - 1, r = i + 1;
            boolean pa1 = l >= 0 && r < len && s.charAt(l) == s.charAt(r);// case aca
            boolean pa2 = r < len && s.charAt(r) == s.charAt(i);// case aa
            boolean hasPE = pa1 || pa2;

            int localLen = 0, len1 = 0, len2 = 0;
            if (hasPE) {
                int l1=0,l2=0,r1=0,r2=0;

                // handle case 1
                if (pa1) {
                    len1 = 1;
                    l1 = i - 1;
                    r1 = i + 1;

                    while (l1 >= 0 && r1 < len && s.charAt(l1) == s.charAt(r1)) {
                        l1--;
                        r1++;
                        len1 += 2;
                    }
                    l1++;
                    r1--;
                }
                // handle case 2
                if (pa2) {
                    l2 = i;
                    r2 = i + 1;
                    len2 = 0;

                    while (l2 >= 0 && r2 < len && s.charAt(l2) == s.charAt(r2)) {
                        l2--;
                        r2++;
                        len2 += 2;
                    }
                    l2++;
                    r2--;
                }
                if( r1 - l1 > r2 -l2) {
                    localLen = r1 - l1 + 1;
                    l = l1;
                    r = r1;
                } else {
                    localLen = r2 - l2 + 1;
                    l = l2;
                    r = r2;
                }
                
            } else {
                l = i;
                r = i;
                localLen = 1;
            }
            if (localLen > maxLen) {
                maxLen = localLen;
                rs = s.substring(l, maxLen + l);
            }
        }
        return rs;
    }
}
