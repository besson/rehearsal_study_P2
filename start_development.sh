#!/bin/bash

PATTERN=$(pwd)

COMP_TEMPLATES="./utils/composite-templates"
DESC_TEMPLATE="./utils/descriptor-templates/arrivalAtAirport.yml"

COMPOSITES="composites"


build_descriptor (){
  cp "$DESC_TEMPLATE" "$1/resource/"
sed -i "s,WORKSPACE_DIR,$PATTERN,g" "$1/resource/arrivalAtAirport.yml"

}

build_descriptor "interactive_guide"
build_descriptor "car_park_reservation"

cp  "$COMP_TEMPLATES"/* "$COMPOSITES/"

for i in $COMPOSITES/*
do
  sed -i "s,WORKSPACE_DIR,$PATTERN,g" $i
done
