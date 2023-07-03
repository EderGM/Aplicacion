#!/bin/bash

mkdir aplicacion
cd aplicacion
git init
git pull https://github.com/rolhuama/pruebasdecodigo.git
gradle bootjar
docker build -t aplicacion .
docker login -u edergm
docker tag aplicacion edergm/aplicacion
docker push edergm/aplicacion
