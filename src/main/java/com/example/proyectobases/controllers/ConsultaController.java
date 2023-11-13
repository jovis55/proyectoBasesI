package com.example.proyectobases.controllers;

import com.example.proyectobases.interfaces.ConsultaRepo;
import com.example.proyectobases.interfaces.EstudianteEvaluacionRepositorio;
import com.example.proyectobases.interfaces.EstudianteRepositorio;
import com.example.proyectobases.interfaces.EvaluacionRepositorio;
import com.example.proyectobases.model.Estudiante;
import com.example.proyectobases.model.EstudianteEvaluacion;
import com.example.proyectobases.model.Evaluacion;
import com.example.proyectobases.model.Reporte;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ConsultaController {

    private final ConsultaRepo consultaRepo;
    private final EstudianteEvaluacionRepositorio estudianteEvaluacionRepositorio;
    private final EstudianteRepositorio estudianteRepositorio;
    private final EvaluacionRepositorio evaluacionRepositorio;


    @GetMapping("/generarPDF")
    public void generarPDF() {
        List<EstudianteEvaluacion> estudiantes = estudianteEvaluacionRepositorio.findAll();

        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("resultado_consulta.pdf"));
            document.open();

            for (EstudianteEvaluacion estudianteEvaluacion : estudiantes) {
                Paragraph paragraph = new Paragraph(estudianteEvaluacion.getEvaluacion().getNombre());
                document.add(paragraph);
            }


            /*
            for (Estudiante e: estudiantes){
                Paragraph paragraph = new Paragraph(e.getNombre());
                document.add(paragraph);
            }

             */

            document.close();
            writer.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/generarEvaluacionPDF")
    public void generarEvaluacionPDF() {
        List<Evaluacion> evaluaciones = evaluacionRepositorio.findAll();

        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("evaluacion_consultas.pdf"));
            document.open();

            for (Evaluacion e : evaluaciones) {
                Paragraph paragraph = new Paragraph((e.getNombre()));
                document.add(paragraph);
            }


            document.close();
            writer.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }



}

