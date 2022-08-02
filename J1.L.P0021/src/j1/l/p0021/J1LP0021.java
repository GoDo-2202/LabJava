/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import Entity.Student;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class J1LP0021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        CheckValidate checkValidate = new CheckValidate();
        ArrayList<Student> listStudent = new ArrayList<>();
        //Step 1: Create menu 
        menu();
        //Step 2: Choose option
        //The loop runs until user wants exit program
        while (true) {
            int option = checkValidate.inputIntegerNumber();
            switch (option) {
                case 1:
                    //Step 3: Create product
                    studentManager.createStudent(listStudent);
                    break;
                case 2:
                    //Step 4: Create View order
                    studentManager.findAndSortStudent(listStudent);
                    break;
                case 3:
                    //Step 5: Create shopping
                    studentManager.updateOrDeleteStudent(listStudent);
                    break;
                case 4:
                    //Step 6: Report student
                    studentManager.reportStudent(listStudent);
                    break;
                case 5:
                    //Step 7: Exit programing
                    System.out.println("Thanks for using my program!!!");
                    return;
                default:
                    System.out.println("(Please choose 1 to Create, 2 to Find and Sort, "
                + "3 to Update/Delete, 4 to Report and 5 to Exit program).");
                    break;
            }
            menu();
        }
    }

    private static void menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, "
                + "3 to Update/Delete, 4 to Report and 5 to Exit program).");
        System.out.println("Please choose option:");
    }

}
