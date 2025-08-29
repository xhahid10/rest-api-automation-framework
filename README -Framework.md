# API Framework

A comprehensive REST API testing framework built with Java, Rest Assured, TestNG, and ExtentReports for automated API testing.

## 🚀 Project Overview

This framework provides a robust solution for testing REST APIs with features like:
- **HTTP Methods Support**: GET, POST, PUT, DELETE operations
- **Data-Driven Testing**: JSON-based test data management
- **ExtentReports Integration**: Detailed HTML test reports
- **Logging**: Comprehensive logging with Log4j
- **Response Validation**: Status code and data validation
- **Maven Integration**: Easy dependency management and build process

## 📋 Prerequisites

Before running this framework, ensure you have the following installed:

- **Java JDK 8** or higher
- **Maven 3.6+**
- **JSON Server** (for local API testing) - Optional
- **IDE** (Eclipse, IntelliJ IDEA, or VS Code)

## 🛠️ Installation & Setup

### 1. Clone/Extract the Project
```bash
# If using git
git clone <repository-url>
cd API-Framework

# Or extract the zip file
unzip API-Framework.zip
cd API-Framework
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure Properties
Update the `URI.properties` file with your API endpoints:
```properties
QA_URI1=http://localhost:3000/APIStudents
```

### 4. Setup JSON Server (Optional)
For local testing, you can use JSON Server:
```bash
npm install -g json-server
json-server --watch db.json --port 3000
```

## 📁 Project Structure

```
API-Framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── api/Aug/                    # Basic Rest Assured examples
│       │   │   ├── RestAssured_1.java      # POST request example
│       │   │   ├── RestAssured_2.java      # GET request example
│       │   │   ├── RestAssured_3.java      # PUT request example
│       │   │   └── RestAssured_4.java      # DELETE request example
│       │   └── org/testing/
│       │       ├── assertions/             # Custom assertions
│       │       │   └── Assertions.java
│       │       ├── responseValidation/     # Response validation utilities
│       │       │   └── ValidateResponse.java
│       │       ├── testScripts/            # Test cases
│       │       │   ├── TC1_PostMethod.java
│       │       │   ├── TC2_GetAllMethod.java
│       │       │   ├── TC3_getParticularMethod.java
│       │       │   ├── TC4_PutMethod.java
│       │       │   └── TC5_DeleteMethod.java
│       │       ├── testSteps/              # HTTP method implementations
│       │       │   └── HTTPMethods.java
│       │       ├── trigger/                # Test execution
│       │       │   └── Runner.java
│       │       ├── utilities/              # Utility classes
│       │       │   ├── JsonHandle.java
│       │       │   ├── JsonParsingUsingOrgJson.java
│       │       │   ├── LogsCapture.java
│       │       │   ├── PropertiesHandle.java
│       │       │   └── ReportHandling.java
│       │       └── resources/              # Test data
│       │           ├── requestBody.json
│       │           └── updateRequestBody.json
│       └── resources/
├── target/                                 # Compiled classes and reports
├── test-output/                           # TestNG reports
├── pom.xml                                # Maven configuration
├── testng.xml                             # TestNG suite configuration
├── URI.properties                         # API endpoints configuration
├── RequestBody.json                       # Sample request body
├── ArrayRequestBody.json                  # Array request body
├── layout.xml                             # Log4j configuration
└── README.md                              # This file
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=TC1_PostMethod
```

### Run TestNG Suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run from IDE
- Right-click on `testng.xml` and select "Run As > TestNG Suite"
- Or run individual test classes directly

## 📊 Test Reports

After test execution, reports are generated in:
- **TestNG Reports**: `test-output/index.html`
- **ExtentReports**: `test-output/ExtentReport.html`
- **JUnit Reports**: `test-output/junitreports/`

## 🔧 Configuration Files

### URI.properties
Configure your API endpoints:
```properties
QA_URI1=http://localhost:3000/APIStudents
QA_URI2=https://api.example.com/users
```

### RequestBody.json
Sample request body for POST/PUT operations:
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "age": 30
}
```

### layout.xml
Log4j configuration for logging:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<log4j:configuration>
    <appender name="console" class="org.apache.log4j.ConsoleAppender">
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
        </layout>
    </appender>
    <root>
        <priority value="INFO"/>
        <appender-ref ref="console"/>
    </root>
</log4j:configuration>
```

## 📝 Test Examples

### Basic POST Request
```java
@Test
public void testCase1() throws IOException {
    ExtentReports report = ReportHandling.report();
    ExtentTest tc1 = report.startTest("TC1_PostMethod");
    
    Properties pr = PropertiesHandle.LoadProerties("../API-Framework/URI.properties");
    String requestBody = JsonHandle.readJson("../API-Framework/src/test/java/org/testing/resources/requestBody.json");
    
    HTTPMethods http = new HTTPMethods(pr);
    Response res = http.postmethod("QA_URI1", requestBody);
    Boolean result = ValidateResponse.statusCodeValidate(201, res);
    
    LogsCapture.takeLog("TC1_PostMethod", "status code is " + res.statusCode());
    
    if(result == true) {
        tc1.log(LogStatus.PASS, "Status code is matching");
    } else {
        tc1.log(LogStatus.FAIL, "Status code is not matching");
    }
    
    report.endTest(tc1);
    report.flush();
}
```

### GET Request with Validation
```java
@Test
public void testCase2() throws IOException {
    ExtentReports report = ReportHandling.report();
    ExtentTest tc2 = report.startTest("TC2_GetAllMethod");
    
    Properties pr = PropertiesHandle.LoadProerties("../API-Framework/URI.properties");
    HTTPMethods http = new HTTPMethods(pr);
    
    Response res = http.getAllMethod("QA_URI1");
    
    Boolean result = ValidateResponse.statusCodeValidate(200, res);
    Boolean dataresult = ValidateResponse.DataValidate("Shahid", res);
    
    if((result == true) && (dataresult == true)) {
        tc2.log(LogStatus.PASS, "Status code is matching and data is also matching");
    } else {
        tc2.log(LogStatus.FAIL, "Status code is not matching and data is not matching");
    }
    
    report.endTest(tc2);
    report.flush();
}
```

## 🔍 Key Features

### 1. HTTP Methods Support
- **POST**: Create new resources
- **GET**: Retrieve resources (all or specific)
- **PUT**: Update existing resources
- **DELETE**: Remove resources

### 2. Response Validation
- Status code validation
- Response data validation
- JSON parsing and validation

### 3. Logging
- Comprehensive logging with Log4j
- Test execution logs
- Error tracking

### 4. Reporting
- ExtentReports integration
- TestNG HTML reports
- Detailed test results

### 5. Data Management
- JSON-based test data
- Properties file configuration
- External data sources

## 🛠️ Customization

### Adding New Test Cases
1. Create a new test class in `src/test/java/org/testing/testScripts/`
2. Extend the base test structure
3. Add test methods with `@Test` annotation
4. Update `testng.xml` if needed

### Adding New HTTP Methods
1. Extend `HTTPMethods.java` class
2. Implement new method logic
3. Add validation methods if needed

### Custom Assertions
1. Add new assertion methods in `Assertions.java`
2. Use in test cases for specific validations

## 🐛 Troubleshooting

### Common Issues

1. **FileNotFoundException**: Check file paths in test cases
2. **Connection Refused**: Verify API server is running
3. **Compilation Errors**: Ensure all dependencies are installed
4. **Test Failures**: Check API responses and validation logic

### Debug Mode
Enable debug logging by updating `layout.xml`:
```xml
<priority value="DEBUG"/>
```

## 📚 Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| TestNG | 6.10 | Test framework |
| Rest Assured | 5.5.0 | API testing |
| JSON | 20231013 | JSON handling |
| ExtentReports | 2.41.2 | Test reporting |
| Log4j | 1.2.17 | Logging |

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For questions or issues:
- Create an issue in the repository
- Contact the development team
- Check the documentation

---

**Happy Testing! 🚀**
