-- data for 'teachers' table
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 1');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 2');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 3');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 4');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 5');

-- data for 'courses' table
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 1', 0, 'BASIC', 12.5, TRUE);

INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 2 - Teacher 1', 0, 'BASIC', 12.5, TRUE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 2 - Teacher 2', 1, 'INTERMEDIATE', 22.8, TRUE);

INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 3 - Teacher 1', 0, 'BASIC', 12.5, TRUE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 3 - Teacher 2', 1, 'INTERMEDIATE', 22.7, FALSE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 3 - Teacher 3', 2, 'ADVANCED', 43.5, TRUE);

INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 4 - Teacher 1', 0, 'BASIC', 12.5, FALSE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 4 - Teacher 2', 1, 'INTERMEDIATE', 22.2, TRUE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 4 - Teacher 3', 2, 'ADVANCED', 45, FALSE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 4 - Teacher 4', 3, 'BASIC', 10, TRUE);

INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 5 - Teacher 1', 0, 'BASIC', 8.01, TRUE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 5 - Teacher 2', 1, 'INTERMEDIATE', 25.49, FALSE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 5 - Teacher 3', 2, 'ADVANCED', 51.15, FALSE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 5 - Teacher 4', 3, 'BASIC', 12.5, TRUE);
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 5 - Teacher 5', 4, 'INTERMEDIATE', 22.5, TRUE);
