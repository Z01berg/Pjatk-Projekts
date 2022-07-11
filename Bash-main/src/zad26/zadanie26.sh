#!/bin/bash

if [ $# -ne 3 ]; then
    echo "Zla liczba argumentow!"
    exit 1
fi

if [ ! -r $1 ] && [ ! -f $1 ]; then
    echo "Plik $1 nie istnieje (lub nie mam uprawnień)!"
    exit 1
fi

if [ ! -w $2 ] && [ ! -f $2 ]; then
    echo "Plik $2 nie istnieje (lub nie mam uprawnień)!"
    exit 1
fi

if [ ! -w $3 ] && [ ! -f $3 ]; then
    echo "Plik $1 nie istnieje (lub nie mam uprawnień)!"
    exit 1
fi

true >"$2"
true >"$3"

echo "" >>$1
while read -r line; do
    for el in $line; do
        if [[ $(wc -m $el) -gt 1 ]]; then
            true >"$2"
            true >"$3"
            exit 1
        fi
        # wersja 2: wykomentuj linie od 8 do 12, a linię 14 zamień na:
        # if [ $el =~ [0-9] ] && [$(wc -m $el) -eq 1]; then
        if [[ $el =~ [0-9] ]]; then
            echo -n $el >>$2
            echo -n " " >>$2
        else
            echo -n $el >>$3
            echo -n " " >>$3
        fi
    done
    echo "" >>$2
    echo "" >>$3
done <$1
