#!/bin/sh

# http://stackoverflow.com/questions/19331497/set-environment-variables-from-file

#export $(cat .env | xargs)
#./activator run

#export JAVA_OPTS=-Dhttps.port=9443

env $(cat .env | xargs)   ./activator run
