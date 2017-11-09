package StudentManagment.controller;

import StudentManagment.model.Student;
import StudentManagment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // Get All Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    // Create a new Student
    @PostMapping(value = "/students")
    public String createStudent(@RequestParam String pName, @RequestParam String pSurname, @RequestParam Long pFreshman) {
        Student student = new Student();
        student.setFreshman(pFreshman);
        student.setName(pName);
        student.setSurname(pSurname);
        studentRepository.save(student);

        return "Student saved";
    }

    // Get a single Student
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(student);
        }
    }

    // Update freshman of Student
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateFreshmanStudent(@PathVariable(value = "id") Long studentId, @Valid @RequestBody Student studentDetails) {
        Student student = studentRepository.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            student.setName(studentDetails.getName());
            student.setSurname(studentDetails.getSurname());

            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        }
    }

    // Delete a Student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if(student == null) {
            return "Student not found";
        }

        studentRepository.delete(student);
        return "Student deleted";
    }
}
