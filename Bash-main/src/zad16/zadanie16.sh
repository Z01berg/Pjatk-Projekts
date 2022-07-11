#!/bin/bash


#Napisz skrypt, który zapisze do pliku P te spośród swoich argumentów, które są nazwami pustych plików zwykłych, do których mamy prawo zapisu lub pustych katalogów (newat bez plików ukrytych). Nazwa pliku P musi być podana jako ostatni argument, a poprzedzajace ją argumentów są to argumenty, które testujemy i które być może będziemy zapisywać do pliku P.

P=${@: -1}

cat /dev/null > $P

for arg in ${@: 1: $#-1}; do
	if [[ (-f $arg && -w $arg) || ( -d $arg && ! $(ls -A $arg) ) ]]; then
		echo $arg >> $P
	fi
done


