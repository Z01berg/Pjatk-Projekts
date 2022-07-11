#!/bin/bash

# Write script that will read all arguments. First one will be the name of output file. Other ones will be the names of files to be processed. Script have to concetenate all file line by line and write it to output file.
output=$1
: >"$output"
declare -A lines
for arg in "$@"; do
    if [ "$arg" != "$output" ]; then
        if [ -f "$arg" ]; then
            mapfile -t temp_lines < <(cat "$arg")
            for ((idx = 0; idx < ${#temp_lines[@]}; idx++)); do
                lines[$idx]+="${temp_lines[$idx]}"" "
            done
        else
            echo "Nazwa $arg to nie nazwa pliku"
        fi
    fi
done

for ((idx = 0; idx < ${#lines[@]}; idx++)); do
    echo "${lines[$idx]}" | xargs >>"$output"
done
