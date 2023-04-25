CREATE
DATABASE StudentDB;
CREATE TABLE student
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(50) NOT NULL,
    age       INT         NOT NULL,
    grade     FLOAT       NOT NULL
);
INSERT INTO student (id, full_name, age)
VALUES ("Andrew", 16, 9.6),
       ("Lily", 16, 8.8);
CREATE TABLE course
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    course_name    VARCHAR(50) NOT NULL,
    no_of_students INT         NOT NULL
);
INSERT INTO course (course_name, no_of_students)
VALUES ("Database System", 33),
       ("Software Engineering 2", 30);
SELECT *
FROM student;
SELECT *
FROM course;
