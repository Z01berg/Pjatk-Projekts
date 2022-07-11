#!/bin/bash

if [[ ! $# -eq 2  ]]; then
	echo "Zla liczba argumentow"
	exit 1
fi

if [[ ! -f $0 && ! -f $1 ]]; then
	echo "Ktorys z argumentow nie jest plikiem"
	exit 2
fi

if [[ ! -r $0 ]]; then
	echo "Plik wejsciowy bez mozliwosci odczytu"
	exit 3
fi

if [[ ! -w $1 ]] ; then
	echo "Plik wyjsciowy bez mozliwosci zapisu"
	exit 4
fi

mapfile -t wyrazy < <(cat "$1")
liczby=0
ciag=0
regex='^[0-9]+$'

for word in ${wyrazy[@]}; do
	if [[ $word =~ $regex ]]; then
		((liczby++));
	else
		((ciag++));
	fi
done

echo "Ilosc liczb: ""$liczby"

echo "Ilosc slow: ""$ciag"

echo "$liczby"" ""$ciag" > "$2"

exit 0