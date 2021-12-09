FROM tomcat

COPY /target/spm2021.war C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps

CMD ["catalina.sh", "run"] 
