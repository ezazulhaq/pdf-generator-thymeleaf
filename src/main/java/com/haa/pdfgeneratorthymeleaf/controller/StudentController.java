package com.haa.pdfgeneratorthymeleaf.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import com.haa.pdfgeneratorthymeleaf.service.PdfService;
import com.haa.pdfgeneratorthymeleaf.service.StudentService;
import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/students")
    public ModelAndView studentsView(ModelAndView modelAndView) {
        modelAndView.addObject("students", studentService.getStudents());
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @GetMapping("/download-pdf")
    public void downloadPDFResource(HttpServletResponse response) {
        try {
            Path file = Paths.get(pdfService.generatePdf().getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
