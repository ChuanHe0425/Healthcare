apache2:
  pkg:
    - installed
  service:
    - running
    - reload: True
    - watch:
      - file: /etc/apache2/apache2.conf


/etc/apache2/apache2.conf:
  file.managed:
    - source: salt://apache2/files/apache2.conf

/etc/apache2/sites-available/default:
  file.managed:
    - source: salt://apache2/files/default
