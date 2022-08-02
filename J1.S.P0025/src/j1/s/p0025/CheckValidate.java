/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0025;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
class CheckValidate {

    StringBuffer stringBuffer;
    String regex;

    String formatText(String text) {
        //Only one space between words. There are no blank line between lines
        
        text = oneSpaceBetweenWords(text);
        /*
        Only one space after comma (,), dot (.) and colon (:).
        First character of word after dot is in Uppercase and other words are 
        in lower case.
         */
        text = fomartBeforeDotCommaColon(text);
        /*
        There are no spaces before and after sentence or 
        word phrases in quotes (“”). 
         */
        text = fomartQuotes(text);
        /*
        First character of word in first line is in Uppercase
         */
        text = uppercaseFirstCharacterInfirstLine(text);
        /*
        There are no space between comma or dot and word in front of it
         */
        text = fomartAfterCommanDot(text);
        /*
        Must have dot at the end of text. 
         */
        text = fomartBeforeDotBank(text);
        text = addDotAtEndText(text);
        return text;
    }

    /*
    Group 1: is word
    Group 2: is spaces
    replace group 2 to one space
     */
    String oneSpaceBetweenWords(String text) {
        regex = "([A-zA-z0-9]+)([\\s]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1 ");
        }
        matcher.appendTail(stringBuffer);
        return text = stringBuffer.toString();
    }

    /*
    Group 1: is dot or comma or colon
    Group 2: is chracter before dot or comma or colon
    if dot character uplowcase.
     */
    String fomartBeforeDotCommaColon(String text) {
        regex = "([\\.,:])[^\\s^\\n]*([\\S])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1 " + (".".equals(matcher.group(1))
                    ? matcher.group(2).toUpperCase() : matcher.group(2)));
        }
        matcher.appendTail(stringBuffer);
        return text = stringBuffer.toString();
    }
    
    String fomartBeforeDotBank(String text) {
        regex = "([\\.])[\\s]*[\\n]+[\\s]*([\\S])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1\n$2");
            System.out.println(matcher.group(2));
        }
        matcher.appendTail(stringBuffer);
        return text = stringBuffer.toString();
    }

    /*
    Group 1: first quotes
    Group 2: words in quotes
    Group 3: end quotes
    trim string in group 2
     */
    String fomartQuotes(String text) {
        regex = "([“])([\\S ]*)([”])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1" + matcher.group(2).trim() + "$3");
        }
        matcher.appendTail(stringBuffer);
        return text = stringBuffer.toString();
    }

    /*
    Use sub string to split first character
     */
    String uppercaseFirstCharacterInfirstLine(String text) {
        text = text.trim();
        return text = text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    
    /*
    Group 1: is words no space
    Group 2: is dot or comma
    There are no space between comma or dot and word in front of it
    */
    String fomartAfterCommanDot(String text) {
        regex = "([\\S]+)[\\s]+([\\.,])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1$2");
        }
        matcher.appendTail(stringBuffer);
        return text = stringBuffer.toString();
    }
    
    String addDotAtEndText(String text) {
        if (Character.compare(text.charAt(text.length() - 1), '.') != 0) {
            text += ".";
        }
        return text;
    }

    public static void main(String[] args) {
        CheckValidate checkValidate = new CheckValidate();
        String text = "    dinh    dep    , trai     2202    *1234   ."
                + "dinh dep trai   ,   :3232323.   “    second    row       ”    dinh adada     ."
                + "dinh qweqweqweqweqweqweq.\n qweqweqweqweqweqweqweqweqweqwe ";
        text = checkValidate.oneSpaceBetweenWords(text);
        text = checkValidate.fomartBeforeDotCommaColon(text);
        text = checkValidate.fomartQuotes(text);
        text = checkValidate.uppercaseFirstCharacterInfirstLine(text);
        text = checkValidate.fomartAfterCommanDot(text);
        text = checkValidate.addDotAtEndText(text);
//        text = checkValidate.fomartBeforeDotBank(text);
        System.out.println(text);
    }
}
