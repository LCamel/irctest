#!/bin/sh
export $(cat .env | xargs)
./activator run
