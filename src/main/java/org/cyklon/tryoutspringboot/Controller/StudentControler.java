package org.cyklon.tryoutspringboot.Controller;

import org.cyklon.tryoutspringboot.Model.Student;
import org.cyklon.tryoutspringboot.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControler {
    private final StudentRepository repository;

    public StudentControler(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student getAll(@PathVariable("student-id")Integer id){
        return repository.findById(id).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name")String name){
        return repository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable ("student-id") Integer id){
        repository.deleteById(id);
    }

}
