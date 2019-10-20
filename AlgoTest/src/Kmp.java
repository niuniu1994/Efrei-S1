
//如果忘了 就去看 收藏夹里印度小哥的视频
public class Kmp {

    //找到patten中每个字符对应的最长的前缀后缀长度
    private int[] getNext(String words){
        int next[] = new int[words.length()];
        int i = 1;
        int j = 0;
        next[0] = 0;
        while (i < words.length()){
            //此种情况下，即没有前缀
            if (j == 0 && words.charAt(j) != words.charAt(i)){
                next[i] = 0;
                i++;
             //此种情况下，字母相同
            }else if(words.charAt(j) == words.charAt(i)){
                next[i] = ++j;
                i++;
            }else {
                //此种情况下，找到第二大的前缀
                j = next[j - 1];
            }
        }
        return next;
    }

    public Boolean EKmp(String words, String patten){
        int i = 0;
        int j = 0;

        int[] next = getNext(patten);

        while (i < words.length() && j < patten.length()){
            if (words.charAt(i) == patten.charAt(j)){
                i++;
                j++;
            }else if (j != 0 && words.charAt(i) != patten.charAt(j)){
                j = next[j - 1];
            }else if(j == 0 && words.charAt(i) != patten.charAt(j)){
                i++;
            }
        }

        if( j == patten.length()){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String w = "aabaabaaa";
        Kmp kmp = new Kmp();
        System.out.println(kmp.EKmp("abcxabcdabxabcdabcdabcy","abcdabc"));
    }
}
