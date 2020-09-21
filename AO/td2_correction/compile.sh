#!/bin/bash

javac -cp lib/jdom2-2.0.6.jar -d classes/ src/main/java/fr/ubordeaux/ao/*.java
java -cp classes/:lib/jdom2-2.0.6.jar fr.ubordeaux.ao.Main
