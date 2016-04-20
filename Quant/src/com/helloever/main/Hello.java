package com.helloever.main;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Hello {
    public static void main(String[] args) throws Exception {
        String str = "\"jakcy\"";
        Pattern pattern = Pattern.compile("\"(.+?)\"");
        Matcher matcher = pattern.matcher(str);
 
        while (matcher.find()) {
            System.out.println("Value is: " + matcher.group(1));
        }
    }
}