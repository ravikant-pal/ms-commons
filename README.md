# 🧰 Spring Boot Commons Library for Microservices

A reusable, centralized library providing **annotations**, **enums**, **models**, **common exceptions**, and other shared components to support consistency and code reuse across Spring Boot-based microservices.

---

## 📌 Overview

This project is designed to serve as a **shared dependency** for multiple microservices within a distributed architecture. By centralizing commonly used artifacts, it promotes:

- Code consistency across services
- Reduced duplication
- Better maintainability
- Faster development cycles

---

## 🚀 Features

✅ Custom annotations (e.g., validation, logging, security)  
✅ Shared enums for status codes, error types, environments, etc.  
✅ Base response & error models for unified API structure  
✅ Common exceptions with standardized error handling  
✅ Utility classes (e.g., string utils, date/time utils)  
✅ Global constants  
✅ Fully compatible with Maven and Gradle-based Spring Boot projects

---

## 📦 Installation

### Maven

```xml
<dependency>
    <groupId>com.triton</groupId>
    <artifactId>ms-commons</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.triton:ms-commons<:0.0.1-SNAPSHOT'
```

> 🔁 This library must be published to your Maven/Nexus repository or GitHub Packages for other services to consume it.

---

## 🛠️ Modules Breakdown

| Module         | Description |
|----------------|-------------|
| `annotations`  | Custom annotations for logging, security, etc. |
| `enums`        | Shared enums like `Status`, `ErrorCode`, `EnvironmentType` |
| `models`       | Common request/response wrappers, DTOs, and pagination models |
| `exceptions`   | Custom base and application-level exceptions |
| `utils`        | Utility classes for string, date, JSON operations |
| `constants`    | Centralized constants used across services |

---

## 🔧 Usage Examples

### ✅ Using a Shared Enum

```java
import com.triton.mscommons.enums.ApplicationEnvironment;

public class YourClass {
    private ApplicationEnvironment env; // DEV, QA, STG and PROD
}
```

### ✅ Throwing a Common Exception

```java
import com.triton.mscommons.exceptions.ResourceNotFoundException;

throw new ResourceNotFoundException("User not found with ID: " + id);
```

### ✅ Using a Common Response Model

```java
import com.triton.commons.models.BaseResponse;

return BaseResponse.success(userData);
```

---

## 📁 Project Structure

```
ms-commons/
│
├── src/main/java/com/triton/mscommons/
│   ├── annotations/
│   ├── enums/
│   ├── models/
│   ├── exceptions/
│   ├── utils/
│   └── constants/
│
├── pom.xml
└── README.md
```

---

## 🧪 Testing

This library includes unit tests for core modules using **JUnit 5** and **Mockito**. You can run tests via:

```bash
./mvnw test
```

or

```bash
./gradlew test
```

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot 3+
- Maven / Gradle
- JUnit 5
- Mockito

---

## 🛡️ License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**[Ravikant Pal]**  
Backend Developer | Java & Spring Boot Enthusiast  
[LinkedIn](https://linkedin.com/in/ravikant-pal) • [GitHub](https://github.com/ravikant-pal)

---

## 🌟 Contribute / Feedback

Have suggestions or want to contribute? Feel free to [open an issue](https://github.com/ravikant-pal/ms-commons/issues) or submit a pull request!
