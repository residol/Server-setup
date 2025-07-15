#!/bin/bash
# Restart a specific Bellion server
if [ -z "$1" ]; then
  echo "Usage: $0 <server>"
  exit 1
fi
SERVER=$1
echo "[Bellion] Restarting $SERVER..."
screen -S $SERVER -X quit 2>/dev/null
sleep 2
cd ../$SERVER || exit 1
bash ../scripts/start-server.sh $SERVER &
echo "[Bellion] $SERVER restarted."