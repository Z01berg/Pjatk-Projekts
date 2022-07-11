#!/bin/bash

if [[ ! $# -eq 3 ]]; then
    echo "Zla liczba argumentow"
    exit 1
fi

if [[ -f $3 && -f $2 && -f $1 ]]; then
    # Check if file is writable
    if [[ -w $3 ]]; then
        # Intensionally splitting by spaces
        mapfile -t lines1 < <(tac "$1")
        mapfile -t lines2 < <(tac "$2")
        # lines1=($(cat $1 | tac)) # skipcq: SH-2086
        # lines2=($(cat $2 | tac)) # skipcq: SH-2086
        for ((i = 0; i < ${#lines1[@]}; i++)); do
            if [[ "${lines1[i]}" != "${lines2[i]}" ]]; then
                echo "${lines1[i]}" | rev >>"$3"
            fi
        done
    else
        echo "Plik $3 nie jest zapisywalny"
        exit 2
    fi
else
    echo "Files do not exist"
    exit 3
fi
