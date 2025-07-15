#!/bin/bash
# Bellion automatic backup script
BACKUP_DIR=../backups/$(date +%Y-%m-%d_%H-%M-%S)
mkdir -p $BACKUP_DIR
cp -r ../plugins $BACKUP_DIR/
cp -r ../configs $BACKUP_DIR/
cp -r ../worlds $BACKUP_DIR/
cp -r ../database $BACKUP_DIR/
echo "[Bellion] Backup completed at $BACKUP_DIR"