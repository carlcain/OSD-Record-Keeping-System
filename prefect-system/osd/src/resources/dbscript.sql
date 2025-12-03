DROP USER rcosd CASCADE;

CREATE USER rcosd IDENTIFIED BY Changeme0;
ALTER USER rcosd QUOTA UNLIMITED ON DATA;
ALTER USER rcosd QUOTA UNLIMITED ON USERS;
GRANT CREATE SESSION TO rcosd WITH ADMIN OPTION;
GRANT CONNECT TO rcosd;
ALTER SESSION SET current_schema = rcosd;
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE person CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE prefect CASCADE CONSTRAINTS;
DROP TABLE department_head CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;
DROP TABLE guardian CASCADE CONSTRAINTS;
DROP TABLE offense CASCADE CONSTRAINTS;
DROP TABLE disciplinaryAction CASCADE CONSTRAINTS;
DROP TABLE violation CASCADE CONSTRAINTS;
DROP TABLE appeal CASCADE CONSTRAINTS;

COMMIT;


-- LOGIN ENTITY

CREATE TABLE users (
                       userID VARCHAR(10) PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       userPassword VARCHAR(100) NOT NULL,
                       userRole VARCHAR(20) NOT NULL);

-- PERSON ENTITY

CREATE TABLE person (
                        personID VARCHAR(10) PRIMARY KEY,
                        lastName VARCHAR(50) NOT NULL,
                        firstName VARCHAR(100) NOT NULL);

-- DEPARTMENT & HEAD

CREATE TABLE department_head (
                                 departmentheadID VARCHAR(10) PRIMARY KEY,
                                 userID VARCHAR(10),
                                 personID VARCHAR(10),
                                 departmentID VARCHAR(10)
);

CREATE TABLE department (
                            departmentID VARCHAR(10) PRIMARY KEY,
                            departmentname VARCHAR(100),
                            departmentheadID VARCHAR(10)
);

-- STUDENT

CREATE TABLE student (
                         studentID VARCHAR(10) PRIMARY KEY,
                         userID VARCHAR(10),
                         personID VARCHAR(10),
                         surname VARCHAR(30),
                         firstname VARCHAR(50),
                         middlename VARCHAR(30),
                         studentLevel VARCHAR(30),
                         section VARCHAR(50),
                         departmentID VARCHAR(10)
);

-- PREFECT

CREATE TABLE prefect (
                         prefectID VARCHAR(10) PRIMARY KEY,
                         userID VARCHAR(10),
                         personID VARCHAR(10),
                         departmentID VARCHAR(10)
);


-- GUARDIAN
CREATE TABLE guardian (
                          guardianID VARCHAR(10) PRIMARY KEY,
                          personID VARCHAR(10),
                          contactnumber VARCHAR(20),
                          relationship VARCHAR(50),
                          studentID VARCHAR(10)
);

-- OFFENSE

CREATE TABLE offense (
                         offenseID VARCHAR(10),
                         offense VARCHAR(100),
                         type VARCHAR(5),
                         remarks VARCHAR(500),
                         PRIMARY KEY (offenseID)
);

-- DISCIPLINARY ACTION

CREATE TABLE disciplinaryaction (
                                    actionID VARCHAR(10),
                                    action VARCHAR(100),
                                    description VARCHAR(500),
                                    PRIMARY KEY (actionID)
);

-- VIOLATION

CREATE TABLE violation (
                           violationID VARCHAR(10),
                           studentID VARCHAR(10),
                           prefectID VARCHAR(10),
                           offenseID VARCHAR(10),
                           Dateofviolation DATE,
                           actionID VARCHAR(10),
                           Dateofresolution DATE,
                           Remarks VARCHAR(500),
                           status VARCHAR(30),
                           PRIMARY KEY (violationID)
);

-- APPEAL

CREATE TABLE appeal (
                        appealID VARCHAR(10),
                        violationID VARCHAR(10),
                        studentID VARCHAR(10),
                        message VARCHAR(500),
                        datefiled DATE,
                        status VARCHAR(20),
                        PRIMARY KEY (appealID)
);

ALTER TABLE department_head ADD CONSTRAINT FK_DEPTHEAD_USER FOREIGN KEY (userID) REFERENCES users(userID);
ALTER TABLE department_head ADD CONSTRAINT FK_DEPTHEAD_PERSON FOREIGN KEY (personID) REFERENCES person(personID);
ALTER TABLE department ADD CONSTRAINT FK_DEPARTMENT_HEAD FOREIGN KEY (departmentheadID) REFERENCES department_head(departmentheadID);
ALTER TABLE student ADD CONSTRAINT FK_STUDENT_USER FOREIGN KEY (userID) REFERENCES users(userID);
ALTER TABLE student ADD CONSTRAINT FK_STUDENT_PERSON FOREIGN KEY (personID) REFERENCES person(personID);
ALTER TABLE student ADD CONSTRAINT FK_STUDENT_DEPARTMENT FOREIGN KEY (departmentID) REFERENCES department(departmentID);
ALTER TABLE prefect ADD CONSTRAINT FK_PREFECT_USER FOREIGN KEY (userID) REFERENCES users(userID);
ALTER TABLE prefect ADD CONSTRAINT FK_PREFECT_PERSON FOREIGN KEY (personID) REFERENCES person(personID);
ALTER TABLE prefect ADD CONSTRAINT FK_PREFECT_DEPARTMENT FOREIGN KEY (departmentID) REFERENCES department(departmentID);
ALTER TABLE guardian ADD CONSTRAINT FK_GUARDIAN_STUDENT FOREIGN KEY (studentID) REFERENCES student(studentID);
ALTER TABLE guardian ADD CONSTRAINT FK_GUARDIAN_PERSON FOREIGN KEY (personID) REFERENCES student(personID);
ALTER TABLE violation ADD CONSTRAINT FK_VIOLATION_STUDENT FOREIGN KEY (studentID) REFERENCES student(studentID);
ALTER TABLE violation ADD CONSTRAINT FK_VIOLATION_PREFECT FOREIGN KEY (prefectID) REFERENCES prefect(prefectID);
ALTER TABLE violation ADD CONSTRAINT FK_VIOLATION_OFFENSE FOREIGN KEY (offenseID) REFERENCES offense(offenseID);
ALTER TABLE violation ADD CONSTRAINT FK_VIOLATION_ACTION FOREIGN KEY (actionID) REFERENCES disciplinaryaction(actionID);
ALTER TABLE appeal ADD CONSTRAINT FK_APPEAL_VIOLATION FOREIGN KEY (violationID) REFERENCES violation(violationID);
ALTER TABLE appeal ADD CONSTRAINT FK_APPEAL_STUDENT FOREIGN KEY (studentID) REFERENCES student(studentID);

-- LOGIN VALUES

INSERT INTO users (userID, username,userPassword, userRole) VALUES (1001, 'wilrow123', 'BAYONA', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1002, 'cj123', 'CAIN', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1003, 'mark123', 'CAMAMA', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1004, 'zen22', 'CRUZ', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1005, 'angel123', 'DEGALA', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1006, 'geo123', 'DEROJAS', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1007, 'keith123', 'QUEVADA', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1008, 'lian123', 'REYES', 'STUDENT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1009, 'jed123', 'BELARDO', 'DEPARTMENT-HEAD');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1010, 'wen123', 'DEMETILLO', 'DEPARTMENT-HEAD');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1011, 'danny123', 'MONTANO', 'DEPARTMENT-HEAD');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1012, 'jun123', 'CADORNA', 'PREFECT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1013, 'anano123','PANTILANAN', 'PREFECT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1013, 'allana123','PACIFICO', 'PREFECT');
INSERT INTO users (userID, username,userPassword, userRole) VALUES (1014, 'admin', 'ADMIN', 'ADMIN');

-- department & HEAD

INSERT INTO department_head (departmentHeadID, departmentID) VALUES (1009, 'jhs-3001');
INSERT INTO department_head (departmentHeadID, departmentID) VALUES (1010, 'shs-3002');
INSERT INTO department_head (departmentHeadID, departmentID) VALUES (1011, 'ct-3003');

-- DEPARTMENT

INSERT INTO department (departmentID, departmentName, departmentheadID) VALUES ('jhs-3001', 'Junior HighSchool Department', '1009');
INSERT INTO department (departmentID, departmentName, departmentheadID) VALUES ('shs-3002', 'Senior HighSchool Department', '1010');
INSERT INTO department (departmentID, departmentName, departmentheadID) VALUES ('ct-3003', 'College Department', '1011');

--STUDENT VALUES
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1001', 'Bayona', 'Wilrow', 'Reosa', 'Grade-8', 'St.Hannibal', 'jhs-3001');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1002', 'Cain', 'Carl Justine', 'Dela Cruz', 'Grade-7', 'St. Anthony', 'jhs-3001');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1003', 'Camama', 'Mark Joshua', 'Reyes', 'Grade-11', 'St. Rita', 'shs-3002');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1004', 'Cruz', 'John Zenith', 'Pasion', 'Grade-11', 'St. Rita', 'shs-3002');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1005', 'De Gala', 'Angel Lowyza', 'Resurreccion', 'Grade-12', 'St. Anne', 'shs-3002');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1006', 'De Rojas', 'Geoffrey Allen', 'Villaueva', '1st Year', 'IT101', 'ct0-3003');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1007', 'Quevada', 'Keith Jasper', 'Brioso', '2nd Year', 'IT301', 'ct0-3003');
INSERT INTO student (studentID, surname, firstname, middlename,studentlevel, section, departmentID ) VALUES ('1008', 'Reyes', 'Leeane Glazel', 'Nialda', '4th Year', 'IT701', 'ct0-3003');

--PREFECT VALUES
INSERT INTO prefect (prefectID, departmentID ) VALUES (1012, 'jhs-3001');
INSERT INTO prefect (prefectID, departmentID) VALUES (1014, 'shs-3002');
INSERT INTO prefect (prefectID, departmentID) VALUES (1015, 'ct-3003');

--GUARDIAN VALUES
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Wilson Bayona', 0912-345-6789, 'Father', 1001);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Emilyn Cain', 0912-555-6789, 'Mother', 1002);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Belinda Camama', 0911-222-5555, 'Mother', 1003);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Edith Pasion', 0922-777-9988, 'Mother', 1004);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Vilma De Gala', 0933-333-3333, 'Mother', 1005);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Lebron James', 0978-343-1212, 'Father', 1006);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Rochelle Quevada', 0988-999-3453, 'Mother', 1007);
INSERT INTO guardian (guardianName, contactnumber, relationship, studentID ) VALUES ('Ghe Reyes', 0967-876-5152, 'Mother', 1008);

--OFFENSE
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-001', 'Vaping', 'Major Offense', 'Bringing vape');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-002', 'Punching', 'Major Offense', 'Punching another student');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-003', 'Stealing', 'Major Offense', 'Stealing things from another student');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-004', 'Bullying', 'Major Offense', 'Student delivers disrespectful messages to another student that includes threats and intimidation');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-005', 'PDA', 'Major Offense', 'Student engages in inappropriate consensual verbal and/or physical gestures/contact, of a sexual nature to another student.');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-006', 'Cheating', 'Major Offense', 'Student deliberately violates rules or engages in plagiarism or copying anothers work');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-007', 'Skip Class', 'Major Offense', 'Student leaves or misses class without permission');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-008', 'Tardiness', 'Major Offense', 'Student is repeatedly late to class');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-009', 'Technology Violation', 'Major Offense', 'Inappropriate use of gadgets');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-010', 'Use/Posession of Alcohol', 'Major Offense', 'Student is in possession of or is using alcohol');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-011', 'Use/Possession of Drugs', 'Major Offense', 'Student is in possession of or is using illegal drugs');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-012', 'Use/Possession of Tobacco', 'Major Offense', 'Student is in possession of or is using tobacco');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-013', 'Use/Possession of Weapons', 'Major Offense', 'Student is in possession of knives or gun or other object readily capable of causing bodily harm');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-014', 'Use/Possession of Drugs', 'Major Offense', 'Student is in possession of or is using illegal drugs');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-015', 'Disrespect', 'Minor Offense', 'Student engages in brief or low-intensity failure to respond to adult requests');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-016', 'Dress Code', 'Minor Offense', 'Student wears clothing that not within the dress code guidelines');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-017', 'Inappropriate Language', 'Minor Offense', 'Student engages in low-intensity instance of appropriate language');
INSERT INTO offense (offenseID, offense, type, remarks) VALUES ('OFF-018', 'Dress Code', 'Minor Offense', 'Student wears clothing that not within the dress code guidelines');

--DISCIPLINARY ACTION
INSERT INTO disciplinaryaction (actionID, action, description) VALUES ('D-001', 'Community Service', 'A service component where the student spends time serving in the community meeting actual needs');
INSERT INTO disciplinaryaction (actionID, action, description) VALUES ('D-002', 'Probation', 'a warning status given to a student whose academic performance or behavior falls below the institutions standards');

--VIOLATION
INSERT INTO violation (violationID, studentID, prefectID, offenseID, Dateofviolation, actionID, Dateofresolution, Remarks, status) VALUES ('V-001', '1001', 1012, 'OFF-002', 07-28-2025, 'D-001', 08-04-2025, '8 hours of Community service', 'IN PROGRESS');
INSERT INTO violation (violationID, studentID, prefectID, offenseID, Dateofviolation, actionID, Dateofresolution, Remarks, status) VALUES ('V-002', '1002', 1012, 'OFF-005', 10-01-2025, 'D-001', 10-04-2025, '4 hours of Community service', 'IN PROGRESS');
INSERT INTO violation (violationID, studentID, prefectID, offenseID, Dateofviolation, actionID, Dateofresolution, Remarks, status) VALUES ('V-003', '1003', 1012, 'OFF-007', 10-20-2025, 'D-001', 10-25-2025, '10 hours of Community service', 'IN PROGRESS');

--APPEAL
INSERT INTO appeal (appealID, violationID, studentID, message, datefiled, status) VALUES ('APP-001', 'V-001', '1001', 'I did not punch my classmate', 07-29-2025, 'Not Resolve');
INSERT INTO appeal (appealID, violationID, studentID, message, datefiled, status) VALUES ('APP-002', 'V-002', '1002', 'We are simply holding hands', 10-03-2025, 'Resolve');
INSERT INTO appeal (appealID, violationID, studentID, message, datefiled, status) VALUES ('APP-003', 'V-003', '1003', 'I thought that our teacher will not attend the class', 10-22-2025, 'Not Resolve');

commit;







