# Bellion Network - Installation Guide

## Prerequisites
- VPS or Dedicated Server
- Docker (for Pterodactyl)
- MySQL server
- Java 17+
- Pterodactyl Panel installed

## Step 1: Upload Files
- Upload the entire `Bellion-Complete-Setup/` directory to your server.
- Place all plugin jars in `plugins/`.
- Place all configuration files in `configs/`.
- Place world folders in `worlds/`.
- Place SQL schema in `database/`.

## Step 2: Database Setup
- Import `database/bellion_schema.sql` into your MySQL server.
- Create a MySQL user and grant access to the `bellion` database.

## Step 3: Pterodactyl Eggs
- Import the provided `.json` egg files into your Pterodactyl Panel.
- Create servers for each gamemode using the correct egg.
- Set environment variables (memory, jarfile, ports) as needed.

## Step 4: Configure Networking
- Assign unique ports for each server (see `config.yml` and `server.properties`).
- Ensure all servers are on the same Docker network for BungeeCord forwarding.

## Step 5: Start Servers
- Use the scripts in `scripts/` to start all servers or individual ones.
- Monitor logs for errors.

## Step 6: Final Checks
- Test server switching, economy, permissions, and cross-server features.
- Ensure all plugins are loaded and working.

## Step 7: Backups & Maintenance
- Use `backup.sh` and `maintenance.sh` in `scripts/` for regular backups and updates.

## Support
- For issues, consult the documentation in `documentation/` or contact the Bellion team.