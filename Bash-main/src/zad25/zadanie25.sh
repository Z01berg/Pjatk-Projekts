#!/bin/bash

echo "Podaj nazwe pliku do ktorego chcesz zapisac nazwy katalogow"
read output1
for input in $@; do
    if [ ! -d $input ]; then
        echo "Katalog $input nie istnieje!"
        exit 1
    fi
    if [ -d $input ]; then
        if [ $(ls -1 $input | wc -l) -le 11 ]; then
            echo "Pozycji w katalogu $input: $(ls -1 $input | wc -l)" >>$output1
        else
            echo "Katalog $input ma wiecej niz 11 pozycji"
        fi
    fi
done
