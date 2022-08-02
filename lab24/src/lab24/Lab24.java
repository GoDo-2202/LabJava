/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Lab24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        parseString();
    }

    private static void parseString() {
//        String s = "as you can see, detecting whether a string is normalized can be quite efficient. "
//                + "A lot of the cost of normalizing in the “second row” is for the initialization of buffers. "
//                + "The cost of which is amortized when one is processing larger strings.\n"
//                + " As it turns out, these buffers are rarely needed, so we may change the implementation at some point to speed up the common case for small strings even further";

        String s = "    dinh    dep    , trai     2202    *1234   .dinh dep trai   ,   :3232323.   “    second    row       ”    dinh adada";
//        s = "the “ second row ” is";
        System.out.println(s);

        //// 
        s = s.trim();
        System.out.println(s);
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        /////
        String regex1 = "([\\.,:])[\\s]*([\\S]{1})";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(s);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1 "
                    + (".".equals(matcher.group(1))
                    ? matcher.group(2).toUpperCase() : matcher.group(2)));
        }
        matcher.appendTail(stringBuffer);
        System.out.println(s);
        s = stringBuffer.toString().trim();
        ////// addd . vao cuoi
        if (Character.compare(s.charAt(s.length() - 1), '.') != 0) {
            s += ".";
        }
        //// 
        regex1 = "([\\S]+)([\\s]+)";
        pattern = Pattern.compile(regex1);
        matcher = pattern.matcher(s);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1 ");
        }
        matcher.appendTail(stringBuffer);

        s = stringBuffer.toString();
        ////
        regex1 = "([“])([\\S ]*)([”])";
        pattern = Pattern.compile(regex1);
        matcher = pattern.matcher(s);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1" + matcher.group(2).trim() + "$3");
        }
        matcher.appendTail(stringBuffer);

        s = stringBuffer.toString();
        ////
        regex1 = "([\\S]+)[\\s]+([\\.,])";
        pattern = Pattern.compile(regex1);
        matcher = pattern.matcher(s);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1$2");
        }
        matcher.appendTail(stringBuffer);

        System.out.println("\n");
        System.out.println(stringBuffer.toString());
    }

}
