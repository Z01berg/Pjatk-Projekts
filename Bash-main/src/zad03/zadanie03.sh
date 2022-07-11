#!/bin/bash

if [[ ! $# -eq 3 ]]; then
    echo "Zla liczba argumentow"
    exit 1
fi

if [[ ! -f $3 && ! -f $2 && ! -f $1 ]]; then
    # Check if file is writable
    echo "Files do not exist"
    exit 3
fi

if [[ ! -w $3 ]]; then
    echo "Plik $3 nie jest zapisywalny"
    exit 2
fi
# Intensionally splitting by spaces
# lines1=($(cat $1)) # skipcq: SH-2086
# lines2=($(cat $2)) # skipcq: SH-2086
mapfile -t lines1 < <(tac "$1")
mapfile -t lines2 < <(tac "$2")

for ((i = 0; i < ${#lines1[@]}; i++)); do
    if [[ "${lines1[i]}" != "${lines2[i]}" ]]; then
        echo "$i"
        echo "${lines1[i]}" >>"$3"
        echo "Liczba znaków: ""${#lines1[i]}" # ${#zmienna} == $(echo "$zmienna" | wc -c)
        # echo "Liczba znaków: ""$(echo "${lines1[i]}" | wc -m)"
        echo "Liczba spacji: ""$(echo "${lines1[i]}" | grep -cP '\s')"
        echo "Liczba liter 'a' i 'A': ""$(echo "${lines1[i]}" | grep -cP '[aA]')"
        echo " "
    fi
done
