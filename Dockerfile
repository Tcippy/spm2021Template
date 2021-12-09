FROM tomcat

COPY /target/spm2021.war \Program Files\Apache Software Foundation\Tomcat 9.0\webapps

CMD ["catalina.sh", "run"] 
