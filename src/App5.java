//https://leetcode.com/problems/interleaving-string/
public class App5 {

    public static void main(String[] args) throws Exception {
        App5 app = new App5();
        boolean rs = false;

        // rs = app.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        // System.out.println("case 1 : " + rs);

        // rs = app.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        // System.out.println("case 2 : " + rs);
        
        // rs = app.isInterleave("", "", "");
        // System.out.println("case 3 : " + rs);

        // rs = app.isInterleave("aabd", "abdc", "aabdabcd");
        // System.out.println("case 4 : " + rs);

        rs = app.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
         "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", 
         "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
        System.out.println("case 4 : " + rs);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if( (s1 + s2).equals(s3) || (s2 + s1).equals(s3)) return true;

        boolean rs1 = s1.length() >0 && s3.length() > 0 && s1.charAt(0) == s3.charAt(0);
        boolean rs2 = s2.length() >0 && s3.length() > 0 && s2.charAt(0) == s3.charAt(0);
        return rs1 &&  isInterleave(s2, s1.substring(1, s1.length()), s3.substring(1, s3.length())) ||
        rs2 && isInterleave(s2.substring(1, s2.length()) , s1 , s3.substring(1, s3.length()));

    }
}
