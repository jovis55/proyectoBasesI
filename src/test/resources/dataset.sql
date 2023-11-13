-- Insertar registros de ejemplo en la tabla usuario
INSERT INTO usuario (id_usuario, apellido, contrasena, email, nombre)
VALUES ('1234567890', 'González', 'contrasena1', 'usuario1@example.com', 'Juan Pérez'),
       ('9876543210', 'Martínez', 'contrasena2', 'usuario2@example.com', 'María López'),
       ('4567890123', 'Rodríguez', 'contrasena3', 'usuario3@example.com', 'Luis Ramírez'),
       ('user5', 'Apellido 5', 'password5', 'user5@example.com', 'Usuario 5'),
       ('user6', 'Apellido 6', 'password6', 'user6@example.com', 'Usuario 6'),
       ('user7', 'Apellido 7', 'password7', 'user7@example.com', 'Usuario 7'),
       ('user8', 'Apellido 8', 'password8', 'user8@example.com', 'Usuario 8'),
       ('admin1', 'ApellidoAdmin1', 'adminpassword1', 'admin1@example.com', 'Administrador 1'),
       ('user9', 'Apellido 9', 'password9', 'user9@example.com', 'Usuario 9'),
       ('user10', 'Apellido 10', 'password10', 'user10@example.com', 'Usuario 10'),
       ('user11', 'Apellido 11', 'password11', 'user11@example.com', 'Usuario 11'),
       ('user12', 'Apellido 12', 'password12', 'user12@example.com', 'Usuario 12'),
       ('user13', 'Apellido 13', 'password13', 'user13@example.com', 'Usuario 13'),
       ('user14', 'Apellido 14', 'password14', 'user14@example.com', 'Usuario 14'),
       ('user15', 'Apellido 15', 'password15', 'user15@example.com', 'Usuario 15'),
       ('user16', 'Apellido 16', 'password16', 'user16@example.com', 'Usuario 16'),
       ('user17', 'Apellido 17', 'password17', 'user17@example.com', 'Usuario 17'),
       ('user18', 'Apellido 18', 'password18', 'user18@example.com', 'Usuario 18');

-- Insertar registros de ejemplo en la tabla profesor (que hereda de usuario)
INSERT INTO profesor (id_usuario, direccion, fecha_nacimiento, telefono, titulo)
VALUES
    ('1234567890', '123 Calle Principal', '1980-03-15', '123456789', 'Licenciado en Matematicas'),
    ('9876543210', '456 Calle Secundaria', '1975-07-22', '987654321', 'Doctor en Historia'),
    ('4567890123', '789 Avenida Principal', '1988-11-05', '456789012', 'Ingeniero en Informatica'),
    ('user9', '789 Calle Nueva', '1978-06-25', '987654321', 'Licenciado en Historia'),
    ('user10', '456 Calle Vieja', '1985-09-12', '123456789', 'Doctor en Matemáticas'),
    ('user11', '321 Avenida Antigua', '1989-12-07', '456789012', 'Ingeniero en Física'),
    ('user12', '111 Avenida Moderna', '1976-03-18', '111222333', 'Licenciado en Biología'),
    ('user13', '222 Calle Antigua', '1980-05-30', '444555666', 'Doctor en Literatura'),
    ('user14', '444 Calle Nueva', '1990-11-22', '777888999', 'Ingeniero en Química');


INSERT INTO grupo (nombre)
VALUES
    ('Grupo 1'),
    ('Grupo 2'),
    ('Grupo 3'),
    ('Grupo 4'),
    ('Grupo 5'),
    ('Grupo 6'),
    ('Grupo 7'),
    ('Grupo 8'),
    ('Grupo 9'),
    ('Grupo 10'),
    ('Grupo 11'),
    ('Grupo 12'),
    ('Grupo 13'),
    ('Grupo 14');

INSERT INTO curso (descripcion, nombre, profesor_id_usuario)
VALUES
    ('Matemáticas Avanzadas', 'Matemáticas Avanzadas 101', '1234567890'),
    ('Historia del Arte', 'Historia del Arte 202', '9876543210'),
    ('Programación en Java', 'Programación en Java 303', '4567890123'),
    ('Física Cuántica', 'Física Cuántica 404', 'user9'),
    ('Literatura Contemporánea', 'Literatura Contemporánea 505', 'user10'),
    ('Química Orgánica', 'Química Orgánica 606', 'user11'),
    ('Música Clásica', 'Música Clásica 707', 'user12'),
    ('Arte Moderno', 'Arte Moderno 808', 'user13'),
    ('Filosofía Antigua', 'Filosofía Antigua 909', 'user14');

INSERT INTO horario (dia, hora_fin, hora_inicio, lugar, curso_id)
VALUES
    ('2023-11-06', '09:00:00', '08:00:00', 'Aula 101', 1),
    ('2023-11-07', '10:30:00', '09:30:00', 'Aula 102', 2),
    ('2023-11-08', '11:45:00', '10:45:00', 'Aula 103', 3),
    ('2023-11-09', '10:00:00', '09:00:00', 'Aula 104', 4),
    ('2023-11-10', '11:30:00', '10:30:00', 'Aula 105', 5),
    ('2023-11-11', '12:45:00', '11:45:00', 'Aula 106', 6),
    ('2023-11-12', '14:00:00', '13:00:00', 'Aula 107', 7),
    ('2023-11-13', '15:30:00', '14:30:00', 'Aula 108', 8),
    ('2023-11-14', '16:45:00', '15:45:00', 'Aula 109', 9);


INSERT INTO plan_estudio (duracion, fecha_finalizacion, fecha_inicio, nombre, syllabus, curso_id)
VALUES
    (4, '2027-11-30', '2023-11-06', 'Plan de Estudio 1', 'Syllabus 1', 1),
    (3, '2026-10-15', '2023-11-07', 'Plan de Estudio 2', 'Syllabus 2', 2),
    (5, '2028-05-20', '2023-11-08', 'Plan de Estudio 3', 'Syllabus 3', 3),
    (6, '2029-11-30', '2023-11-09', 'Plan de Estudio 4', 'Syllabus 4', 4),
    (7, '2030-10-15', '2023-11-10', 'Plan de Estudio 5', 'Syllabus 5', 5),
    (8, '2031-05-20', '2023-11-11', 'Plan de Estudio 6', 'Syllabus 6', 6),
    (9, '2032-08-25', '2023-11-12', 'Plan de Estudio 7', 'Syllabus 7', 7),
    (10, '2033-06-10', '2023-11-13', 'Plan de Estudio 8', 'Syllabus 8', 8),
    (11, '2034-09-15', '2023-11-14', 'Plan de Estudio 9', 'Syllabus 9', 9);



-- Insertar 4 estudiantes con grupos en la tabla Estudiante
INSERT INTO Estudiante (id_usuario, telefono_acudiente, fecha_nacimiento, grupo_id_grupo)
VALUES
    ('user5', 'telefono5', '2000-01-01', 1), -- Asignar al Grupo 1
    ('user6', 'telefono6', '2001-02-02', 2), -- Asignar al Grupo 2
    ('user7', 'telefono7', '2002-03-03', 3), -- Asignar al Grupo 3
    ('user8', 'telefono8', '2003-04-04', 4), -- Asignar al Grupo 4
    ('user15', 'telefono15', '2010-11-11', 5),
    ('user16', 'telefono16', '2011-12-12', 6),
    ('user17', 'telefono17', '2012-01-01', 7),
    ('user18', 'telefono18', '2013-02-02', 8);

INSERT INTO grupo_curso (curso_id, grupo_id_grupo)
VALUES (1, 1), (2, 2), (3, 3), (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9);

-- Insertar registros en la tabla Evaluacion relacionados con los profesores
INSERT INTO evaluacion (nombre, fecha_creacion, tiempo_limite, num_preguntas, hora_inicio, hora_fin, valor_porcentual, puntaje_aprobacion, cantidad_intentos, tipo_evaluacion, tema, profesor_id_usuario)
VALUES
    ('Evaluación 1', '2023-01-01', '02:00:00', 5, '08:00:00', '10:00:00', 30.0, 70.0, 3, 1, 1, '1234567890'),
    ('Evaluación 2', '2023-02-01', '01:30:00', 8, '09:00:00', '10:30:00', 20.0, 60.0, 2, 1, 1, '9876543210'),
    ('Evaluación 3', '2023-03-01', '02:30:00', 12, '10:00:00', '12:30:00', 40.0, 75.0, 4, 1, 1, '4567890123'),
    ('Evaluación 4', '2023-04-01', '02:30:00', 15, '08:30:00', '11:00:00', 50.0, 80.0, 5, 2, 2, 'user9'),
    ('Evaluación 5', '2023-05-01', '02:00:00', 12, '09:30:00', '11:30:00', 40.0, 75.0, 4, 2, 2, 'user10');

INSERT INTO pregunta (enunciado, fecha_creacion, puntos_pregunta, tema, visibilidad, evaluacion_id, profesor_id_usuario)
VALUES
    ('¿Cuál es la capital de Francia?', '2023-11-06', 5, 'HISTORIA', 1, 1, '1234567890'),
    ('Resuelve la ecuación x^2 - 4x + 4 = 0', '2023-11-07', 10, 'MATEMATICAS', 0, 2, '9876543210'),
    ('¿la función principal del corazón humano es bombear sangre para todo el cuerpo?', '2023-11-08', 8, 'BIOLOGIA', 1, 3, '4567890123'),
    ('¿Cuál es la capital de Alemania?', '2023-11-19', 5, 'HISTORIA', 1, 4, 'user9'),
    ('Resuelve la ecuación 3x + 5 = 20', '2023-11-20', 10, 'MATEMATICAS', 0, 5, 'user10'),
    ('¿El ADN es el material genético en los seres humanos?', '2023-11-21', 8, 'BIOLOGIA', 1, 1, 'user11'),
    ('¿Quién pintó la Mona Lisa?', '2023-11-22', 5, 'ARTE', 1, 2, 'user12'),
    ('¿Qué es un haiku?', '2023-11-23', 7, 'LENGUAJE', 0, 3, 'user13'),
    ('¿Qué es un triángulo isósceles?', '2023-11-24', 9, 'GEOMETRIA', 1, 4, 'user14'),
    ('¿Es la Luna más grande que la Tierra?', '2023-11-25', 6, 'CIENCIAS', 1, 1, '1234567890'),
    ('Resuelve la expresión: 2 * (4 + 3) - 5', '2023-11-26', 8, 'MATEMATICAS', 0, 1, '1234567890'),
    ('¿Las plantas realizan la fotosíntesis?', '2023-11-27', 7, 'BIOLOGIA', 1, 1, '1234567890'),
    ('¿El sol gira alrededor de la Tierra?', '2023-11-28', 5, 'ASTRONOMIA', 1, 2, '9876543210'),
    ('Resuelve la ecuación 2x - 7 = 11', '2023-11-29', 9, 'MATEMATICAS', 0, 2, '9876543210'),
    ('¿El agua hierve a 100 grados Celsius?', '2023-11-30', 6, 'QUIMICA', 1, 2, '9876543210'),
    ('¿La Tierra es plana?', '2023-12-01', 4, 'CIENCIAS', 1, 3, '4567890123'),
    ('Resuelve la ecuación cuadrática: x^2 - 9 = 0', '2023-12-02', 10, 'MATEMATICAS', 0, 3, '4567890123'),
    ('¿El oxígeno es necesario para la combustión?', '2023-12-03', 7, 'QUIMICA', 1, 3, '4567890123'),
    ('¿el símbolo químico del oro es AU?', '2023-12-04', 5, 'QUIMICA', 1, 4, 'user9'),
    ('Resuelve la ecuación 4x + 2 = 18', '2023-12-05', 8, 'MATEMATICAS', 0, 4, 'user9'),
    ('¿Cuál es la capital de Canadá?', '2023-12-06', 6, 'GEOGRAFIA', 1, 4, 'user9'),
    ('¿La fotosíntesis ocurre en las células animales?', '2023-12-07', 7, 'BIOLOGIA', 1, 5, 'user10'),
    ('la solucion a la ecuación 3y - 5 = 10 es: ', '2023-12-08', 9, 'MATEMATICAS', 0, 5, 'user10'),
    ('¿la capital de Australia es sidney?', '2023-12-09', 6, 'GEOGRAFIA', 1, 5, 'user10');


INSERT INTO banco_preguntas (descripcion, fecha_creacion, nombre, total_preguntas, pregunta_id, profesor_id_usuario)
VALUES
    ('Banco de preguntas de Matemáticas', '2023-11-06', 'Banco de Matemáticas', 1, 1, '1234567890'),
    ('Banco de preguntas de Historia', '2023-11-07', 'Banco de Historia', 1, 2, '9876543210'),
    ('Banco de preguntas de Biología', '2023-11-08', 'Banco de Biología', 1, 3, '4567890123'),
    ('Banco de preguntas de Geografía', '2023-11-19', 'Banco de Geografía', 1, 1, 'user9'),
    ('Banco de preguntas de Matemáticas', '2023-11-20', 'Banco de Matemáticas', 1, 2, 'user10'),
    ('Banco de preguntas de Biología', '2023-11-21', 'Banco de Biología', 1, 3, 'user11'),
    ('Banco de preguntas de Arte', '2023-11-22', 'Banco de Arte', 1, 4, 'user12'),
    ('Banco de preguntas de Lenguaje', '2023-11-23', 'Banco de Lenguaje', 1, 5, 'user13'),
    ('Banco de preguntas de Geometría', '2023-11-24', 'Banco de Geometría', 1, 6, 'user14');

-- Insertar registros en la tabla EstudianteEvaluacion para relacionar estudiantes y evaluaciones
INSERT INTO estudiante_evaluacion (id_usuario, evaluacion_id, calificacion)
VALUES
    ('user5', 1,2.0),  -- Asociar 'Estudiante 5' a 'Evaluación 1'
    ('user5', 2,2.0),  -- Asociar 'Estudiante 5' a 'Evaluación 2'
    ('user6', 1,2.8),  -- Asociar 'Estudiante 6' a 'Evaluación 1'
    ('user7', 2,2.7),  -- Asociar 'Estudiante 7' a 'Evaluación 2'
    ('user8', 3,2.7),  -- Asociar 'Estudiante 8' a 'Evaluación 3'
    ('user15', 4,2.1),
    ('user16', 5,2.0),
    ('user17', 1,1.0),
    ('user18', 5,4.0);



INSERT INTO falsoy_verdadero (respuesta_boolean, id)
VALUES
    (true, 3),
    (false, 6),
    (false, 10),
    (true, 12),
    (false, 13),
    (true, 15),
    (false, 16),
    (true, 18),
    (true, 19),
    (true, 22),
    (true, 24)
    ;

INSERT INTO escribir_texto (texto_respuesta, id)
VALUES
    ('La solución es x = 2', 2),
    ('La respuesta es 15', 4),
    ('La solución es x = 10', 5),
    ('Un triángulo con dos lados iguales', 9),
    ('..',11 ),
    ('..',14 ),
    ('..',17),
    ('..',20)
    ;

-- Insertar un registro en la tabla SeleccionMultiple relacionado con la pregunta
INSERT INTO seleccion_multiple (cantidad_opciones, id)
VALUES
    (4, 1),
    (4, 7),
    (3, 8),
    (3, 21),
    (3,22);

-- Insertar registros en la tabla Opcion relacionados con la pregunta de selección múltiple
INSERT INTO Opcion (opcion, seleccion_multiple_id)
VALUES
    ('París', 1),
    ('Madrid', 1),
    ('Londres', 1),
    ('Berlín', 1),
    ('Respuesta: Vincent Van Gogh',7 ),
    ('Respuesta: Pablo Picasso', 7),
    ('Respuesta: Claude Monet', 7),
    ('Respuesta: Da vinci',7),
    ('Poema', 8),
    ('Cuento', 8),
    ('Poema corto', 8),
    ('francia',21),
    ('italia',21),
    ('ottawa',21),
    ('y=1',22),
    ('x=8',22),
    ('y=5',22);

-- Insertar un registro en la tabla UnicaRespuesta relacionado con la pregunta de selección múltiple
INSERT INTO unica_respuesta (id, opcion_correcta_id)
VALUES
    (1, 1),  -- La opción correcta es 'París'
    (7, 4),
    (8, 3),
    (21,14),
    (22,17);
/**
-- Respuestas de los estudiantes a las preguntas de opción múltiple
INSERT INTO respuesta_estudiante (respuesta_opcion_id, estudiante_id_usuario, pregunta_id)
VALUES
    (1, 'user5', 1),    -- Estudiante 5 responde correctamente la Pregunta 1
    (true, 'user5', 6);  -- Estudiante 5 responde incorrectamente la Pregunta 2

-- Respuestas de los estudiantes a las preguntas de falso y verdadero
INSERT INTO respuesta_estudiante (respuesta, estudiante_id_usuario, pregunta_id)
VALUES
    (false, 'user5', 10),    -- Estudiante 5 responde incorrectamente la Pregunta 3
    (true, 'user8', 12);
-- Respuestas de los estudiantes a las preguntas de texto
INSERT INTO respuesta_estudiante (respuestaTexto, estudiante_id_usuario, pregunta_id)
VALUES
    ('23', 'user5', 11);   -- Estudiante 5 responde incorrectamente la Pregunta 3
*/