package Presentation;

import QueuePkg.Queue;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    private Queue<Student> queue;
    //private List<Student> students;
    private Student[] students;

    public Program(int numStudents) {
       // students = new ArrayList<>();
        students = new Student[numStudents];
        queue = new Queue<>();
    }

    public Queue<Student> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Student> queue) {
        this.queue = queue;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    private int getInt(String prompt){
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        int userInput = 0;

        try{
            userInput = input.nextInt();
            input.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a valid number\n");
            //System.out.println();
            return getInt(prompt);
        }
        return userInput;
    }

    public int getSafeSpot(){
        int numStudents = getInt("Enter number of students");
        int sequence = getInt("Enter sequence");
        int safeSpot;

        if(numStudents < 1) {
            System.out.println("Please enter a number greater than 0");
            numStudents = getInt("Enter number of students");
        }

        if(sequence > numStudents){
            System.out.println("Enter a sequence which is less than the number of students");
            sequence = getInt("Enter sequence");
        }

        else if(sequence <= 0) {
            System.out.println("Enter a sequence which is greater than 0.");
            sequence = getInt("Enter sequence");
        }

        while(numStudents != 1){
            for(int i = 0; i < numStudents - 1; i = i+sequence){
                if (students[i] == null) continue;

                else{
                    Student temp = students[i]; //keep student to be removed from the circle in a temporary variable.
                    queue.enqueue(temp);
                    students[i] = null;
                    numStudents--;
                }
            }
        }






        //TODO fix the return and complete the method.
        return 0;
    }

}
