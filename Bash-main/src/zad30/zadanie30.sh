#!/bin/bash

file_regex="(^[A-Z](.*)((\.sh|exe))$)|(^[A-Z][^.]*$)"

if [[ -d $1 ]]; then
    for path2 in $1/*; do
        if [[ -d $path2 && -r $path2 ]]; then
            counter=0
            for file in $path2/*; do
                basename=$(basename $file)
                if [[ -f $file && -x $file && $basename =~ $file_regex ]]; then
                    linie=$(wc -l $path2)
                    if [[ $((linie % 2 == 0)) ]]; then
                        counter=$((counter + 1))
                    fi

                fi
            done
            if [[ $counter -lt 88 ]]; then
                echo $path2
            fi
        fi
    done
fi
