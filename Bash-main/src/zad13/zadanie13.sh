#!/bin/bash

for dir in "$@"; do
    find "$dir" -type f -not -empty | while read -r file; do
        basename=$(basename "$file")
        if [[ ! $basename =~ [0-9][0-9] ]]; then
            test=$(grep -cP "[0-9][0-9]" "$file")
            if [[ $test -eq 0 ]]; then
                tail -n +3 "$file" | head -n 1
                fi
            fi
    done
done
