#!/bin/bash

echo -n "Podaj sciezke do pliku wyjsciowego: "
read -r PLIK_WYJSCIOWY

true >"$PLIK_WYJSCIOWY"

for file in $@; do
    if [ -f "$file" ] && [ -r "$file" ] && [ -s "$file" ]; then
        NAZWA=$(basename "$file")
        LICZBA_ZNAKOW=$(wc -m "$file" | cut -d ' ' -f 1)
        # UPRAWNIENIA=$(ls -l "$file" | cut -d ' ' -f 1)
        UPRAWNIENIA=$(stat -c '%A' "$file")
        echo "$NAZWA: $LICZBA_ZNAKOW znakow, uprawnienia: $UPRAWNIENIA" >>"$PLIK_WYJSCIOWY"
    fi
done
