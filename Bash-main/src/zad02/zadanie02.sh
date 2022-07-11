#!/bin/bash

if [[ ! $# -eq 2 ]]; then
    echo "Zla liczba argumentow"
    exit 1
fi
# `-f`: pliki istnieją?
if [[ ! -f $1 && ! -f $2 ]]; then
    echo "Pliki nie istnieja"
    exit 2
fi
# `-r`: pliki można odczytać?
if [[ ! -r $1 && ! -r $2 ]]; then
    echo "Pliki nie sa odczytywalne"
    exit 3
fi
# Intensionally splitting by spaces
# lines1=($(cat $1))  # skipcq: SH-2086
# lines2=($(cat $2))  # skipcq: SH-2086

# `-t`: Usunięcie końcowego znaku końca linii z każdej wczytanej linii.
mapfile -t lines1 < <(tac "$1")
mapfile -t lines2 < <(tac "$2")

if [[ ${#lines1[@]} -gt ${#lines2[@]} ]]; then
    max_lines="${#lines1[@]}"
else
    max_lines="${#lines2[@]}"
fi
for ((i = 0; i < max_lines; i++)); do
    if [[ "${lines1[i]}" != "${lines2[i]}" ]]; then
        echo "$i: ${lines2[i]}"
        exit 0
    fi
done
echo 'OK'
exit 0
