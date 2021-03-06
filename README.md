# HICX Test

## Design Considerations
* Extensibility is the main concern of the design
* Testability
* Performance is not a main concern


## Maven
This project is build using maven, so you can issue test, build, and install

## Run Test
Although test are not sufficient (per time constraints),

```shell
mvn test
```

## To Do
Per time constraint and considering this is not a _real_ project, some aspect have
been neglected, however it's worth mention them:

* UT are not nearly enough ( coverage should be ~100%),  a test using mockito was included to show
 how
the design facilitate testing.
* Integration test are also necessary
* Static analysis tools should be included (ex: findbugs, checkstyle, etc)
* Mutation Coverage should be included (ex: https://pitest.org/)
* Error description should be better handled
 

## How to run 
Just build the project and execute _com.hicx.test.Processor.java_ with the directory with the 
files to be process, 
test files are provided as resources on _/test/resources/_, you can also use mvn to execute the 
procesor, but first adjust the parameters on the _pom.xml_ to you local env

```shell
 mvn clean compile exec:java
 
```

* we asume a _processed_ dir it's already there, this has only be tested on Mac OS X.