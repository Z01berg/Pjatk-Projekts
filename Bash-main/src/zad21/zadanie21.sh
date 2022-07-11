#!/bin/bash

# Sprawdź liczby

if [[ $(($1 % 2)) -eq 0 ]]; then
    echo "Liczba jest parzysta!"
    exit 1
fi

if [[ ! $1 -gt 4 || ! $1 -lt 20 ]]; then
    echo "Liczba może być z przedziału (4,20)!"
    exit 2
fi

# Wypisz drzewko

for ((i = $1; i > 0; i -= 2)); do
    for ((j = 0; j <= (i / 2); j++)); do
        echo -n ' '
    done

    for ((k = 0; k <= $1 - i; k++)); do
        echo -n '*'
    done

    for ((l = 0; l <= (i / 2); l++)); do
        echo -n ' '
    done

    printf '\n'
done

# Wypisz korzeń drzewa

for ((j = 0; j <= ($1 / 2); j++)); do
    echo -n ' '
done

echo -n '*'

for ((l = 0; l <= ($1 / 2); l++)); do
    echo -n ' '
done

printf '\n'
