#!/bin/bash

FRASCATI="../lib/frascati-runtime-1.4/bin/frascati"

ROLE="flightFinder"

rm -rf target/generated-frascati-*

$FRASCATI compile "src/main" "target/$ROLE"
$FRASCATI run "../composites/$ROLE$1.composite" -libpath "target/$ROLE.jar"
