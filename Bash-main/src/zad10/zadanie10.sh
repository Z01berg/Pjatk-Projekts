#!/bin/bash

# Usage: factorial n
factorial() {
    if (($1 < 2)); then
        echo 1
    else
        echo $(($1 * $(factorial $(($1 - 1)))))
    fi
}

if [[ ! -f $1 || ! -f $2 ]]; then
    echo 'Ktoryś z argumentów nie jest plikiem'
    exit 1
fi

if [[ ! -r $1 || ! -w $2 ]]; then
    echo 'Argumentom brakuje odpowiednich uprawnień'
    exit 1
fi
true >"$2"
silnia=0
ujemne=0
echo "" >>$1
while read -r line; do
    for el in $line; do
        if [[ $el =~ ^-[0-9]+$ ]]; then
            ((ujemne++))
        fi
        if [[ $el =~ ^[0-9]+$ ]]; then
            temp=$(factorial "$el")
            echo -n "$temp" >>"$2"
            ((silnia += "${#temp}"))
        else
            echo -n "$el" >>"$2"
        fi
        echo -n " " >>"$2"
    done
    echo "" >>"$2"
done <"$1"

echo "Liczba cyfr w liczbach które sa silniami to: $silnia"
echo "Liczba liczb ujemnych to: $ujemne"
