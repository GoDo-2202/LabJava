/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import Entity.Student;
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
                if (size > 0) {
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

    boolean checkIdExit(ArrayList<Student> listStudent, int studentId, String name) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (studentId == listStudent.get(i).getId() && !name.equalsIgnoreCase(listStudent.get(i).getName())) {
                return false;
            }
        }
        return true;
    }

    String inputCourse() {
        String name;
        //the loop runs until user input correctly
        while (true) {
            try {
                name = scanner.nextLine().trim();
                if (notNumber(name)) {
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
    public boolean notNumber(String name) {
        String regex = "[\\D]+";
        return !("".equals(name)) && Pattern.matches(regex, name);
    }

    boolean inputUpdateDelete() {
        System.out.println("Do you want update or delete (U/D)?");
        while (true) {
            String result = inputString();
            //check value user input equals y/Y
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //check value user input equals n/N
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    boolean checkStudentExit(ArrayList<Student> listStudent, int id, int semester, String course) {
        for (Student student : listStudent) {
            if (student.getId() == id && student.getSemester() == semester && student.getCourseName().equalsIgnoreCase(course)) {
                return false;
            }
        }
        return true;
    }

    int chooseQuantity(int i, int quantity) {
        int result;
        //the loop runs until user input correctly
        while (true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result > 0 && result <= quantity) {
                    return result;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!! Pls input integer number and 0 < input <= quantity.");
                System.out.println("Input again:");
            }
        }
    }
}
