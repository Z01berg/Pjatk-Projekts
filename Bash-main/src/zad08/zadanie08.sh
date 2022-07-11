#!/bin/bash

if [ $# -ne 3 ]; then
    echo "Zla liczba argumentow!"
    exit 1
fi

if [ ! -f $1 ]; then
    echo "Plik $1 nie istnieje!"
    exit 1
fi

if [ ! -f $2 ]; then
    echo "Plik $2 nie istnieje!"
    exit 1
fi

if [ ! -f $3 ]; then
    echo "Plik $3 nie istnieje!"
    exit 1
fi

if [ ! -r $1 ]; then
    echo "Plik $1 nie jest do odczytu!"
    exit 1
fi

if [ ! -w $2 ]; then
    echo "Plik $2 nie jest do zapisu!"
    exit 1
fi

if [ ! -w $3 ]; then
    echo "Plik $3 nie jest do zapisu!"
    exit 1
fi

: <"$2"
: <"$3"
echo "" >>$1
while read -r line; do
    if [[ $(($(echo "$line" | grep -cP "[^\s]") % 2)) -eq 0 ]]; then
        echo "$line" >>"$2"
    else
        echo "$line" >>"$3"
    fi
done <$1

echo "Data modyfikacji (plik wyjsciowy 1): $(date -r "$2")"
echo "Data modyfikacji (plik wyjsciowy 2): $(date -r "$3")"
