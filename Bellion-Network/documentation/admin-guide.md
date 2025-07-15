# BELLION SERVER MANAGEMENT GUIDE

## Server Startup/Shutdown Procedures
- Use the scripts in `scripts/` to start, stop, or restart all servers.
- For individual servers, use `start-server.sh <server>`, `stop-all.sh`, or `restart-server.sh <server>`.

## Player Management Commands
- `/ban <player>`: Ban a player
- `/kick <player>`: Kick a player
- `/mute <player>`: Mute a player
- `/tempban <player> <time>`: Temporarily ban
- `/pardon <player>`: Unban
- `/lp user <player> group set <rank>`: Set rank (LuckPerms)

## Economy Management Tools
- `/eco give <player> <amount>`: Give coins
- `/eco take <player> <amount>`: Remove coins
- `/shop`: Open cross-server shop
- `/bal <player>`: Check balance

## Event Hosting Guide
- `/event start <type>`: Start event
- `/event stop`: Stop event
- `/tournament start`: Start tournament
- `/tournament end`: End tournament

## Troubleshooting Common Issues
- Check logs in `logs/` or via `/logs` command
- Use `/tps` and `/ram` for performance
- Restart servers if needed
- Check database connection in `shared/database/`

## Backup & Recovery Procedures
- Use `backup.sh` in `scripts/` to create backups
- Restore from backups in `backups/`

## Plugin Update Guide
- Place new plugin jars in `plugins/`
- Restart the relevant server
- Check for errors in logs

## Performance Monitoring
- `/tps`, `/ram`, `/lag` commands
- Monitor alerts in admin Discord