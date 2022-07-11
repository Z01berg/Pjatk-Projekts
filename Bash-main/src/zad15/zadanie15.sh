#!/bin/bash

if [[ -r $1 && -r $2 ]]; then
    file1=$(<$1)
    file2=$(<$2)

    if [[ "$file1" == "$file2" ]]; then
        echo "2"
    else
        if [[ "$file1" == "$(echo "$file2" | rev)" ]]; then
            echo "3"
        else
            if [[ "$file2" == "$file1" ]]; then
                echo "1"
            else
                echo "0"
            fi
        fi
    fi
else
    echo "Nieprawidłowe argumenty"
fi
