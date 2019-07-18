package CodingInterview;

public class _19_RegularExpressMatch {

    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder patternBuilder = new StringBuilder(pattern);
        return matchCore(strBuilder, 0, patternBuilder, 0);
    }

    public static boolean matchCore(StringBuilder str, int strIndex, StringBuilder pattern, int patternIndex) {
        if (strIndex == str.length() && patternIndex == pattern.length())
            return true;
        if (strIndex != str.length() && patternIndex == pattern.length())
            return false;
        if (strIndex == str.length()) {
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*')
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            else
                return false;
        }

        if (patternIndex == pattern.length() - 1 || pattern.charAt(patternIndex + 1) != '*') {
            if (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.') {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }


        } else {

            if (pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex))
                return matchCore(str, strIndex + 1, pattern, patternIndex)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex, pattern, patternIndex + 2);
            else
                return matchCore(str, strIndex, pattern, patternIndex + 2);

        }


        return false;
    }

//    public static boolean matchCore(StringBuilder str,int strIndex,StringBuilder pattern, int patternIndex){
//        //如果匹配串和模式串都匹配结束
//        if(strIndex==str.length() && patternIndex==pattern.length())
//            return true;
//        //如果匹配串没结束，模式串结束了
//        if(strIndex!=str.length() && patternIndex==pattern.length())
//            return false;
//        if(strIndex == str.length()) {
//            if(patternIndex+1<pattern.length()&&pattern.charAt(patternIndex+1)=='*')
//                return matchCore(str,strIndex,pattern,patternIndex+2);
//            else
//                return false;
//        }
//        //如果模式串的第二个字符不是*或者已经只剩一个字符了
//        if(patternIndex==pattern.length()-1|| pattern.charAt(patternIndex+1)!='*'){
//            if(pattern.charAt(patternIndex)=='.' || pattern.charAt(patternIndex)==str.charAt(strIndex))
//                return matchCore(str,strIndex+1,pattern,patternIndex+1);
//            else
//                return false;
//        }
//        //如果模式串的第二个字符是*
//        else{
//            if(pattern.charAt(patternIndex)=='.'||pattern.charAt(patternIndex)==str.charAt(strIndex))
//                return matchCore(str,strIndex+1,pattern,patternIndex)
//                        ||matchCore(str,strIndex+1,pattern,patternIndex+2)
//                        ||matchCore(str,strIndex,pattern,patternIndex+2);
//            else
//                return matchCore(str,strIndex,pattern,patternIndex+2);
//        }
//    }


    public static void main(String[] args) {
        System.out.println(match("aaa", "a.a"));//true
        System.out.println(match("aaa", "ab*ac*a"));//true
        System.out.println(match("aaa", "aa.a"));//false
        System.out.println(match("aaa", "ab*a"));//false
    }
}
