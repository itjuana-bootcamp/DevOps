#! /bin/bash

if [ -z "$1" ]; then
  echo "Name is not defined" >>/dev/stderr
else
  echo "My name is $1"
fi
