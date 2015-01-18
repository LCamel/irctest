#!/bin/sh
until curl -s http://127.0.0.1:9000 > /dev/null ; do sleep 1; done & sh run.sh
