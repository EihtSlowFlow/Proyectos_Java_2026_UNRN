#!/bin/bash
cd "$(dirname "$0")"
java -cp "target/classes:$(find ~/.m2 -name 'javafx*.jar' -o -name 'javafx*.jar' 2>/dev/null | tr '\n' ':')" ar.edu.unrn.modelo.MenuApp

