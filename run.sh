#!/bin/sh

# http://stackoverflow.com/questions/19331497/set-environment-variables-from-file

#export $(cat .env | xargs)
#./activator run

env $(cat .env | xargs)   ./activator run
