#!/bin/bash
# Stop all Bellion servers
echo "[Bellion] Stopping all servers..."
SERVERS=(hub bedwars skywars kitpvp buildbattle arena1v1 vanilla prisonskyblock)
for SERVER in "${SERVERS[@]}"; do
  screen -S $SERVER -X quit 2>/dev/null
done
echo "[Bellion] All servers stopped."