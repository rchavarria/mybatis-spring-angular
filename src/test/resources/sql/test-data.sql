-- data for 'teachers' table
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 1');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 2');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 3');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 4');
INSERT INTO teachers VALUES (NEXT VALUE FOR teachersSeq, 'Teacher 5');

-- data for 'courses' table
INSERT INTO courses VALUES (NEXT VALUE FOR coursesSeq, 'Title 1', 'Teacher 1', 'BASIC', 12.5, TRUE);