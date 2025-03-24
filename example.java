package day5javaprograms;
import java.util.*;
class Student {// class student  using  properties id, name, and grade//
int id;
String name;
String grade;
public Student(int id, String name, String grade) {//   initialize to constructor//
     this.id = id;
     this.name = name;
     this.grade = grade;
 }

 // Getter and Setter methods using  each property//
 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getGrade() {
     return grade;
 }

 public void setGrade(String grade) {
     this.grade = grade;
 }

 // Override the String method  display to  student details//
 @Override
 public String toString() {
     return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
 }
}

//StudentManagementSystem class using HashMap, ArrayList, and TreeSet//
class StudentManagementSystem {
private Map<Integer, Student> studentMap = new HashMap<>();//  HashMap to implements students id//
 private Set<Student> studentSetByName = new TreeSet<>(Comparator.comparing(Student::getName));//  TreeSet sort to  students by name(sorted alphabetically)//
 private List<Student> studentListByGrade = new ArrayList<>();//  ArrayList to students  used for sorting grade//
// 1. Add a new student with details (id, name, grade)//
 public void addStudent(int id, String name, String grade) {
     Student student = new Student(id, name, grade);
     studentMap.put(id, student);
     studentSetByName.add(student);
     studentListByGrade.add(student);
     System.out.println("Student added successfully: " + student);
 }

 // 2. View all students the system//
 public void viewAllStudents() {
     if (studentMap.isEmpty()) {
         System.out.println("No students available.");
     } else {
         System.out.println("All Students:");
         for (Student student : studentMap.values()) {
             System.out.println(student);
         }
     }
 }

 // 3. Search for the student  ID or name//
 public void searchStudent(String query) {
     try {
         int id = Integer.parseInt(query);
         if (studentMap.containsKey(id)) {
             System.out.println("Student found by ID: " + studentMap.get(id));
         } else {
             System.out.println("Student with ID " + id + " not found.");
         }
     } catch (NumberFormatException e) {
         boolean found = false;
         for (Student student : studentMap.values()) {
             if (student.getName().equalsIgnoreCase(query)) {
                 System.out.println("Student found by Name: " + student);
                 found = true;
                 break;
             }
         }
         if (!found) {
             System.out.println("Student with Name " + query + " not found.");
         }
     }
 }

 // 4. Update student information (id, name, grade)//
 public void updateStudent(int id, String newName, String newGrade) {
     Student student = studentMap.get(id);
     if (student != null) {
         student.setName(newName);
         student.setGrade(newGrade);
         System.out.println("Student information updated: " + student);
     } else {
         System.out.println("Student with ID " + id + " not found.");
     }
 }

 // 5. Remove a student system//
 public void removeStudent(int id) {
     Student student = studentMap.remove(id);
     if (student != null) {
         studentSetByName.remove(student);
         studentListByGrade.remove(student);
         System.out.println("Student removed successfully: " + student);
     } else {
         System.out.println("Student with ID " + id + " not found.");
     }
 }

 // 6. Sorting students name (alphabetically) using TreeSet//
 public void sortStudentsByName() {
     System.out.println("Students sorted by Name:");
     for (Student student : studentSetByName) {
         System.out.println(student);
     }
 }

 // Sorting students grade  in  ( ascending order)//
 public void sortStudentsByGrade() {
    studentListByGrade.sort(Comparator.comparing(Student::getGrade));
     System.out.println("Students sorted by Grade:");
     for (Student student : studentListByGrade) {
         System.out.println(student);
     }
 }
}


public class Task {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     StudentManagementSystem system = new StudentManagementSystem();
     while (true) {
         System.out.println("\nStudent Management System");
         System.out.println("1. Add Student");
         System.out.println("2. View All Students");
         System.out.println("3. Search Student by ID or Name");
         System.out.println("4. Update Student");
         System.out.println("5. Remove Student");
         System.out.println("6. Sort Students by Name");
         System.out.println("7. Sort Students by Grade");
         System.out.println("8. Exit");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();
         scanner.nextLine(); 
 switch (choice) {
             case 1: // Add a new student//
                 System.out.print("Enter Student ID: ");
                 int id = scanner.nextInt();
                 scanner.nextLine(); 
                 System.out.print("Enter Student Name: ");
                 String name = scanner.nextLine();
                 System.out.print("Enter Student Grade: ");
                 String grade = scanner.nextLine();
                 system.addStudent(id, name, grade);
                 break;
             case 2: // View all students//
                 system.viewAllStudents();
                 break;
             case 3: // Search student  ID or Name//
                 System.out.print("Enter Student ID or Name to search: ");
                 String query = scanner.nextLine();
                 system.searchStudent(query);
                 break;
             case 4: // Update student information//
                 System.out.print("Enter Student ID to update: ");
                 int updateId = scanner.nextInt();
                 scanner.nextLine(); 
                 System.out.print("Enter new Name: ");
                 String newName = scanner.nextLine();
                 System.out.print("Enter new Grade: ");
                 String newGrade = scanner.nextLine();
                 system.updateStudent(updateId, newName, newGrade);
                 break;
             case 5: // Remove a student//
                 System.out.print("Enter Student ID to remove: ");
                 int removeId = scanner.nextInt();
                 system.removeStudent(removeId);
                 break;
             case 6: // Sort by Name//
                 system.sortStudentsByName();
                 break;
             case 7: // Sort by Grade//
                 system.sortStudentsByGrade();
                 break;
             case 8: // Exit//
                 System.out.println("Exiting...");
                 scanner.close();
                 return;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
}
