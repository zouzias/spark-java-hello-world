#!/bin/bash

gradle shadowJar

java -jar ./build/libs/spark-java-hello-world-1.0-SNAPSHOT-all.jar
