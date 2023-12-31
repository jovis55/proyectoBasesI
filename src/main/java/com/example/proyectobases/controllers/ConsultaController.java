package com.example.proyectobases.controllers;

import com.example.proyectobases.interfaces.*;
import com.example.proyectobases.model.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reportes")
public class ConsultaController {

    private final ConsultaRepo consultaRepo;
    private final EstudianteEvaluacionRepositorio estudianteEvaluacionRepositorio;
    private final EstudianteRepositorio estudianteRepositorio;
    private final EvaluacionRepositorio evaluacionRepositorio;
    private final ProfesorRepo profesorRepositorio;
    private final UsuarioRepo usuarioRepositorio;

    @GetMapping("/promedioEstudiantes")
    public void generarPDF() {
        List<EstudianteEvaluacion> estudiantes = estudianteEvaluacionRepositorio.findAll();

        try {
            Document document = new Document(new Rectangle(1000, 1000));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("EstudiantesNotaPromedio.pdf"));
            document.open();

            ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

            for (EstudianteEvaluacion estudianteEvaluacion : estudiantes) {
                Paragraph paragraph = new Paragraph(
                        estudianteEvaluacion.getEstudiante().getNombre() + "  =" + estudianteEvaluacion.getCalificacion());
                document.add(paragraph);
                if (!listaEstudiantes.contains(estudianteEvaluacion.getEstudiante())){
                    listaEstudiantes.add(estudianteEvaluacion.getEstudiante());
                }
            }

            Map<String, Double> sumas = new LinkedHashMap<>();
            Map<String, Integer> conteos = new LinkedHashMap<>();

            for (EstudianteEvaluacion evaluacion : estudiantes) {
                sumas.merge(evaluacion.getEstudiante().getIdUsuario(), evaluacion.getCalificacion(), Double::sum);
                conteos.merge(evaluacion.getEstudiante().getIdUsuario(), 1, Integer::sum);
            }

            List<EstudianteEvaluacion> listaPromedio = new ArrayList<>();
            int contador = 0;
            for (Map.Entry<String, Double> entry : sumas.entrySet()) {
                String codigoEstudiante = entry.getKey();
                double sumaCalificaciones = entry.getValue();
                int conteo = conteos.get(codigoEstudiante);
                double promedio = sumaCalificaciones / conteo;

                EstudianteEvaluacion estudianteEvaluacionNuevo = new EstudianteEvaluacion();
                estudianteEvaluacionNuevo.setCodigo(contador);
                estudianteEvaluacionNuevo.setEstudiante(listaEstudiantes.get(contador));
                estudianteEvaluacionNuevo.setEvaluacion(null);
                estudianteEvaluacionNuevo.setCalificacion(promedio);
//                nuevaEvaluacion.setCodigoEstudiante(codigoEstudiante);
//                nuevaEvaluacion.setCalificacion(promedio);

                listaPromedio.add(estudianteEvaluacionNuevo);
                contador++;
            }

            // Genera una gráfica de barras
            JFreeChart chart = createBarChart(listaPromedio, 1);

            chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);

            // Convierte la gráfica a una imagen en un array de bytes
            ByteArrayOutputStream chartImageStream = new ByteArrayOutputStream();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(new Dimension(800, 600));
            ChartUtils.writeChartAsPNG(chartImageStream, chart, 800, 600);

            // Agrega la imagen de la gráfica al PDF
            Image image = Image.getInstance(chartImageStream.toByteArray());
            document.add(image);


            document.close();
            writer.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    //La funcion muestra las evaluaciones realizadas por un estudiante en especifico
    @GetMapping("/evaluaciones/estudiante/{codigo}")
    public void mostrarEvaluacionesEstudiante(@PathVariable String codigo) {
        List<EstudianteEvaluacion> evaluaciones = estudianteEvaluacionRepositorio.findByEstudianteIdUsuario(codigo);
        String nombreArchivo = "EvaluacionesEstudiante-" + codigo + ".pdf";

        try {
            Document document = new Document(new Rectangle(1000, 1000));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            for (EstudianteEvaluacion estudianteEvaluacion : evaluaciones) {
                Paragraph paragraph = new Paragraph(
                        estudianteEvaluacion.getEstudiante().getNombre() + "  =" + estudianteEvaluacion.getCalificacion());
                document.add(paragraph);
            }

            // Genera una gráfica de barras
            JFreeChart chart = createBarChart(evaluaciones, 2);

            chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);

            // Convierte la gráfica a una imagen en un array de bytes
            ByteArrayOutputStream chartImageStream = new ByteArrayOutputStream();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(new Dimension(800, 600));
            ChartUtils.writeChartAsPNG(chartImageStream, chart, 800, 600);

            // Agrega la imagen de la gráfica al PDF
            Image image = Image.getInstance(chartImageStream.toByteArray());
            document.add(image);


            document.close();
            writer.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }

    //identificar en que temas se desempeña mejor, para esto, hacemos el análisis
    // con las evaluaciones presentadas y ganadas por encima de 3 y los temas específicos
    // de estas evaluaciones.
    @GetMapping("/desempeno/estudiante/{codigo}")
    public void generarReporteDesempeno(@PathVariable String codigo) {
        List<EstudianteEvaluacion> desempeno = estudianteEvaluacionRepositorio.findByEstudianteIdUsuarioAndCalificacionGreaterThan(codigo, 3.0);
        String nombreArchivo = "ReporteDesempeño-" + codigo + ".pdf";

        Map<String, Double> reporte = calcularPromedioPorTema(desempeno);
        try {

            Document document = new Document(new Rectangle(1000, 1000));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            document.newPage();

            for (Map.Entry<String, Double> entry : reporte.entrySet()) {
                Paragraph paragraph = new Paragraph(
                        entry.getKey() + "=" + entry.getValue());
                document.add(paragraph);
            }

            // Genera una gráfica de barras
            JFreeChart chart = crearGraficoHashMap(reporte);

            chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);

            // Convierte la gráfica a una imagen en un array de bytes
            ByteArrayOutputStream chartImageStream = new ByteArrayOutputStream();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(new Dimension(800, 600));
            ChartUtils.writeChartAsPNG(chartImageStream, chart, 800, 600);

            // Agrega la imagen de la gráfica al PDF
            Image image = Image.getInstance(chartImageStream.toByteArray());
            document.add(image);

            document.close();
            writer.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/profesores/listar")
    public void listarProfesores(){
        List<Profesor> profesores = profesorRepositorio.findAll();
        List<Usuario> usuarios = usuarioRepositorio.findAll();

        String nombreArchivo = "ProfesoresActivos.pdf";

        try {
            Document document = new Document(new Rectangle(1000, 1000));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Título del informe
            Paragraph title = new Paragraph("Profesores de la Institucion", new Font(Font.FontFamily.TIMES_ROMAN, 25));
            document.add(title);

            for (Profesor profe : profesores) {
                for (Usuario user : usuarios){
                    if (Objects.equals(user.getIdUsuario(), profe.getIdUsuario())) {
                        Paragraph paragraph = new Paragraph(profe.getIdUsuario() + " --> " + user.getNombre());
                        paragraph.setSpacingBefore(10);
                        document.add(paragraph);
                    }

                }
            }

            // Tabla para mostrar estadísticas
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            document.add(table);
            document.close();
            writer.close();


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }


    //Reporte de Estadísticas de Evaluación
    @GetMapping("/evaluacion/{codigo}")
    public void realizarInformeEvaluacion(@PathVariable int codigo) {
        List<EstudianteEvaluacion> evaluaciones = estudianteEvaluacionRepositorio.findByEvaluacion_Id(codigo);
        String nombreArchivo = "ReporteEvaluacion-" + codigo + ".pdf";

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset= obtenerDatosEstadisticos(evaluaciones);
        for (EstudianteEvaluacion e : evaluaciones) {

        }
        Map<String, String> statistics = new LinkedHashMap<>();
        statistics.put("Nombre",  evaluaciones.get(0).getEvaluacion().getNombre());
        statistics.put("Fecha de creacion", String.valueOf(evaluaciones.get(0).getEvaluacion().getFechaCreacion()));
        statistics.put("Tiempo Limite", String.valueOf(evaluaciones.get(0).getEvaluacion().getTiempoLimite()));
        statistics.put("Numero de Preguntas",  String.valueOf(evaluaciones.get(0).getEvaluacion().getNumPreguntas()));
        statistics.put("Hora Inicio", String.valueOf(evaluaciones.get(0).getEvaluacion().getHoraInicio()));
        statistics.put("Hora fin", String.valueOf(evaluaciones.get(0).getEvaluacion().getHoraFin()));
        statistics.put("valor Porcentual", String.valueOf(evaluaciones.get(0).getEvaluacion().getPuntajeAprobacion()));
        statistics.put("Cantidad de intentos", String.valueOf(evaluaciones.get(0).getEvaluacion().getCantidadIntentos()));

        try {
            Document document = new Document(new Rectangle(1000, 1000));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Título del informe
            Paragraph title = new Paragraph("Informe de Estadísticas de Evaluación");
            document.add(title);

            // Tabla para mostrar estadísticas
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);

            for (Map.Entry<String, String> entry : statistics.entrySet()) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(entry.getKey()));
                PdfPCell cell2 = new PdfPCell(new Paragraph(entry.getValue()));

                table.addCell(cell1);
                table.addCell(cell2);
            }

            JFreeChart chart = crearGraficoTorta(dataset);

            ByteArrayOutputStream chartImageStream = new ByteArrayOutputStream();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(new Dimension(800, 600));
            ChartUtils.writeChartAsPNG(chartImageStream, chart, 800, 600);

            // Agrega la imagen de la gráfica al PDF
            Image image = Image.getInstance(chartImageStream.toByteArray());
            document.add(image);


            document.add(table);
            document.close();
            writer.close();


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }

    private JFreeChart crearGraficoTorta(DefaultPieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Ejemplo de Gráfico de Torta",   // Título del gráfico
                dataset, // Dataset
                true,    // Leyenda
                true,    // Herramientas
                false   // URLs
        );
        // Configuración del gráfico de torta
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint(dataset.getKey(1), Color.RED); // Personalizar color de una sección (en este caso, "Java")
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));

        return chart;
    }

    private JFreeChart createBarChart(List<EstudianteEvaluacion> estudiantes, int tipoConsulta) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        switch (tipoConsulta) {
            case 1:
                for (EstudianteEvaluacion e : estudiantes) {
                    // Agrega datos a la gráfica (por ejemplo, puntajes de evaluaciones)
                    dataset.addValue(e.getCalificacion(), "Evaluación", e.getEstudiante().getNombre()+"");
                }

                return ChartFactory.createBarChart(
                        "Puntajes de Evaluaciones",
                        "Evaluaciones",
                        "Puntaje",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);
            case 2:
                for (EstudianteEvaluacion ee : estudiantes) {
                    // Agrega datos a la gráfica (por ejemplo, calificaciones de evaluaciones)
                    dataset.addValue(ee.getCalificacion(), "Evaluación", ee.getEvaluacion().getNombre());
                }

                return ChartFactory.createBarChart(
                        "Calificaciones de Evaluaciones por Estudiante",
                        "Evaluaciones",
                        "Calificación",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);
        }
        return null;
    }

    private DefaultPieDataset obtenerDatosEstadisticos(List<EstudianteEvaluacion> evaluacion) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        if (!evaluacion.isEmpty()) {
            // Contar el número de evaluaciones aprobadas
            long evaluacionesAprobadas = 0;
            long evaluacionesReprobadas=0;

            for (EstudianteEvaluacion e : evaluacion) {
                if (e.getCalificacion() >= e.getEvaluacion().getPuntajeAprobacion()) {
                    evaluacionesAprobadas++;
                }else {
                    evaluacionesReprobadas++;
                }
            }
            // Agregar datos al dataset
            dataset.setValue("Porcentaje evaluaciones reprobadas", evaluacionesReprobadas);
            dataset.setValue("Porcentaje evaluaciones aprobadas", evaluacionesAprobadas);

        }
        return dataset;
    }

    private Map<String, Double> calcularPromedioPorTema (List < EstudianteEvaluacion > estudianteEvaluaciones) {

        Map<String, Double> totalNotasPorTema = new LinkedHashMap<>();
        Map<String, Integer> cuentaEvaluacionesPorTema = new LinkedHashMap<>();
        for (EstudianteEvaluacion estudianteEvaluacion : estudianteEvaluaciones) {
            Evaluacion evaluacion = estudianteEvaluacion.getEvaluacion();
            String tema = evaluacion.getTema().toString();
            double calificacion = estudianteEvaluacion.getCalificacion();

            // Verificar si ya se ha registrado una evaluación para el tema actual
            if (totalNotasPorTema.containsKey(tema)) {
                // Si ya existe, sumar la calificación al total y aumentar la cuenta
                totalNotasPorTema.put(tema, totalNotasPorTema.get(tema) + calificacion);
                cuentaEvaluacionesPorTema.put(tema, cuentaEvaluacionesPorTema.get(tema) + 1);
            } else {
                    // Si no existe, agregar la calificación y establecer la cuenta en 1
                    totalNotasPorTema.put(tema, calificacion);
                    cuentaEvaluacionesPorTema.put(tema, 1);
                }
            }

            // Calcular el promedio por tema
            Map<String, Double> promedioPorTema = new LinkedHashMap<>();
            for (Map.Entry<String, Double> entry : totalNotasPorTema.entrySet()) {
                String tema = entry.getKey();
                double totalNotas = entry.getValue();
                int cuentaEvaluaciones = cuentaEvaluacionesPorTema.get(tema);

                double promedio = totalNotas / cuentaEvaluaciones;
                promedioPorTema.put(tema, promedio);
            }

            return promedioPorTema;

        }
    private JFreeChart crearGraficoHashMap(Map<String, Double> datos) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            String tema = entry.getKey();
            double promedio = entry.getValue();
            dataset.addValue(promedio, "Promedio", tema);
        }

        // Crear el gráfico de barras
        JFreeChart barChart = ChartFactory.createBarChart(
                "Promedio por Tema",
                "Tema",
                "Promedio",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return barChart;
    }
 }


