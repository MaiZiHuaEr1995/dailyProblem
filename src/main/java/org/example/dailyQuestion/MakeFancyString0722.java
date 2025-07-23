package org.example.dailyQuestion;

import java.util.Objects;

public class MakeFancyString0722 {

    public static void main(String[] args) {
        String res = makeFancyString("aab");
        System.out.println(res);
    }

    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (i == 0 || i == 1){
                sb.append(c);
            } else {
                char last = s.charAt(i - 1);
                if (Objects.equals(last, s.charAt(i - 2)) && Objects.equals(last, s.charAt(i))) {
                    continue;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}


