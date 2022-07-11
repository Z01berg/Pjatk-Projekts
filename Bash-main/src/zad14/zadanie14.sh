#!/bin/bash

#Napisz skrypt, który wypisze nazwy tych katalogów z katalogu podanego jako argument, w których są przynajmniej trzy pliki zaczynające się na dużą literę z rozszerzeniem exe lub sh lub bez rozszerzenia, które można uruchomić.

file_regex="(^[A-Z](.*)((\.sh|exe))$)|(^[A-Z][^.]*$)"

if [[ -d $1 ]]; then
	for path2 in $1/*; do
		if [[ -d $path2 && -r $path2 ]]; then
			counter=0
			for file in $path2/*; do
				basename=$(basename $file)
				if [[ -f $file && -x $file && $basename =~ $file_regex ]]; then
					counter=$((counter+1))
				fi
			done
			if [[ $counter -ge 3 ]]; then
				echo $path2
			fi
		fi
	done
fi
