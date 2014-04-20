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
    
    public static int getMark1(Student student){
        return student.getMark1();
    }    
    public static int getMark2(Student student){
        return student.getMark2();
    }

    public static String getSecName(Student student) {
        return student.name;
    }
    
    public static boolean getPass(Student student){
        return student.pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Student std2 = new Student("Kurotchkiman", 5, 5);

        System.out.println("std1 = " + std1);
        System.out.println("ave = " + averageMark(std2));
        bestStudent(std1, std2);
        passStudent(std2);
        Student std3 = new Student("Ortisman", 0, 4);
        Student std4 = new Student("Nikolajman", 4, 5);
        Student std5 = new Student("Mishinman", 1, 4);
        Student std6 = new Student("Gelsten", 1, 2);

        ArrayList<Student> group = new ArrayList();
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

        String secName = group.get(4).getName();
        System.out.println("" + secName);
        
        double x = Group.averageGroup(group);
        System.out.println("averageGroup = "+x);

        Group.searchByStudentName(group, "Mishinman");
        Group.bestStudent(group);
        Group.debtStudent(group);
        Group.bestAverageStudent(group);
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
    public static void showGroup(ArrayList group) {
        for (Object group1 : group) {
            System.out.println(group1);
        }
    }

    public static void addStudentToGroup(ArrayList group, Student student) {
        group.add(student);
    }

    public static void removeStudentFromGroup(ArrayList group, Student student) {
        group.remove(student);
    }

    public static String getName(Student student) {
        return Student.getSecName(student);
    }
    
    public static boolean isPass(Student student){
        return Student.getPass(student);
    }

    public static void searchByStudentName(ArrayList group, String searchName) {
        for (int i = 0; i < group.size(); i++) {
            String secName = getName((Student) group.get(i));
            if (secName.equalsIgnoreCase(searchName)) {
                System.out.println(group.get(i));
                break;
            }
        }
    }
    
    public static void whoIsPass(ArrayList group){
       // System.out.println("поиск всех студентов группе , переведенных на следующий курс");
        for (int i = 0; i < group.size(); i++) {
            boolean pass = isPass((Student) group.get(i));
            if(pass){
                System.out.println(group.get(i));
            }
        }
    }
    
    public static double aveStudent(Student student){
        return Student.averageMark(student);
    }
    
    public static double averageGroup (ArrayList group){
        //System.out.println("нахождение среднего балла группы");
        double average=0;
        int count = 1;
        for(int i =0; i<group.size();i++){
            double aveStd = aveStudent((Student) group.get(i));
            average+=aveStd;
            count++;
        }
        return average/count;
    }
    
    public static void bestStudent(ArrayList group){
        //System.out.println("выдача на экран фамилии самого успешного студента группы ");
        int count = 0;
        double best=0;
        for(int i =0; i<group.size();i++){
            double bestMax = aveStudent((Student) group.get(i));
            
            if(best<bestMax){
                best=bestMax;
                count=i;
            }
            
        }
        System.out.println(getName((Student) group.get(count)));
    }
    
    public static int getMark1(Student student){
        return Student.getMark1(student);
    }
    public static int getMark2(Student student){
        return Student.getMark2(student);
    }
    
    
    public static void debtStudent(ArrayList group){
        //System.out.println("вывод на экран студентов, у которых есть задолжность по одному предмету");
        for(int i =0; i<group.size();i++){
         if((getMark1((Student) group.get(i))==0)|(getMark1((Student) group.get(i))==0)){
             System.out.println(getName((Student) group.get(i)));
         }              
        }        
    }
    
    public static void bestAverageStudent(ArrayList group){
        //System.out.println("вывод на экран студентов группы, чей личный средний балл выше среднего балла группы ");
         for(int i =0; i<group.size();i++){
             if(averageGroup(group)<aveStudent((Student)group.get(i))){
                 System.out.println(getName((Student) group.get(i)));
             }
         }
        
    }
    
    


}
