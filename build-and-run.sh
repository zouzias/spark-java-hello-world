#!/bin/bash

# Assembly uber-jar for spark-submit
gradle shadowJar

# Run spark uber-jar
java -jar ./build/libs/spark-java-hello-world-1.0-SNAPSHOT-all.jar
