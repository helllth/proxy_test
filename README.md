# proxy_test
Test proxy NTLM authentication with jersey-apache-client4

build a jar with all dependencies with:

`mvn clean compile assembly:single`

start the tester with:

`java -jar target/proxyTest-1.0-SNAPSHOT-jar-with-dependencies.jar [proxy-host]:[proxy-port] [domain] [user] [pass]`

Example: 

`java -jar target/proxyTest-1.0-SNAPSHOT-jar-with-dependencies.jar http://proxy-host:8080 home me secret`





