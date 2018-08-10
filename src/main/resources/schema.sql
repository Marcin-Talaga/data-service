DROP TABLE user if exists;
CREATE TABLE user
(
    user_Id int NOT NULL,
    user_Name varchar(50) NOT NULL,
    PRIMARY KEY (user_Id)
 );
DROP TABLE course if exists;
 CREATE TABLE course
 (
     course_Id int NOT NULL,
     course_Name varchar(64) NOT NULL,
     grade char(1) NOT NULL,
     user_Id int NOT NULL,
     PRIMARY KEY (course_Id),
     FOREIGN KEY (user_Id) REFERENCES user (user_Id),
  );
