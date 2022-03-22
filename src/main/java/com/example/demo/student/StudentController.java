package com.example.demo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "student1"),
            new Student(2, "student2"),
            new Student(3, "student3")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist."));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        System.out.println("addStudent");
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable Integer studentId) {
        System.out.println("deleteStudent");
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");

    }
}
