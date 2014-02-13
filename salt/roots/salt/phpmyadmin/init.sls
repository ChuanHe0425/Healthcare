phpmyadmin:
    pkg:
        - installed
        - name: phpmyadmin
        - require:
            - pkg: php5
            - pkg: apache2

phpmyadmin_apache:
    file:
        - managed
        - source: salt://phpmyadmin/phpmyadmin.conf
        - name: /etc/apache2/sites-available/phpmyadmin
        - user: root
        - group: root
        - template: jinja
        - mode: 644
        - defaults:
            server_name: 
            server_admin: admin@server.dev
            allow_from: 
            logs_dir: /home/vagrant
        - require:
            - pkg: phpmyadmin
            - pkg: apache2

phpmyadmin_apache-enable:
    file:
        - symlink
        - name: /etc/apache2/sites-enabled/phpmyadmin
        - target: /etc/apache2/sites-available/phpmyadmin
        - require:
            - file: phpmyadmin_apache

extend:
    apache2:
        service:
            - running
            - watch:
                - file: /etc/apache2/sites-enabled/phpmyadmin
                - pkg: phpmyadmin