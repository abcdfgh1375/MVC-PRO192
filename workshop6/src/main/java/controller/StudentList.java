
package controller;
import Model.Inputter;
import Model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class StudentList extends ArrayList<Student> {
    public StudentList(){
        super();
    }
    static String filename = "C:\\Users\\THANH HUYEN\\Documents\\NetBeansProjects\\workshop6\\student.txt";
    public void loadData() {      
        try {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] linearr = line.split(", ");
            this.add(new Student (linearr[0], linearr[1], Integer.parseInt(linearr[2])));
        }
        br.close();
    } catch (FileNotFoundException ex) {
        System.out.println("File not found " + filename);
    } catch (IOException ex) {
        System.out.println("An error occurred while reading the file");
    }
    }
    
        public void saveData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Student s : this) {
                String line = s.getCode() + ", " + s.getName() + ", " + s.getMark() + "\n";
                bw.write(line);
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("file not found" + filename);;
        }
    }
    //search a studen based on student's code. Return the student found
    //this method supports preventing code duplications 
    public Student search(String code){
        code = code.trim().toUpperCase();
        for(int i = 0; i< this.size();i++){//linear search is used
            if(this.get(i).getCode().equals(code))
                return this.get(i);}//found
            return null; //not found
    }
    
     //checking whether a code is duplicated or not?
    private boolean isCodeDuplicated(String code){
        code = code.trim().toUpperCase();
        return search(code)!= null;
     }
     
    //add new student
    public void addStudent(){
    //input data and check the validity of data of new student
    String newCode, newName;
    int newMark;
    boolean codeDuplicated = false;
    do{//pattern: s000 or S000 => pattern: "[sS][\\d]{3}"
        newCode = Inputter.inputPattern("St. code S000: ", "[sS][\\d]{3}");
        newCode = newCode.trim().toUpperCase();
        codeDuplicated = isCodeDuplicated(newCode);//check code duplication
        if(codeDuplicated)
        System.out.println("Code is duplicated!");
    }while(codeDuplicated);
    newName = Inputter.inputNonBlankStr("Name of new student: ");
    newName = newName.toUpperCase();
    newMark = Inputter.inputInt("Mark: ",0 , 10); //0<=mark<=10
     
    //create new student
        Student st = new Student(newCode,newName,newMark);
    
    //add new student to the list
        this.add(st);
        System.out.println("Student " + newCode + " has been added.");
    }
    
    //search student based on inputed code
    public void searchStudent(){
        if(this.isEmpty())
            System.out.println("Empty list. No search can be performed!");
        else{
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student st = this.search(sCode);//search student based on code
            if(st == null)
                System.out.println("Student " + sCode + " doesn't existed!");
            else System.out.println("Found: " + st +" .");}
        }
    
    //update name and mark based on student's code 
    public void updateStudent(){
        if(this.isEmpty())
            System.out.println("Empty list. No update can be performed!");
        else{
            String uCode = Inputter.inputStr("Input code of updated student: ");
            Student st = this.search(uCode); //search student
            if(st == null)
                System.out.println("Student "+ uCode + " doesn't existed!");
            else{
                //update student's name
                String oldName = st.getName();
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = Inputter.inputNonBlankStr(msg);
                st.setName(newName);
                //Update student's mark
                int oldMark = st.getMark();
                msg = "Old mark: " + oldMark + ", new mark 0..10: ";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Student " + uCode + " has been updated.");
            }
        }
    }
    
    //Remove a student based on student's code
    public void removeStudent(){
        if(this.isEmpty())
            System.out.println("Empty list. No remove can be performed!");
        else{
            String rCode = Inputter.inputStr("Input code of removed student: ");
            Student st = this.search(rCode);//search student
            if(st == null)
                System.out.println("Student " + rCode + "doesn't existed1");
            else{
                this.remove(st);//remove this student
                System.out.println("Student " + rCode + " has been removed.");
            }
        }
    }
    
    //list all students
    public void printAll(){
        if(this.isEmpty()) System.out.println("Empty list!");
        else{
            System.out.println("Student list: ");
            for (Student st : this) {
                System.out.println(st);
                System.out.println("Total: " + this.size() + " student(s).");
            }      
        }
    }
    }//StudentList
    
