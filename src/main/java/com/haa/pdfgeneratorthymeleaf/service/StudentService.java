package com.haa.pdfgeneratorthymeleaf.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.haa.pdfgeneratorthymeleaf.entity.Student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return IntStream.range(1, 10)
                .mapToObj(v -> new Student(v, "Name " + v, "Last Name " + v, LocalDate.now(),
                        "Nationality " + v,
                        "University " + v,
                        v % 2 == 0 ? true : false))
                .collect(Collectors.toList());
    }
}
