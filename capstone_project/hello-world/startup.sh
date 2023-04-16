#!/bin/bash
npm start &
service ssh start 
tail -f /dev/null 
wait
