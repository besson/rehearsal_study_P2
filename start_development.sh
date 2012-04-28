#!/bin/bash

PATTERN=$(pwd)

COMP_TEMPLATES="./utils/composite-templates"
DESC_TEMPLATE="./utils/descriptor-templates/arrivalAtAirport.yml"

COMPOSITES="composites"

cp "$DESC_TEMPLATE" "interactive_guide/resource/"
sed -i "s,WORKSPACE_DIR,$PATTERN,g" "interactive_guide/resource/arrivalAtAirport.yml"


cp  "$COMP_TEMPLATES"/* "$COMPOSITES/"

for i in $COMPOSITES/*
do
  sed -i "s,WORKSPACE_DIR,$PATTERN,g" $i
done
