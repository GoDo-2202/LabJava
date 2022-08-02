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
class ManageCandidates {

    CheckValidate checkValidate = new CheckValidate();
    ArrayList<Candidates> listCandidateses = new ArrayList<>();

    void add() {
        listCandidateses.add(new Experience(5,
                "Java",
                1,
                "Nguyen",
                "Dinh",
                2000,
                "Ha tinh",
                123456789,
                "dinhgodo@gmail.com",
                0));
        listCandidateses.add(new Experience(5,
                "Java",
                2,
                "Nguyen",
                "Van A",
                2000,
                "Ha tinh",
                1234567890,
                "godobento2202@gmail.com",
                0));
        listCandidateses.add(new Experience(5,
                "Java",
                1,
                "Nguyen",
                "Dinh",
                2000,
                "Ha tinh",
                123456789,
                "dinhgodo@gmail.com",
                0));
        listCandidateses.add(new Experience(5,
                "Java",
                3,
                "Nguyen",
                "Van B",
                2000,
                "Ha tinh",
                1234567891,
                "godobento2202@gmail.com",
                0));

        listCandidateses.add(new Experience(5,
                "Java",
                1,
                "Nguyen",
                "Dinh",
                2000,
                "Ha tinh",
                123456789,
                "dinhgodo@gmail.com",
                1));
        listCandidateses.add(new Experience(5,
                "Java",
                2,
                "Nguyen",
                "Van A",
                2000,
                "Ha tinh",
                1234567890,
                "godobento2202@gmail.com",
                1));
        listCandidateses.add(new Experience(5,
                "Java",
                1,
                "Nguyen",
                "Dinh",
                2000,
                "Ha tinh",
                123456789,
                "dinhgodo@gmail.com",
                1));
        listCandidateses.add(new Experience(5,
                "Java",
                3,
                "Nguyen",
                "Van B",
                2000,
                "Ha tinh",
                1234567891,
                "godobento2202@gmail.com",
                1));

        listCandidateses.add(new Experience(5,
                "Java",
                1,
                "Nguyen",
                "Dinh",
                2000,
                "Ha tinh",
                123456789,
                "dinhgodo@gmail.com",
                2));
        listCandidateses.add(new Experience(5,
                "Java",
                2,
                "Nguyen",
                "Van A",
                2000,
                "Ha tinh",
                1234567890,
                "godobento2202@gmail.com",
                2));
        listCandidateses.add(new Experience(5,
                "Java",
                1,
                "Nguyen",
                "Dinh",
                2000,
                "Ha tinh",
                123456789,
                "dinhgodo@gmail.com",
                2));
        listCandidateses.add(new Experience(5,
                "Java",
                3,
                "Nguyen",
                "Van B",
                2000,
                "Ha tinh",
                1234567891,
                "godobento2202@gmail.com",
                2));
    }

    void createExperienceCandidate() {
        int type = 0;
        while (true) {
            Experience experience = new Experience();
            getCandidateBasicInfo((Candidates) experience, type);
            if (experience.getFirstName() == null) {
                return;
            }
            // get private info
            System.out.println("Input year of experience: ");
            int yearExperience = checkValidate.inputYearExperience();
            experience.setExpInYear(yearExperience);
            System.out.println("Input Pro Skill: ");
            String proSkill = checkValidate.inputString();
            experience.setProSkill(proSkill);
            addCandidate(experience);
            if (!checkValidate.inputYesNo()) {
                return;
            }
        }
    }

    void createFresherCandidate() {
        int type = 1;
        while (true) {
            Fresher fresher = new Fresher();
            getCandidateBasicInfo((Candidates) fresher, type);
            if (fresher.getFirstName() == null) {
                return;
            }
            // get private info
            System.out.println("Input graduation date: ");
            int graduationDate = checkValidate.inputBirthDate();
            fresher.setGraduationDate(graduationDate);
            System.out.println("Input graduation rank: ");
            String graduationRank = checkValidate.inputgraduationRank();
            fresher.setGraduationRank(graduationRank);
            System.out.println("Input graduation rank: ");
            String education = checkValidate.inputString();
            fresher.setGraduationRank(education);
            addCandidate(fresher);
            if (!checkValidate.inputYesNo()) {
                return;
            }
        }
    }

    void createInternshipCandidate() {
        int type = 2;
        while (true) {
            Intern intern = new Intern();
            getCandidateBasicInfo((Candidates) intern, type);
            if (intern.getFirstName() == null) {
                return;
            }
            // get private info
            System.out.println("Input majors: ");
            String major = checkValidate.inputString();
            intern.setMajors(major);
            System.out.println("Input semester: ");
            int semester = checkValidate.inputIntegerNumber();
            intern.setSemester(semester);
            System.out.println("Input university name: ");
            String universityName = checkValidate.inputString();
            intern.setUniversityName(universityName);
            addCandidate(intern);
            if (!checkValidate.inputYesNo()) {
                return;
            }
        }
    }

    private void getCandidateBasicInfo(Candidates candidates, int type) {
        // get basic info of candidate
        System.out.println("Input id: ");
        int id = checkValidate.inputIntegerNumber();
        if (!checkValidate.checkIdExit(listCandidateses, id)) {
            System.out.println("Id is exit.");
            return;
        }
        candidates.setCandidateId(id);
        System.out.println("Input first name: ");
        String firstName = checkValidate.inputString();
        candidates.setFirstName(firstName);
        System.out.println("Input last name: ");
        String lastName = checkValidate.inputString();
        candidates.setLastName(lastName);
        System.out.println("Input birth date: ");
        int birthdate = checkValidate.inputBirthDate();
        candidates.setBirthDate(birthdate);
        System.out.println("Input address: ");
        String address = checkValidate.inputString();
        candidates.setAddress(address);
        System.out.println("Input phone: ");
        int phone = checkValidate.inputPhone();
        candidates.setPhone(phone);
        System.out.println("Input email: ");
        String email = checkValidate.inputEmail();
        candidates.setEmail(email);
        candidates.setCandidateType(type);
    }

    void addCandidate(Candidates candidate) {
        listCandidateses.add(candidate);
    }

    void showListExperience() {
        System.out.println("------------Experience----------------------");
        for (Candidates listCandidatese : listCandidateses) {
            if (listCandidatese instanceof Experience) {
                System.out.println(((Experience) listCandidatese).getFirstName() + " "
                        + ((Experience) listCandidatese).getLastName());
            }
        }
    }

    void showList(ArrayList<Candidates> list) {
        for (Candidates candidates : list) {
            System.out.println(candidates.toString());
        }
    }

    public static void main(String[] args) {
        ManageCandidates manageCandidates = new ManageCandidates();
        manageCandidates.createExperienceCandidate();
        manageCandidates.showListExperience();
        manageCandidates.search();
    }

    void search() {
        System.out.println("Input first name: ");
        String name = checkValidate.inputString();
        System.out.println("Input type: ");
        int type = checkValidate.inputIntegerNumber();
        searchCandidate(name, type);
    }

    private void searchCandidate(String name, int type) {
        ArrayList<Candidates> list = new ArrayList<>();
        for (Candidates listCandidatese : listCandidateses) {
            if (listCandidatese.getCandidateType() == type) {
                if (listCandidatese.getFirstName().toLowerCase().contains(name)
                        || listCandidatese.getLastName().toLowerCase().contains(name)) {
                    list.add(listCandidatese);
                }
            }
        }
        if (list.isEmpty()) {
            System.out.println("No find candidater");
        } else {
            showList(list);
        }
    }
}
