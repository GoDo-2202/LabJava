/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import Entity.Student;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Admin
 */
class StudentManager {

    CheckValidate checkValidate = new CheckValidate();

    void createStudent(ArrayList<Student> listStudent) {
        while (true) {
            //The loop run until user dont want to create student
            if (listStudent.size() >= 3) {
                if (!checkValidate.inputYesNo()) {
                    return;
                }
            }
            System.out.println("Input student id: ");
            int id = checkValidate.inputIntegerNumber();
            System.out.println("Input student name: ");
            String name = checkValidate.inputString();
            if (!checkValidate.checkIdExit(listStudent, id, name)) {
                System.out.println("Id is exit student.");
                return;
            }
            System.out.println("Input semester: ");
            int semester = checkValidate.inputIntegerNumber();
            System.out.println("Input course: ");
            String course = checkValidate.inputCourse();
            if (!checkValidate.checkStudentExit(listStudent, id, semester, course)) {
                System.out.println("Studen is exit.");
                return;
            }
            listStudent.add(new Student(id, name, semester, course));
        }
    }

    void findAndSortStudent(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("Haven't student");
            return;
        }
        System.out.println("Input name student to sort: ");
        String name = checkValidate.inputString();
        ArrayList<Student> listSortByName = findStudentByName(listStudent, name);
        if (listSortByName.isEmpty()) {
            System.out.println("No student in list");
            return;
        }
        Collections.sort(listSortByName, new SortByName());
        showListSortStudentByName(listSortByName);
    }

    void updateOrDeleteStudent(ArrayList<Student> listStudent) {
        System.out.println("Input user id: ");
        int id = checkValidate.inputIntegerNumber();
        ArrayList<Student> listStudentFindById = getListStudentById(listStudent, id);
        if (listStudentFindById.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Student student = getStudentFound(listStudentFindById);
        if (checkValidate.inputUpdateDelete()) {
            System.out.println("Input student name: ");
            String name = checkValidate.inputString();
            System.out.println("Input semester: ");
            int semester = checkValidate.inputIntegerNumber();
            System.out.println("Input course: ");
            String course = checkValidate.inputCourse();
            if (!checkValidate.checkStudentExit(listStudent, id, semester, course)) {
                System.out.println("Studen is exit.");
                return;
            }
            student.setName(name);
            student.setSemester(semester);
            student.setCourseName(course);
            System.out.println("Update sucess.");
        }
        else {
            listStudent.remove(student);
            System.out.println("Delete sucess");
            return;
        }
    }

    void reportStudent(ArrayList<Student> listStudent) {
        HashMap<String, Integer> listReport = new HashMap<>();
        String key;
        for (Student student : listStudent) {
            key = student.getName() + " | " + student.getCourseName();
            listReport.put(key, listReport.getOrDefault(key, 0) + 1);
        }

        showListReport(listReport);
    }

    private ArrayList<Student> findStudentByName(ArrayList<Student> listStudent, String name) {
        ArrayList<Student> listSort = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                listSort.add(student);
            }
        }
        return listSort;
    }

    private void showListSortStudentByName(ArrayList<Student> listStudent) {
        System.out.format("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
        //loop from first to last element of list student
        for (Student student : listStudent) {
            System.out.format("%-15s%-15s%-15s\n", student.getName(), student.getSemester(), student.getCourseName());
        }
    }

    private Student getStudentById(ArrayList<Student> listStudent, int id) {
        for (Student student : listStudent) {
            if (id == student.getId()) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        ArrayList<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student(1, "Nguyen Van B", 1, "Java"));
        listStudents.add(new Student(1, "Nguyen Van B", 1, ".Net"));
        listStudents.add(new Student(2, "Nguyen Van C", 1, "Java"));
        listStudents.add(new Student(3, "Nguyen Van A", 1, "Java"));
        listStudents.add(new Student(3, "Nguyen Van A", 1, "Java"));
//        listStudents.add(new Student(6, "Dinh", 8, "Swift"));
//        listStudents.add(new Student(7, "Dinh", 8, "React"));
//        listStudents.add(new Student(8, "Dinh", 8, "Android"));
//        listStudents.add(new Student(9, "Van Khanh", 1, ".Net"));
//        listStudents.add(new Student(10, "Van Khanh", 1, ".Net"));
//        listStudents.add(new Student(11, "Van Khanh", 1, "Android"));
//        listStudents.add(new Student(12, "dien", 1, "Java"));
//        listStudents.add(new Student(13, "dat", 1, "Java"));
//        listStudents.add(new Student(14, "dung", 1, "Java"));
//        listStudents.add(new Student(15, "duy", 1, "Java"));
        studentManager.updateOrDeleteStudent(listStudents);
//        studentManager.showListSortStudentByName(listStudents);
//        studentManager.findAndSortStudent(listStudents);
//        studentManager.updateOrDeleteStudent(listStudents);
//        studentManager.showListSortStudentByName(listStudents);
//        studentManager.reportStudent(listStudents);
    }

    private void showListReport(HashMap<String, Integer> listReport) {
        Set<String> keySet = listReport.keySet();
        for (String key : keySet) {
            System.out.println(key + " | " + listReport.get(key));
        }
    }

    private ArrayList<Student> getListStudentById(ArrayList<Student> listStudent, int id) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getId() == id) {
                list.add(student);
            }
        }
        return list;
    }

    private Student getStudentFound(ArrayList<Student> listStudentFindById) {
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindById) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.println("Enter student you want: ");
        int option = checkValidate.chooseQuantity(1, listStudentFindById.size()) -1;
        return listStudentFindById.get(option);
    }
}
