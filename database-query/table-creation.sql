use magazinedb;

CREATE TABLE Faculties
(
  Id   int(10) NOT NULL AUTO_INCREMENT,
  Name text    NOT NULL,
  PRIMARY KEY (Id)
);
CREATE TABLE Submissions
(
  Id              int(10)    NOT NULL AUTO_INCREMENT,
  Path            text       NOT NULL,
  Author_Id       int(10)    NOT NULL,
  `Date`          date       NOT NULL,
  Year_Id         int(10)    NOT NULL,
  Has_Sent_Notice tinyint(1) NOT NULL,
  Comment         mediumtext,
  Is_Selected     tinyint(1) NOT NULL,
  PRIMARY KEY (Id)
);
CREATE TABLE Users
(
  Id               int(10)    NOT NULL AUTO_INCREMENT,
  Role             tinytext   NOT NULL,
  Faculty_Id       int(10),
  Has_Accepted_TOC tinyint(1) NOT NULL,
  Email            text       NOT NULL,
  PRIMARY KEY (Id)
);
CREATE TABLE Years
(
  Id                int(10) NOT NULL AUTO_INCREMENT,
  StartDate         date    NOT NULL,
  EndDate           date    NOT NULL,
  Entry_ClosureDate date    NOT NULL,
  PRIMARY KEY (Id)
);
ALTER TABLE Submissions
  ADD CONSTRAINT FKSubmission567178 FOREIGN KEY (Author_Id) REFERENCES Users (Id);
ALTER TABLE Users
  ADD CONSTRAINT FKUsers196061 FOREIGN KEY (Faculty_Id) REFERENCES Faculties (Id);
ALTER TABLE Submissions
  ADD CONSTRAINT FKSubmission665597 FOREIGN KEY (Year_Id) REFERENCES Years (Id);
