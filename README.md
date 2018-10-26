![Cloudopt Next](https://github.com/cloudoptlab/cloudopt-next/raw/master/logo.png)

[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin) [![Apache Licenses Badge](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Twitter Badge](https://img.shields.io/twitter/url/http/shields.io.svg?style=social&logo=twitter)](https://twitter.com/CloudoptLab)


Cloudopt-logger is an extensible and configurable logging framework extension based on Kotlin, supporting Java, Kotlin and Android.

![screenshot](https://github.com/cloudoptlab/cloudopt-logger/raw/master/screenshots/01.jpg)
![screenshot](https://github.com/cloudoptlab/cloudopt-logger/raw/master/screenshots/02.jpg)

Features:


- supports color log output.

- support multiple logging frameworks, such as Slf4j, Log4j, and so on.

- easy to extend.

- more user-friendly and convenient to debug output.

[中文文档](https://github.com/cloudoptlab/cloudopt-logger/blob/master/README_ZH.md)

# Installation

Introduce in Maven:

````xml
  <dependency>
    <groupId>net.cloudopt.logger</groupId>
    <artifactId>cloudopt-logger</artifactId>
    <version>1.0.1</version>
  </dependency>
````
If you are using Slf4j, you need to introduce the appropriate libraries, such as:

````xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
````

## How to use

Simple to use, just introduce the Logger class. Here are a few examples:

````kotlin
package net.cloudopt.logger

import org.junit.Test

class TestCase {

    private val logger = Logger.getLogger(TestCase::class.java)

    @Test
    fun example1() {
        logger.debug("Start init....")
        logger.info("Operation successful!")
        logger.warn("The value must be not nul.")
        logger.error("Unable to acquire lock!")
    }

    @Test
    fun example2() {
        logger.info("Please Wait.... ${Colorer.blue("100")}")
        logger.info("Please Wait.... ${Colorer.yellow("200")}")
        logger.info("Please Wait.... ${Colorer.red("300")}")
    }

    @Test
    fun example3() {
        val configuration = LoggerConfiguration()
        configuration.run {
            this.color = false
        }
        Logger.configuration = configuration
        example1()
    }

    @Test
    fun example4() {
        val configuration = LoggerConfiguration()
        configuration.run {
            this.debugPrefix = "DEBUG"
            this.infoPrefix = "INFO"
            this.warnPrefix = "WARN"
            this.errorPrefix = "ERROR"
        }
        Logger.configuration = configuration
        example1()
    }
}
````

````java
public class TestJavaCase {
    private Logger logger = Logger.Companion.getLogger(TestCase.class);

    @Test
    public void example1() {
        logger.debug("Start init....");
        logger.info("Operation successful!");
        logger.warn("The value must be not nul.");
        logger.error("Unable to acquire lock!");
    }

    @Test
    public void example2() {
        logger.info("Please Wait.... " + Colorer.INSTANCE.blue("100"));
        logger.info("Please Wait.... " + Colorer.INSTANCE.yellow("200"));
        logger.info("Please Wait.... " + Colorer.INSTANCE.red("300"));
    }

    @Test
    public void example3() {
        LoggerConfiguration configuration = new LoggerConfiguration();
        configuration.setColor(false);
        Logger.Companion.setConfiguration(configuration);
        example1();
    }

    @Test
    public void example4() {
        LoggerConfiguration configuration = new LoggerConfiguration();
        configuration.setDebugPrefix("DEBUG");
        configuration.setInfoPrefix("INFO");
        configuration.setWarnPrefix("WARN");
        configuration.setErrorPrefix("ERROR");
        Logger.Companion.setConfiguration(configuration);
        example1();
    }
}
````

If you want to change the color of any output character, just wrap it in a Colorer. Eight colors are already built in.

## How to extend

Support for Slf4j is now built in, and with Slf4j you can support logback, log4j, log4j2, etc. If you need to support it directly or support other logging frameworks, you can do so by referring to Slf4jLoggerProvider.

## Follow us

You can focus on our [twitter](https://twitter.com/CloudoptLab) or is to focus on the micro letter, public the latest news we will via twitter or released to the public.

![](https://github.com/cloudoptlab/cloudopt-logger/raw/master/screenshots/qrcode.jpg)