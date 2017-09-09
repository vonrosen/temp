# temp

Requirements
------
* Install JDK 1.7
* Install Maven


Install
------
Clone this repo four times, e.g.

    git clone git@github.com:vonrosen/temp.git

Run
------
* Build and Test

    mvn install

* Test

    mvn test

* Print table of primes to 10

    java -cp target/classes/ fundingcircle.PrintPrimes 10

* Print table of primes to N

    java -cp target/classes/ fundingcircle.PrintPrimes N
