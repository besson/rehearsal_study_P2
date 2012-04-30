#!/bin/bash

PATTERN=$(pwd)

COMP_TEMPLATES="./utils/composite-templates"
DESC_TEMPLATE="./utils/descriptor-templates/arrivalAtAirport.yml"
CLASS_TEMPLATE="./utils/classpath-templates"
SAND_DIR="training/sand-box"
PSAF_DIR="park_safe"
COMPOSITES="composites"


build_descriptor (){
  cp "$DESC_TEMPLATE" "$1/resource/"
  cp "$CLASS_TEMPLATE/$1/.classpath" "$1/" 
sed -i "s,WORKSPACE_DIR,$PATTERN,g" "$1/resource/arrivalAtAirport.yml"
sed -i "s,WORKSPACE_DIR,$PATTERN,g" "$1/.classpath"

}

build_descriptor "interactive_guide"
build_descriptor "car_park_reservation"
build_descriptor "flight_finder"
build_descriptor "car_parking_ws"

cp "$CLASS_TEMPLATE/sand_box/.classpath" "$SAND_DIR"
sed -i "s,WORKSPACE_DIR,$PATTERN,g" "$SAND_DIR/.classpath"


cp "$CLASS_TEMPLATE/park_safe/.classpath" "$PSAF_DIR"
sed -i "s,WORKSPACE_DIR,$PATTERN,g" "$PSAF_DIR/.classpath"

cp  "$COMP_TEMPLATES"/* "$COMPOSITES/"

for i in $COMPOSITES/*
do
  sed -i "s,WORKSPACE_DIR,$PATTERN,g" $i
done
