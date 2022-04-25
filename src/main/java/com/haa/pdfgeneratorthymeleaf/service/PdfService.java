package com.haa.pdfgeneratorthymeleaf.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Service
public class PdfService {
    private static final String PDF_RESOURCES = "/pdf-resources/";

    @Autowired
    private StudentService studentService;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public File generatePdf() throws IOException, DocumentException {
        Context context = getContext();
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }

    private Context getContext() {
        Context context = new Context();
        context.setVariable("students", studentService.getStudents());
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("pdf_students", context);
    }

    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("students", ".pdf");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
            renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
            renderer.layout();
            renderer.createPDF(outputStream);
        }
        file.deleteOnExit();
        return file;
    }

}
