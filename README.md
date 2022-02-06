<img src="sparta.jpg" align="right" width="75" />

# Sort Manager Application (Java)
> By: Sami Zirak - Junior Java SDET Consultant | [Portfolio](https://samiz.dev/) | [GitHub](https://github.com/samizirakgamedev) | [LinkedIn](https://www.linkedin.com/in/sami-zirak-dezfouly/) | [Twitter](https://twitter.com/SamiZirakDev) |
> 
The Sort Manager program will be able to take in an array of **'ints'** and sort it using different sort algorithms. 
This project is being created as part of my ongoing training as a Junior Java SDET @ [Sparta Global](https://www.spartaglobal.com/).
### Table Of Contents ###
+ [Software & Dependencies](#software---dependencies)
+ [Planned Project Phases](#planned-project-phases)
  - [Phase 1](#phase-1)
  - [Phase 2](#phase-2)
  - [Phase 3](#phase-3)
  - [Phase 4](#phase-4)
### Software & Dependencies ###
* **IntelliJ Community Edition** [Version 2021.3.2](https://www.jetbrains.com/idea/download/#section=windows)
* **JDK** [Version 17.0.2](https://jdk.java.net/17/)
* **Apache Maven**
  * _**Note:** This dependency can be imported using IntelliJ._
  * _Go to **"File" > "New Project"** and then selecting **"Maven"** as the project structure._
* **JUnit Jupiter API** [Version 5.8.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.2)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
    </dependency>
```
* **Log4J Core** [Version 2.17.1](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core/2.17.1)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.17.1</version>
    </dependency> 
```
### Planned Project Phases ###
#### Phase 1 ####
I will be implementing the basic functionality for a program which will take an array of ints and sort that array firstly using a bubble sort algorithm and then a merge sort algorithm.
#### Phase 2 ####
I will be updating the project so that it implements design patterns like the [MVC](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) and [Factory](https://en.wikipedia.org/wiki/Factory_method_pattern) design pattern
as well as other principles of [OOP](https://en.wikipedia.org/wiki/Object-oriented_programming) like [SOLID](https://en.wikipedia.org/wiki/SOLID).
#### Phase 3 ####
I will be updating the project to include logging code using Log4j. This will require me to implement a properties file that Log4j can read. I will be creating logs at different levels and fully testing the resulting output through having the output going to a log file created in the project's "**resources**" directory.
#### Phase 4 ####
TBD - Will be updated as project progresses.
