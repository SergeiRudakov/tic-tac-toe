#!/usr/bin/env sh
java -jar ${project.build.finalName}.jar
echo "Press Enter to continue..."
read -r test