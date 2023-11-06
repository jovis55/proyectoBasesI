-- Insertar registros de ejemplo en la tabla usuario
INSERT INTO usuario (id_usuario, apellido, contrasena, email, nombre)
VALUES ('1234567890', 'González', 'contrasena1', 'usuario1@example.com', 'Juan Pérez'),
       ('9876543210', 'Martínez', 'contrasena2', 'usuario2@example.com', 'María López'),
       ('4567890123', 'Rodríguez', 'contrasena3', 'usuario3@example.com', 'Luis Ramírez'),
       ('user5', 'Apellido 5', 'password5', 'user5@example.com', 'Usuario 5'),
       ('user6', 'Apellido 6', 'password6', 'user6@example.com', 'Usuario 6'),
       ('user7', 'Apellido 7', 'password7', 'user7@example.com', 'Usuario 7'),
       ('user8', 'Apellido 8', 'password8', 'user8@example.com', 'Usuario 8'),
       ('admin1', 'ApellidoAdmin1', 'adminpassword1', 'admin1@example.com', 'Administrador 1');

-- Insertar registros de ejemplo en la tabla profesor (que hereda de usuario)
INSERT INTO profesor (id_usuario, direccion, fecha_nacimiento, telefono, titulo)
VALUES
    ('1234567890', '123 Calle Principal', '1980-03-15', '123456789', 'Licenciado en Matematicas'),
    ('9876543210', '456 Calle Secundaria', '1975-07-22', '987654321', 'Doctor en Historia'),
    ('4567890123', '789 Avenida Principal', '1988-11-05', '456789012', 'Ingeniero en Informatica');


INSERT INTO grupo (nombre)
VALUES
    ('Grupo 1'),
    ('Grupo 2'),
    ('Grupo 3'),
    ('Grupo 4');

INSERT INTO curso (descripcion, nombre, profesor_id_usuario)
VALUES
    ('Matemáticas Avanzadas', 'Matemáticas Avanzadas 101', '1234567890'),
    ('Historia del Arte', 'Historia del Arte 202', '9876543210'),
    ('Programación en Java', 'Programación en Java 303', '4567890123');

INSERT INTO horario (dia, hora_fin, hora_inicio, lugar, curso_id)
VALUES
    ('2023-11-06', '09:00:00', '08:00:00', 'Aula 101', 1),
    ('2023-11-07', '10:30:00', '09:30:00', 'Aula 102', 2),
    ('2023-11-08', '11:45:00', '10:45:00', 'Aula 103', 3);

INSERT INTO plan_estudio (duracion, fecha_finalizacion, fecha_inicio, nombre, syllabus, curso_id)
VALUES
    (4, '2027-11-30', '2023-11-06', 'Plan de Estudio 1', 'Syllabus 1', 1),
    (3, '2026-10-15', '2023-11-07', 'Plan de Estudio 2', 'Syllabus 2', 2),
    (5, '2028-05-20', '2023-11-08', 'Plan de Estudio 3', 'Syllabus 3', 3);



-- Insertar 4 estudiantes con grupos en la tabla Estudiante
INSERT INTO Estudiante (id_usuario, telefono_acudiente, fecha_nacimiento, grupo_id_grupo)
VALUES
    ('user5', 'telefono5', '2000-01-01', 1), -- Asignar al Grupo 1
    ('user6', 'telefono6', '2001-02-02', 2), -- Asignar al Grupo 2
    ('user7', 'telefono7', '2002-03-03', 3), -- Asignar al Grupo 3
    ('user8', 'telefono8', '2003-04-04', 4); -- Asignar al Grupo 4

INSERT INTO grupo_curso (curso_id, grupo_id_grupo)
VALUES (1, 1), (2, 2), (3, 3);

-- Insertar registros en la tabla Evaluacion relacionados con los profesores
INSERT INTO evaluacion (nombre, fecha_creacion, tiempo_limite, num_preguntas, hora_inicio, hora_fin, valor_porcentual, puntaje_aprobacion, cantidad_intentos, calificacion, tipo_evaluacion, tema, profesor_id_usuario)
VALUES
    ('Evaluación 1', '2023-01-01', '02:00:00', 10, '08:00:00', '10:00:00', 30.0, 70.0, 3, 0.0, 1, 1, '1234567890'),
    ('Evaluación 2', '2023-02-01', '01:30:00', 8, '09:00:00', '10:30:00', 20.0, 60.0, 2, 0.0, 1, 1, '9876543210'),
    ('Evaluación 3', '2023-03-01', '02:30:00', 12, '10:00:00', '12:30:00', 40.0, 75.0, 4, 0.0, 1, 1, '4567890123');


INSERT INTO pregunta (enunciado, fecha_creacion, puntos_pregunta, tema, visibilidad, evaluacion_id, profesor_id_usuario)
VALUES
    ('¿Cuál es la capital de Francia?', '2023-11-06', 5, 'HISTORIA', 1, 1, '1234567890'),
    ('Resuelve la ecuación x^2 - 4x + 4 = 0', '2023-11-07', 10, 'MATEMATICAS', 0, 2, '9876543210'),
    ('¿la función principal del corazón humano es bombear sangre para todo el cuerpo?', '2023-11-08', 8, 'BIOLOGIA', 1, 3, '4567890123');

INSERT INTO banco_preguntas (descripcion, fecha_creacion, nombre, total_preguntas, pregunta_id, profesor_id_usuario)
VALUES
    ('Banco de preguntas de Matemáticas', '2023-11-06', 'Banco de Matemáticas', 1, 1, '1234567890'),
    ('Banco de preguntas de Historia', '2023-11-07', 'Banco de Historia', 1, 2, '9876543210'),
    ('Banco de preguntas de Biología', '2023-11-08', 'Banco de Biología', 1, 3, '4567890123');

-- Insertar registros en la tabla EstudianteEvaluacion para relacionar estudiantes y evaluaciones
INSERT INTO estudiante_evaluacion (estudiante_id_usuario, evaluacion_id)
VALUES
    ('user5', 1),  -- Asociar 'Estudiante 5' a 'Evaluación 1'
    ('user5', 2),  -- Asociar 'Estudiante 5' a 'Evaluación 2'
    ('user6', 1),  -- Asociar 'Estudiante 6' a 'Evaluación 1'
    ('user7', 2),  -- Asociar 'Estudiante 7' a 'Evaluación 2'
    ('user8', 3);  -- Asociar 'Estudiante 8' a 'Evaluación 3'

INSERT INTO falsoy_verdadero (respuesta_boolean, id)
VALUES
    (true, 3);

INSERT INTO escribir_texto (texto_respuesta, id)
VALUES
    ('La solución es x = 2', 2);

-- Insertar un registro en la tabla SeleccionMultiple relacionado con la pregunta
INSERT INTO seleccion_multiple (cantidad_opciones, id)
VALUES
    (4, 1);

-- Insertar registros en la tabla Opcion relacionados con la pregunta de selección múltiple
INSERT INTO Opcion (opcion, seleccion_multiple_id)
VALUES
    ('París', 1),
    ('Madrid', 1),
    ('Londres', 1),
    ('Berlín', 1);

-- Insertar un registro en la tabla UnicaRespuesta relacionado con la pregunta de selección múltiple
INSERT INTO unica_respuesta (id, opcion_correcta_id)
VALUES
    (1, 1);  -- La opción correcta es 'París'

