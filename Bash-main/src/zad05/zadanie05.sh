#!/bin/bash

mapfile -d ' ' -t args < <(echo "$@")

pliki=()

slowa=0
linie=0
liczby=0

slowa_total=0
linie_total=0
liczby_total=0

liczby_regex="[0-9]+"
slowa_regex="[a-zA-Z]+"

for i in "${args[@]}"; do
    i=$(echo "$i" | xargs)
    if [ -f "$i" ]; then
        pliki+=("$i")
        ((linie = $(wc -l "$i" | cut -d ' ' -f 1)))
        ((liczby = $(grep -cP "$liczby_regex" "$i")))
        ((slowa = $(grep -cP "$slowa_regex" "$i")))
        ((linie_total += linie))
        ((liczby_total += liczby))
        ((slowa_total += slowa))
        echo "W pliku $i mamy $slowa słowa i $linie linii i $liczby liczb"
        ((slowa = 0))
        ((linie = 0))
        ((liczby = 0))
    else
        echo "Nazwa $i to nie nazwa pliku"
    fi
done
echo ""
echo "W sumie mamy $slowa_total słowa i $linie_total linii i $liczby_total liczb"
echo "W sumie długość wszystkich plików w bajtach to $(du -b "${pliki[@]}" | tail -n 1 | cut -f 1)"
