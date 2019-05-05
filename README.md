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


Hibernate CRUD app- Create, Read, Update, Delete

HQL - Hibernate query language

Hibernate Advanced Mappingss - Will have multiple tables and relationships between tables
3 types
1- 1 to 1
2 -1 to many 
3- many to many

Cascade - apply same operations to related entity
eg 1- if we save instructor then we also save instrctor detail
eg 2- CASCADE DELETE - if we delete instructor then we also delete instructor detail

No cascade in case of students to course and viceversa

When we retrieve data there is idea of Eager(will retrieve everything) vs Lazy loading(will retrirvr on request)

Hibernate 1 to 1 mapping
Dev process
1- Defien db tables
2- create InstructorDetail class
3- create instructor class
4-create main app

Main purpose of foreign key is to preserve relationship between tables and Referential Integrity which is it prevents operations that would destroy relationship. Also ensure valid data is inserted into foregin key column, can only contain valid refrence to primary key in other table

CASCADE TYPE(Eg Instructor to Instructor detail). By default no operations are cascaded
1- Persisit If entity is persisted/saved then related entity will aslo be saved
2- Remove  If entity is removed/delete then related entity will aslo be deleted
3- Refresh  If entity is refreshed then related entity will aslo be refresh
4- detach
5 Merge
6- ALL - all of above cascae type together

2- delete an instructor

Hibernate 1 to 1 bidirectional (If we load InstructionalDetail object then we want to get assosciated Instructor)

Dev process
1-Make updates to InstructionalDetail class
2- add new field to refrence Instructor
3-add gertter and setter methods for instructor
4- add @OneToOne

HIBERNATE ONE TO MANY(An instructor can have many courses)
Many to 1 (many courses map to 1 instructor)

Dev process
1- Prep work - define db tables
2- create course class
30 update instructor clas
4-create main app

Prefer lazy loadiing instead of eager loading to avoid performance issue. We can define with FETCH type (eg fetch= FETCHType.LAZY). For lazy data hibernate session needs to b open to fetch data on demand, if closed then throw exception.

2 options to retrieve lazy data
1-sessiom.get and call appropriate getter methods
2- hibernate query langugae using HQL

Default Fetch types
1- @1to1 - FetchType.Eager
2- mto1 Eager
3- 1 to M Lazy
4- M-m Lazy

1 to Many Unidirection support(A course can have many reviews, if course is deleted then review shld also be deleted)

Many 2 Many(Course can have many students and students can sign for many courses)

JOIN table - provides mapping between 2 tables
