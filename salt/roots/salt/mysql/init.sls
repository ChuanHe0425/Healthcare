python-mysqldb:
  pkg:
    - installed

mysql-client:
  pkg:
    - installed
    - name: mysql-client

mysql-server:
  pkg:
    - installed
    - name: mysql-server
  service:
    - running
    - name: mysql
    - require:
      - pkg: mysql-server
      - pkg: python-mysqldb

mysql-db:
  mysql_user:
    - present
    - name: root
    - password: root
    - host: localhost
    - require:
          - pkg: python-mysqldb
          - pkg: mysql-client
          - service: mysql
/etc/mysql/my.cnf:
  file:
    - managed
    - source: salt://mysql/files/my.cnf
    - template: jinja
    - mode: 644
    - require:
        - pkg: mysql-server
    - defaults:
        port: 3306
        bind_address: 127.0.0.1
        
/etc/mysql/conf.d:
  file:
    - directory
    - dir_mode: 0755
    - mode: 0644

/etc/mysql/conf.d/server-encoding-and-collation.cnf:
  file:
    - managed
    - mode: 0644
    - source: salt://mysql/files/server-encoding-and-collation.cnf
    - require:
      - pkg: mysql-server
    - watch_in:
      - service: mysql-server
    - require_in:
      - file: /etc/mysql/conf.d

/etc/mysql/conf.d/default-table-engine.cnf:
  file:
    - managed
    - mode: 0644
    - source: salt://mysql/files/default-table-engine.cnf
    - require:
      - pkg: mysql-server
    - watch_in:
      - service: mysql-server
    - require_in:
      - file: /etc/mysql/conf.d