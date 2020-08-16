#HICX Test

##Design Considerations
* Extensibility is the main concern of the design
* Testability


##Maven
This project is build using maven, so you can issue test, build, and install

##Run Test
Although test are not sufficient (per time constraints),

mvn test

##To Do
Per time constraint and considering this is not a _real_ project, some aspect have
been neglected, however it's worth mention them:

* UT aren't enought ( coverage should be ~100%), mockito was included
* Integration test are also necessary
* Static analysis tools should be included (ex: findbugs, checkstyle, etc)
* Mutation Coverage should be included (ex: https://pitest.org/)
 

##How to run 
Just build the project and execute _Processor.java_ with the directory to be process, 
test files are provided as resources on _/test/resources/_

* we asume a _processed_ dir it's already there.