## Ubuntu下操作

### 安装jdk1.8

    $sudo apt-get install python-software-properties
    
    $sudo apt-get install software-properties-common
    
    $sudo add-apt-repository ppa:webupd8team/java
    
    $sudo apt-get update
    
    $sudo apt-get install oracle-java8-installer
    
    $sudo java -version

### 安装maven

    $sudo apt-get install maven
    
    
### 下载 alipay-sdk    

    wget http://12832846.d.yyupload.com/down/12832846/alipay-sdk-java20170411150054.jar

### 将 alipay-sdk 添加到本地mvn库中

    mvn install:install-file -DgroupId=com.alipay -DartifactId=sdk-java -Dversion=20170411150054 -Dpackaging=jar -Dfile=alipay-sdk-java20170411150054.jar

### pom中添加alipay-sdk

    <dependency>
         <groupId>com.alipay</groupId>
         <artifactId>sdk-java</artifactId>
         <version>20170411150054</version>
    </dependency>

### 执行

    mvn spring-boot:run
