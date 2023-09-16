CREATE TABLE member (
                        grade       CHAR(20) ,
                        name        VARCHAR(20) ,
                        password    VARCHAR(64) ,
                        studentId   CHAR(8) ,
                        phone       CHAR(11) ,
                        email       VARCHAR(30) ,
                        department  CHAR(20) ,
                        division    CHAR(20) ,
                        PRIMARY KEY(phone) ,
                        PRIMARY KEY(email) ,
                        PRIMARY KEY(studentId)
);