#!/bin/bash

for x in $@; do
    if [[ -f $x ]]; then
        if [[ $(grep -oP '[\s]CPU[\s\.\,]' $x | wc -l) -ge 2 ]]; then
            echo $x
        fi
    fi
done
