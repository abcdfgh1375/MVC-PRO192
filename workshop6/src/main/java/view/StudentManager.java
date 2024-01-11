
package view;
import controller.StudentList;
public class StudentManager {
    public static void main(String[] args) {
        //options in menu
        String[] options = {"Add new student","Search a student","Update name and mark",
        "Remove a student","List all","Quit"};
        int choice = 0; //user choice
        StudentList list = new StudentList();// init empty list
        do{
            System.out.println("\nStudent managing Program");
            choice = Menu.getChoice(options);
            switch(choice){
                case 1:{ 
                    if(list.isEmpty()){
                        list.loadData();
                        list.addStudent();}//add into list
                    else{
                        list.addStudent();}
                    list.saveData(); //save into student.txt file
                    break;} //add new student
                case 2:{ 
                    list.searchStudent(); break;} //search student
                case 3:{
                    list.updateStudent();
                    list.saveData(); break;} //update student
                case 4:{ 
                    list.removeStudent();
                    list.saveData(); break;} //remove student
                case 5:{ 
                    list.printAll(); break;} //print all students
                default:{
                    System.out.println("Bye!");}
            }
        }while(choice > 0 && choice < 6);
    }//StudentManager class
}
