package Presentation;

public class Student {
    //Since the problem is about presenting code, I assume, all students are Computing students.
    public static final String course = "Computing";
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
        name = "Unknown";
    }

    public static String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
