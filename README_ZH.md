![Cloudopt Next](https://github.com/cloudoptlab/cloudopt-next/raw/master/logo.png)

[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin) [![Apache Licenses Badge](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Twitter Badge](https://img.shields.io/twitter/url/http/shields.io.svg?style=social&logo=twitter)](https://twitter.com/CloudoptLab)


cloudopt-logger是一个基于Kotlin开发的可扩展、可配置的日志框架扩展，支持Java、Kotlin及Android。

![screenshot](https://github.com/cloudoptlab/cloudopt-logger/raw/master/screenshots/01.jpg)
![screenshot](https://github.com/cloudoptlab/cloudopt-logger/raw/master/screenshots/02.jpg)

具有以下特性：

- 支持彩色的日志输出。
- 支持多种日志框架，如Slf4j、Log4j等等。
- 易于扩展。
- 更人性化和方便调试的输出。

[中文文档](https://github.com/cloudoptlab/cloudopt-logger/blob/master/README_ZH.md)

# 安装

在Maven中引入：

````xml
<dependency>
    <groupId>net.cloudopt.logger</groupId>
    <artifactId>cloudopt-logger</artifactId>
    <version>1.0.1</version>
</dependency>
````

如果您是使用Slf4j的话，需要引入相应的库，如：

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

## 如何使用

使用起来非常简单，只需要引入Logger类即可，下面是几个示例：

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

如果您想要修改任何输出的字符的颜色，只需要通过Colorer.xxx的方法包裹即可。目前已经内置了八种颜色。

## 如何扩展

目前已经内置了对Slf4j的支持，通过Slf4j可以支持logback、log4j、log4j2等等，如果您需要直接支持或者支持其他日志框架，您可以参考Slf4jLoggerProvider，自行实现。

## 关注我们

您可以关注我们的[推特](https://twitter.com/CloudoptLab)或者是关注我们的微信公众号，最新消息我们会通过推特或者公众号发布。

![](https://github.com/cloudoptlab/cloudopt-logger/raw/master/screenshots/qrcode.jpg)
