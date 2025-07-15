#!/bin/bash
# Pterodactyl-optimized startup for a single server
SERVER_NAME=$1
MEMORY=${SERVER_MEMORY:-4096}
JARFILE=${SERVER_JARFILE:-server.jar}
PORT=${SERVER_PORT:-25565}
IP=${SERVER_IP:-0.0.0.0}
RCON_PORT=${RCON_PORT:-25575}
RCON_PASSWORD=${RCON_PASSWORD:-bellionRconPass}
cd ../$SERVER_NAME || exit 1
java -Xms${MEMORY}M -Xmx${MEMORY}M \
-XX:+UseG1GC \
-XX:+ParallelRefProcEnabled \
-XX:MaxGCPauseMillis=200 \
-XX:+UnlockExperimentalVMOptions \
-XX:+DisableExplicitGC \
-XX:+AlwaysPreTouch \
-XX:G1NewSizePercent=30 \
-XX:G1MaxNewSizePercent=40 \
-XX:G1HeapRegionSize=8m \
-XX:G1ReservePercent=20 \
-XX:G1HeapWastePercent=5 \
-XX:G1MixedGCCountTarget=4 \
-XX:InitiatingHeapOccupancyPercent=15 \
-XX:G1MixedGCLiveThresholdPercent=90 \
-XX:G1RSetUpdatingPauseTimePercent=5 \
-XX:SurvivorRatio=32 \
-XX:+PerfDisableSharedMem \
-XX:MaxTenuringThreshold=1 \
-Dpteroder.running=true \
-jar ${JARFILE} nogui