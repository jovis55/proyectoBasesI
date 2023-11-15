package com.example.proyectobases.controllers;

import com.example.proyectobases.interfaces.ConsultaRepo;
import com.example.proyectobases.interfaces.EstudianteEvaluacionRepositorio;
import com.example.proyectobases.interfaces.EstudianteRepositorio;
import com.example.proyectobases.interfaces.EvaluacionRepositorio;
import com.example.proyectobases.model.EstudianteEvaluacion;
import com.example.proyectobases.model.Evaluacion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
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
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Estudiantes-Notas.pdf"));
            document.open();

            for (EstudianteEvaluacion estudianteEvaluacion : estudiantes) {
                Paragraph paragraph = new Paragraph(
                        estudianteEvaluacion.getId_usuario().getNombre()+"  ="+estudianteEvaluacion.getCalificacion());
                document.add(paragraph);
            }

            // Genera una gráfica de barras
            JFreeChart chart = createBarChart(estudiantes);

            // Convierte la gráfica a una imagen en un array de bytes
            ByteArrayOutputStream chartImageStream = new ByteArrayOutputStream();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(new Dimension(700, 500));
            ChartUtils.writeChartAsPNG(chartImageStream, chart, 700, 500);

            // Agrega la imagen de la gráfica al PDF
            Image image = Image.getInstance(chartImageStream.toByteArray());
            document.add(image);


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
                Paragraph paragraph = new Paragraph(e.getNombre());
                document.add(paragraph);
            }
            /*
            // Genera una gráfica de barras
            JFreeChart chart = createBarChart(evaluaciones);

            // Convierte la gráfica a una imagen en un array de bytes
            ByteArrayOutputStream chartImageStream = new ByteArrayOutputStream();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(new Dimension(500, 300));
            ChartUtils.writeChartAsPNG(chartImageStream, chart, 500, 300);

            // Agrega la imagen de la gráfica al PDF
            Image image = Image.getInstance(chartImageStream.toByteArray());
            document.add(image);

            document.close();
            writer.close();
            */


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }

    private JFreeChart createBarChart(List<EstudianteEvaluacion> estudiantes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (EstudianteEvaluacion e : estudiantes) {
            // Agrega datos a la gráfica (por ejemplo, puntajes de evaluaciones)
            dataset.addValue(e.getCalificacion(), "Evaluación", e.getId_usuario().getNombre());
        }

        return ChartFactory.createBarChart(
                "Puntajes de Evaluaciones",
                "Evaluaciones",
                "Puntaje",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);
    }



}

