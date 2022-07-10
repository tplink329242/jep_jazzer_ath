#!/bin/sh

export JAVA_HOME="/usr/lib/jvm/java-1.11.0-openjdk-amd64"

cd /root/jep_jazzer_ath/

nohup sh run.sh > full.log 2>&1 &

python3 extract_log.py 1800 $0
