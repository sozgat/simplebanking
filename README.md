# Simple Banking

## Installation Guide
Simple Bank Application can run on Docker easily. Please follow below commands on your terminal.

```bash
git clone https://github.com/sozgat/simplebanking.git
cd simplebanking
./gradlew build 
docker-compose up --build
```

You can access Swagger Docs via http://localhost:8080/swagger-ui.html

## Results of Test Cases - Test Coverage

![alt text](https://www.kampuskod.com/wp-content/uploads/2021/12/simplebanking-code-coverage.png)
If you want to run test classes in your IDE, you have to remove below command in **test field** in **build.gradle**.

```bash
exclude '**/*'
```

## Java project run args for IDE
If you want to run project on your IDE, please add these environment variables.

| ARG             | Description  | Example |
|-------------------|----------|----------|
| MYAPP_JDBC_USER  | Database username | root
| MYAPP_JDBC_URL   | Database hostname   | jdbc:postgresql://localhost:5432/simplebanking
| MYAPP_JDBC_PASS   | Database password  | root
