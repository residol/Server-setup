# BELLION TECHNICAL DOCUMENTATION

## Plugin Architecture Overview
- Modular plugin system for each gamemode
- Core plugins: LuckPerms, Vault, PlaceholderAPI, ProtocolLib
- Custom plugins: PrisonSkyblock, Arena1v1, EconomyBridge, Cosmetics, TournamentManager

## Database Schema Complete
- See `shared/database/bellion_schema.sql` for full schema
- MySQL used for cross-server data

## API Documentation
- REST endpoints for stats, leaderboards, shop
- Webhooks for events and alerts
- Plugin API for custom gamemode integration

## Custom Plugin Development
- Use Java 17+, Spigot/Paper API
- Place source in `plugins/` and build with Maven/Gradle
- Follow provided interfaces for cross-server features

## Integration Guidelines
- Use Vault for economy bridge
- Use LuckPerms for permissions
- Use PlaceholderAPI for dynamic variables
- Use BungeeCord messaging for cross-server sync

## Performance Optimization
- JVM flags in `start-server.sh` scripts
- View-distance and simulation-distance set for VPS
- Use async tasks for heavy operations
- Monitor TPS and RAM

## Security Measures
- Enable online_mode and anti-bot in BungeeCord
- Use strong RCON passwords
- Regularly update plugins
- Restrict admin commands to staff