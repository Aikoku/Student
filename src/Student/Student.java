/**
 *
 * @author Mark Nikolajev
 */
package Student;

import java.util.ArrayList;

public class Student {

    private int mark1, mark2;
    public String name;
    public boolean pass;
    final static int MIN_MARK = 1, MAX_MARK = 5;
    final static double PASS_MARK = 3.0;

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        //if(checkPass(this.getMark1(), this.getMark2())){
        if (checkPass(mark1, mark2)) {
            pass = true;
            this.pass = pass;
            System.out.println("Стдент переведен на след. курс");
        } else {
            System.out.println("Студент не переведен на след. курс");
        }

    }

    public static boolean checkPass(int mark1, int mark2) {
        return averageMark(mark1, mark2) > PASS_MARK;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        if (checkMark(mark1)) {
            this.mark1 = mark1;
        } else {
            System.out.println("Оценки должны быть в диапозоне от 1 до 5");
        }
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        if (checkMark(mark2)) {
            this.mark2 = mark2;
        } else {
            System.out.println("Оценки должны быть в диапозоне от 1 до 5");
        }
    }

    public Student(String name, int mark1, int mark2, boolean pass) {
        this.setMark1(mark1);
        this.setMark2(mark2);
        this.name = name;
        this.setPass(pass);
    }

    public Student(String name, int mark1, int mark2) {
        this.setMark1(mark1);
        this.setMark2(mark2);
        this.name = name;
        this.setPass(pass);
    }

    public static boolean checkMark(int mark) {
        return (MIN_MARK <= mark) && (mark <= MAX_MARK);
    }

    public static double averageMark(int mark1, int mark2) {
        return ((double) (mark1 + mark2) / 2);
    }

    public static double averageMark(Student student) {
        return ((double) (student.mark1 + student.mark2) / 2);
    }

    public static void bestStudent(Student student1, Student student2) {

        if (averageMark(student1) > averageMark(student2)) {
            System.out.println("Лучшим студентом оказался: " + student1.name);
        } else {
            System.out.println("Лучшим студентом оказался: " + student2.name);
        }
    }

    public static void passStudent(Student student) {
        if (student.pass == true) {
            System.out.println("Студент " + student.name + " переведен на след. курс");
        } else {
            System.out.println("Студент " + student.name + " не переведен на след. курс");
        }
    }

    @Override
    public String toString() {
        return "Студент: " + name + " Оценки[за первый предмет = " + mark1 + ", за второй предмет = "
                + mark2 + "] На следующий курс переведен = " + pass;
    }
//////////////////////////////////////////////

    public static void main(String[] args) {
        Student std1 = new Student("Lopesman", 4, 5);
        Student std2 = new Student("Kurotchkiman", 3, 5);
        
        System.out.println("std1 = " + std1);
        System.out.println("ave = " + averageMark(std2));
        bestStudent(std1, std2);
        passStudent(std2);
        Student std3 = new Student("Ortisman", 1, 4);
        Student std4 = new Student("Nikolajman", 4, 5);
        Student std5 = new Student("Mishinman", 4, 4);
        Student std6 = new Student("Gelsten", 1, 2);
        
        ArrayList group = new ArrayList();
        group.add(std1);
        group.add(std2);
        Group.addStudentToGroup(group, std3);
        Group.removeStudentFromGroup(group, std2);
        //Group.showGroup(group);
        Group.addStudentToGroup(group, std2);
        Group.addStudentToGroup(group, std4);
        Group.addStudentToGroup(group, std5);
        Group.addStudentToGroup(group, std6);
        Group.showGroup(group);
        
        System.out.println("===========");
        
        Student std ;
        String name = group.get(1).toString();
        //Student std7 = group.get(1);
        
//        String name = 
//        System.out.println("name = "+name);
        
    }

}

class Group {
    public String groupName;
    public ArrayList group;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList getGroup() {
        return group;
    }

    public void setGroup(ArrayList group) {
        this.group = group;
    }
    

//    public static void showGroup(Student[] group) {
//        for (int i = 0; i < group.length; i++) {
//            System.out.println(group[i]);
//        }
//    }
    public static void showGroup(ArrayList group){
        for (Object group1 : group) {
            System.out.println(group1);
        }
    }

    public static void addStudentToGroup(ArrayList group, Student student) {
        group.add(student);
    }
    
    public static void removeStudentFromGroup(ArrayList group, Student student){
        group.remove(student);
    }
    
    public static void searchByStudentName(ArrayList group, Student student){
        Student std ;
        String name = group.get(1).toString();
        System.out.println("name = "+name);
        for(int i = 0;i<group.size();i++){
//            std = group.toArray(x);
//            if(){
//                
//            }
        }
    }
    
    public static void searchSecName(){
        
    }
    
    public static void main(String[] args) {
        
    }
}
