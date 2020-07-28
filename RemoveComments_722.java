import java.util.ArrayList;

import java.util.*;

public class RemoveComments_722 {
    public List<String> removeComments(String[] source) {
        List<String> code = new ArrayList<>();
        boolean isComments = false;
        for(String line : source){
            int i = 0;
            StringBuilder newLine = new StringBuilder();
            while(i<line.length()){
                int n = line.length();
                if(isComments){//in between /* */
                    if(i<n && line.charAt(i)=='*' && i+1<n && line.charAt(i+1)=='/'){
                        isComments = false;
                        i += 2;
                    }else{
                        i++;
                    }
                }else{
                    if(i<n && line.charAt(i)=='/' && i+1<n && line.charAt(i+1)=='*'){
                        i += 2;
                        isComments = true;
                    }else if(i<n && line.charAt(i)=='/' && i+1<n && line.charAt(i+1)=='/'){
                        break;
                    }else{
                        newLine.append(line.charAt(i++));
                    }
                }
            }
            if(!isComments && newLine.length()>0){
                code.add(newLine.toString());
                newLine = new StringBuilder();
            }
        }
        return code;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        RemoveComments_722 sol = new RemoveComments_722();
   //     String[] source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        String[] source = new String[]{"a/*comment", "line", "more_comment*/b"};
        sol.removeComments(source);
    }
}