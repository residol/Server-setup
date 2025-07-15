#!/bin/bash
# Start all Bellion servers (Pterodactyl optimized)
SERVERS=(hub bedwars skywars kitpvp buildbattle arena1v1 vanilla prisonskyblock)
for SERVER in "${SERVERS[@]}"; do
  echo "[Bellion] Starting $SERVER..."
  cd ../$SERVER || exit 1
  bash ../scripts/start-server.sh $SERVER &
  cd - > /dev/null
done
wait
echo "[Bellion] All servers started."