import java.util.*;

public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, i = 0;
        List<String> ret = new ArrayList<>();

        while(i<n){
            int len = 0;//length of current line
            int netLen = 0;//length of all words
            int cnt = 0;//number of words
            int j = i;//index of next word
            while(j<n && (len + words[j].length() + (cnt==0?0:1))<=maxWidth){
                len += words[j].length() + (cnt==0?0:1);
                netLen += words[j].length();
                j++;
                cnt++;
            }

            StringBuilder sb = new StringBuilder();
            //last line or only one word
            if(cnt==1 || j==n){
                for(int k=i; k<j; k++){
                    if(sb.length()>0)
                        sb.append(" ");
                    sb.append(words[k]);
                }
                while(sb.length()<maxWidth){
                    sb.append(" ");
                }
            }else{
                int space = (maxWidth - netLen) / (cnt-1);
                int cntWordsWithLongerSpace = (maxWidth - netLen) % (cnt-1);
                for(int k=i; k<j; ++k){
                    if(sb.length()>0){
                        sb.append(new String(new char[space]).replace('\0', ' '));
                        if(k-i <= cntWordsWithLongerSpace){
                            sb.append(" ");
                        }
                    }
                    sb.append(words[k]);
                }
            }
            ret.add(sb.toString());
            i = j;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        TextJustification_68 sol = new TextJustification_68();
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        sol.fullJustify(words, 20);
    }
}