#!/bin/bash

PATTERN=$(pwd)

COMP_TEMPLATES="./utils/composite-templates"
DESC_TEMPLATE="./utils/descriptor-templates/arrivalAtAirport.yml"
CLASS_TEMPLATE="./utils/classpath-templates"

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

cp  "$COMP_TEMPLATES"/* "$COMPOSITES/"

for i in $COMPOSITES/*
do
  sed -i "s,WORKSPACE_DIR,$PATTERN,g" $i
done
