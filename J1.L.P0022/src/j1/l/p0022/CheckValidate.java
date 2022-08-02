/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import Entity.Candidates;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
class CheckValidate {

    Scanner scanner = new Scanner(System.in);

    int inputIntegerNumber() {
        int size;
        //the loop runs until user input correctly
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size >= 0) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    String inputString() {
        String name;
        //the loop runs until user input correctly
        while (true) {
            try {
                name = scanner.nextLine().trim();
                if (isName(name)) {
                    name = replaceSpace(name);
                    return name;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input please input the alphabet.");
                System.out.println("Input again:");
            }
        }
    }

    /*
    Character range in alphabet and spaces occur once or more times
     */
    public boolean isName(String name) {
        String regex = "[a-zA-Z ]+";
        return !("".equals(name)) && Pattern.matches(regex, name);
    }

    /*
    The space has occurs once or more times
    replace all space to one space
     */
    public String replaceSpace(String name) {
        String regex = "\\s+";
        name = name.replaceAll(regex, " ").trim();
        return name;
    }

    boolean checkIdExit(ArrayList<Candidates> listCandidateses, int candidateId) {
        for (int i = 0; i < listCandidateses.size(); i++) {
            if (candidateId == listCandidateses.get(i).getCandidateId()) {
                return false;
            }
        }
        return true;
    }

    int inputBirthDate() {
        int size;
        //the loop runs until user input correctly
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size > 1900 && size <= 2022) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    int inputPhone() {
        int size;
        //the loop runs until user input correctly
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (isPhone(String.valueOf(size))) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    public boolean isPhone(String phone) {
        String regex = "[0-9]{10}";
        return !("".equals(phone)) && Pattern.matches(regex, phone);
    }

    String inputEmail() {
        String name;
        //the loop runs until user input correctly
        while (true) {
            try {
                name = scanner.nextLine().trim();
                if (isEmail(name) && name.contains(".com") || name.contains(".edu.vn")) {
                    return name;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! "
                        + "Pls input email have @ and .com like name@gmail.com, name@fpt.com, ...");
                System.out.println("Input again:");
            }
        }
    }

    /*
    String have character @
    after characters @ have character number 0-9 and character in alphabet
    before characters @ have character in alphabet and character .
     */
    public boolean isEmail(String email) {
        String regex = "[a-zA-z0-9]+@[a-zA-z]+[a-zA-z\\.]+";
        return !("".equals(email)) && Pattern.matches(regex, email);
    }

    public static void main(String[] args) {
        CheckValidate checkValidate = new CheckValidate();
        String email;
        email = checkValidate.inputEmail();
    }

    int inputYearExperience() {
        int size;
        //the loop runs until user input correctly
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size > 0 && size <= 100) {
                    return size;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number greater than 0.");
                System.out.println("Input again:");
            }
        }
    }

    boolean inputYesNo() {
        System.out.println("Do you want conterniu (Y/N)?");
        while (true) {
            String result = inputString();
            //check value user input equals y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //check value user input equals n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    String inputgraduationRank() {
        String name;
        //the loop runs until user input correctly
        while (true) {
            try {
                name = scanner.nextLine().trim();
                if (name.equalsIgnoreCase("Excellence") 
                        || name.equalsIgnoreCase("Good")
                        || name.equalsIgnoreCase("Fair")
                        || name.equalsIgnoreCase("Poor")) {
                    name = replaceSpace(name);
                    return name;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!!"
                        + " Rank of Graduation: with one of 4 values (Excellence, Good, Fair, Poor).");
                System.out.println("Input again:");
            }
        }
    }
}
