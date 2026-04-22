CREATE DATABASE IF NOT EXISTS radio_concursos;
USE radio_concursos;

DROP TABLE IF EXISTS inscriptos;
DROP TABLE IF EXISTS concursos;

-- 3. Crear estructura de la tabla 'concursos'
CREATE TABLE concursos
(
    id_concurso  INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    fecha_inicio DATE,
    fecha_fin    DATE
);

CREATE TABLE inscriptos
(
    id_inscripto INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(50)  NOT NULL,
    apellido     VARCHAR(50)  NOT NULL,
    telefono     VARCHAR(20)  NOT NULL,
    email        VARCHAR(100) NOT NULL,
    id_concurso  INT          NOT NULL,
    FOREIGN KEY (id_concurso) REFERENCES concursos (id_concurso)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

INSERT INTO concursos (nombre, fecha_inicio, fecha_fin)
VALUES ('Concurso de Fotografía Amateur', '2026-04-01', '2026-05-01'),
       ('Maratón de Programación Java', '2026-05-10', '2026-05-20'),
       ('Sorteo Aniversario de la Radio', '2026-06-01', '2026-06-30');

-- Opcional: Insertar un inscripto de prueba (para verificar que las relaciones funcionan)
-- INSERT INTO inscriptos (nombre, apellido, telefono, email, id_concurso) VALUES
-- ('Juan', 'Perez', '1234-567890', 'juanperez@gmail.com', 1);