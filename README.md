# Multi Datasource Configuration with Mybatis Plus
This is a template project for bootstrapping a spring boot service with 
multiple datasource and using multiple instance of mybatis mapper configuration.

## Dependency
- [x] Spring Boot 2.x.x
- [x] Java 1.8 (jdk 8)
- [x] Mybatis Plus (baomidou)
- [x] Druid (Connection Pool)
- [x] Mysql

## How to Run
- First configure a mysql instance in your localhost (if you don't already have one). You can use docker for easily
spin up a mysql instance in your localhost using the `docker-compose.yml` file provided
in the repository.
- Connect to the database instance with a mysql client run the following commands:
    ```sql
  create database test;
  use test;
  create table account(id bigint primary key auto_increment, email varchar(156) unique, name varchar(156));
  insert into account(email, name) value ('test1@test.com', 'test');
  
  create databse test2;
  use test2;
  create table post(id bigint primary key auto_increment, account_id bigint, title varchar(256), content text);
  insert into post(account_id, title, content) values (1, 'Post 1', 'This is the post one');
  ```
- Open `application.yml` file and input database credentials (If you are using the `docker-compose.yml` file provided in the repo to create teh mysql instance then you don't need to change anything)
- Run the application
- Now use a rest client to hit `http://localhost:8080/accounts` to get data from the first datasource using `test` database
- Hit `http://localhost:8080/posts` to get data with secondary datasource using `test2` database
