#!/bin/sh


echo "Compilation Done"
javac -d classes/ src/*.java
echo "Execution Done\n"
java -cp classes/ src.Main
