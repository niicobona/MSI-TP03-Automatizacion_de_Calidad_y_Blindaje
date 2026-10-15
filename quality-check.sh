#!/bin/sh

echo "--- INICIANDO CONTROLES DE CALIDAD PRE-COMMIT ---"

echo ""
echo "1. Verificando formato del codigo..."

./gradlew spotlessCheck

if [ $? -ne 0 ]; then
    echo "ERROR: Se detectaron problemas de formato."
    echo "Ejecutar ./gradlew spotlessApply para corregirlos."
    exit 1
fi
echo "Formato correcto."

echo ""
echo "2. Ejecutando Checkstyle..."

./gradlew checkstyleMain checkstyleTest

if [ $? -ne 0 ]; then
    echo "ERROR: Checkstyle detecto problemas en el codigo."
    exit 1
fi
echo "Checkstyle correcto."

echo ""
echo "3. Ejecutando pruebas unitarias..."

./gradlew test

if [ $? -ne 0 ]; then
    echo "ERROR: Existen pruebas unitarias fallidas."
    exit 1
fi
echo "Tests correctos."

echo ""
echo "--- CONTROL DE CALIDAD SUPERADO ---"
echo "Commit autorizado."

exit 0


