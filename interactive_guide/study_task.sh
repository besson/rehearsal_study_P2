#!/bin/bash

FRASCATI="../lib/frascati-runtime-1.4/bin/frascati"

ROLE="interactiveGuide"
LIB_DIR="../lib/interactive_guide_lib"

LIB="$LIB_DIR/orient-commons-1.0rc5.jar:$LIB_DIR/orientdb-core-1.0rc5.jar"

rm -rf target/generated-frascati-*

$FRASCATI compile "src/main" "target/$ROLE" $LIB
$FRASCATI run "../composites/$ROLE$1.composite" -libpath "target/$ROLE.jar" $LIB
