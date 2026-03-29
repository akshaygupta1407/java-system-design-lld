package encapsulation;

import java.util.ArrayList;

/**
 * PRACTICE QUESTION: Encapsulation
 * 
 * Objective: Design a `Student` class.
 * 
 * Requirements:
 * 1. The class should have the following PRIVATE fields:
 *    - name (String)
 *    - age (int)
 *    - grades (an array of integers)
 * 2. Provide a constructor to initialize the name and age. (Ensure age is valid, e.g., > 0)
 * 3. Provide public methods:
 *    - getName() and getAge()
 *    - addGrade(int grade): Validates that the grade is between 0 and 100 before adding it. 
 *      For simplicity, you can enforce a maximum of 5 grades by keeping an index counter.
 *    - getAverageGrade(): Returns a double representing their average grade.
 * 
 * Complete the implementation below and run it!
 */
public class EncapsulationPractice {
    // 1. Declare private fields here
    // private String name; ...

    private String name;
    private int age; 
    private ArrayList<Integer> grades;


    public EncapsulationPractice(String name, int age) {
        // 2. Initialize fields, add validation
        if(age <= 0) {
            throw new IllegalArgumentException("Age cannot be less than or equal to 0");
        }
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>();
    }



    // 3. Implement getter methods
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    // 4. Implement addGrade(int grade)
    public void addGrade(int grade) {
        if(grade < 0 || grade > 100) {
            System.out.println("Invalid grade");
            return;
        }
        this.grades.add(grade);
    }

    // 5. Implement getAverageGrade()
    public float getAverageGrade() {
        if(this.grades.isEmpty()) {
            return (float)0;
        }
        int sum = 0;
        for(int i=0; i<grades.size(); i++) {
            sum+=grades.get(i);
        }
        return (float)sum/grades.size();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Student Encapsulation ---");
        
        // Test your implementation conceptually here:
        EncapsulationPractice student = new EncapsulationPractice("Alice", 20);
        student.addGrade(85);
        student.addGrade(105); // Should be rejected!
        student.addGrade(90);
        System.out.println("Average grade: " + student.getAverageGrade());

        /*
         * Output: 
         * Invalid grade
         * Average grade: 87.5
         */
    }
}
