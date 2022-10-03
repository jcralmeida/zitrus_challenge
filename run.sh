#!/bin/zsh

## set -e

docker build -t restapp backend/.

docker build -t front frontend/.

docker-compose up