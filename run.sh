#!/bin/sh

export JAVA_HOME="/usr/lib/jvm/java-1.11.0-openjdk-amd64"

./jazzer --cp=wxb.jar --target_class="JepJazzerTest" --coverage_report="report.log"
