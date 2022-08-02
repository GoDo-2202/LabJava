/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import Entity.Candidates;
import Entity.Experience;
import Entity.Fresher;
import Entity.Intern;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class J1LP0022 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        candidates();
    }

    private static void candidates() {
        CheckValidate checkValidate = new CheckValidate();
        ManageCandidates manageCandidates = new ManageCandidates();
        //Step 1: Create menu 
        menu();
        manageCandidates.add();
        //Step 2: Choose option
        //The loop runs until user wants exit program
        while (true) {
            int option = checkValidate.inputIntegerNumber();
            switch (option) {
                case 1:
                    //Step 3: Experience
                    manageCandidates.createExperienceCandidate();
                    break;
                case 2:
                    //Step 4: Fresher
                    manageCandidates.createFresherCandidate();
                    break;
                case 3:
                    //Step 5: Internship
                    manageCandidates.createInternshipCandidate();
                    break;
                case 4:
                    //Step 6: Search
                    manageCandidates.search();
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
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.println("(Please choose 1 to Create Experience Candidate, "
                + "2 to Create Fresher Candidate, 3 to Internship Candidate, "
                + "4 to Searching and 5 to Exit program).");
        System.out.println("Please choose option:");
    }
}
