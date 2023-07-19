#!/bin/bash

mkdir aplicacion
cd aplicacion
gradle bootjar
docker build -t aplicacion .
docker tag aplicacion edergm/aplicacion
docker push edergm/aplicacion

