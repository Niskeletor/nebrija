#!/bin/bash

# Configuración
DB_USER="usuario"
DB_PASSWORD="contraseña"
DB_NAME="nombre_base_de_datos"
BACKUP_DIR="/ruta/donde/guardar/copias"

# Hora actual
TIMESTAMP=$(date +"%F")

# Crear la copia de seguridad
mysqldump --user=$DB_USER --password=$DB_PASSWORD $DB_NAME > $BACKUP_DIR/$DB_NAME-$TIMESTAMP.sql

# En el caso de las copias integrales
if [ "$(date +"%u")" -eq 7 ]; then
  tar -czf $BACKUP_DIR/$DB_NAME-$TIMESTAMP.tar.gz $BACKUP_DIR/$DB_NAME-$TIMESTAMP.sql
fi

# Eliminar la copia en formato SQL si existe la copia integral
if [ -f $BACKUP_DIR/$DB_NAME-$TIMESTAMP.tar.gz ]; then
  rm $BACKUP_DIR/$DB_NAME-$TIMESTAMP.sql
fi
