tomcat7:
    pkg:
        - installed
    service:
        - running
        - reload: True
        - watch:
          - file: /etc/tomcat7/web.xml
          - file: /etc/tomcat7/server.xml
          - file: /etc/tomcat7/context.xml
          - file: /etc/tomcat7/tomcat-users.xml
          - file: /etc/tomcat7/catalina.properties
          - file: /etc/tomcat7/logging.properties


/etc/tomcat7/web.xml:
    file.managed:
        - source: salt://tomcat7/files/web.xml
        
/etc/tomcat7/server.xml:
    file.managed:
        - source: salt://tomcat7/files/server.xml
        
/etc/tomcat7/context.xml:
    file.managed:
        - source: salt://tomcat7/files/context.xml
        
/etc/tomcat7/tomcat-users.xml:
    file.managed:
        - source: salt://tomcat7/files/tomcat-users.xml
        
/etc/tomcat7/catalina.properties:
    file.managed:
        - source: salt://tomcat7/files/catalina.properties
        
/etc/tomcat7/logging.properties:
    file.managed:
        - source: salt://tomcat7/files/logging.properties
