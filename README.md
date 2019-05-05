# Hibernate-Relationship-Mapping


1. Hibernate  is a framework for persisting/saving java objects in a database.

2. Hibernate is database independent (Can work with any database like oracle,mysql,db2,sql server ,etc.) 

3. Using hibernate you won't worry about writing database specific queries and syntax. It's provides HQL (Hibernate Query Language), which is compatible with any database server.

# Benefits

1. Handles all low level sql 

2. Minimizes the amount of jdbc code

3. Provides Object to Relatinal mapping(ORM)

4. Hibernate uses jdbc in backgroud to communicate with database. Provides easy way to map our Java objects into database tables

# Hibernate development process

1. Add hibernate config file

2. Annotate java class 

# Ways to map class to database table

1. Xml config file(legacy file)

2. Java annotations(modern, preferred)

2.1 Map class to database table

2.2 Map fields to database column

3. Develop java code to perform database operations

#  Key Classes

## SessionFactory 

1. Reads the hibernate config file.

2. Creates session object which are heavy weight object.

3. Created only once in application

## Session 

1. Wraps a jdbc connection. 

2. Main object used to save/retrieve objects 

3. Short lived object, retrieved from SessionFactory


# Hibernate Advanced Mappings (Multiple tables and relationships between them)

1. One to One

2. One to Many 

3. Many to Many

# Project

## hibernate project 

In this project all the CRUD (Create, Read, Update , Delete) operations are performed

1. CreateStudentDemo class - Creation of an object 

2. ReadStudentDemo class - Reading on the object

3. UpdateStudentDemo class - Update the object 

4. DeleteStudentDemo class - deletes an object 

5. QueryStudentDemo class- querying the object


## hb-01-one-to-one-uni (One to One mapping)

Instructor class mapped to Instructor_detail class  (unidirectional)

### Development process

1. Define database tables

2. Create InstructorDetail class

3. Create instructor class

4. Create main app

## hb-02-one-to-one-bi (One to One mapping)

Instructor_detail class mapped to Instructor class  (bi-directional)

(On loading InstructionalDetail object we want to get assosciated Instructor)

### Development process

1. Make updates to InstructionalDetail class

2. Add new field to refrence Instructor

3. Add getter and setter methods for instructor

4. Add @OneToOne annotation

## hb-eager-vs-lazy

1. While retrieving data **Eager loading** will retrieve everything while **Lazy loading** will retrieve on request

2. Lazy loadiing is preferred instead of Eager loading to avoid performance issue. 

3. We can define with FETCH type (eg fetch= FETCHType.LAZY). 

4. For lazy loading data hibernate session needs to be open to fetch data on demand, if it is closed then throws an exception.

### Options to retrieve lazy data

1. session.get and call appropriate getter methods
2. Hibernate query langugae using HQL

## hb-03-one-to-many (Many to One mapping - bidirectional)

Many to one (Many courses map to one instructor)

### Development process

1. Define database tables

2. Create course class

3. Update instructor class

4. Create main application

# hb-04-one-to-many-uni   (One to Many Unidirectional)

A Course class can have many reviews

# hb-05-many-to-many  

Course classcan have many students and students class can sign for many courses



Main purpose of foreign key is to preserve relationship between tables and Referential Integrity which is it prevents operations that would destroy relationship. Also ensure valid data is inserted into foregin key column, can only contain valid refrence to primary key in other table

# Cascade Types (Eg Instructor to Instructor detail). By default no operations are cascaded

1. Persist If entity is persisted/saved then related entity will aslo be saved

2. Remove If entity is removed/delete then related entity will aslo be deleted

3. Refresh If entity is refreshed then related entity will aslo be refresh

4. Detach

5. Merge

6. ALL (all of above cascade type together)

2- delete an instructor

Cascade - apply same operations to related entity
eg 1- if we save instructor then we also save instrctor detail
eg 2- CASCADE DELETE - if we delete instructor then we also delete instructor detail

No cascade in case of students to course and viceversa



# Default Fetch types

1. @OneToOne - FetchType.Eager

2. @ManyToOne - FetchType.Eager

3. @OneToMany - FetchType.Lazy

4. @ManyToMany - FetchType.Lazy




JOIN table - provides mapping between 2 tables
