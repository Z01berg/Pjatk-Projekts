#!/bin/bash

## Zadanie 23
#
#Napisz skrypt, który dla każdego pliku, znajdującego się w bieżącym katalogu,
#
#- o nazwie spełniającej nastepujące warunki:
#    1. rozpoczynajacej sie od dowolnych 3 znaków,
#    2. na kolejnych 6 znakach posiadajacej string `BILANS`
#    3. 1 dalej mogacych miec dowolne znaki w nazwie pliku,
#    4. posiadajacy rozszerzenie `.log`
#- o liczbach w treści pliku spełniające następujące warunki:
#    1. podzielne prez 3,
#    2. podzielne prez 7,
#    3. równe 1.
#
#Zakładamy, te dane zawarte w plikach sa poprawne - są liczbami całkowitymi, czyli pliki nie zawieraja innych danych niz wyżej wymienione.
#
### Przykład
#
#```bash
#Plik `abcBILANS0123.log` zawiera nastepujące liaby:
#
#7 liczb podzielnych przez 3 i 5 liczb podzielnych przez 8 oraz 5 liczb 1.
#
#Plik `zkaBILANSa.log` zawiera:
#
#5 liczb podzielnych przez 3 i 8 liczb podzielnych przez 8 oraz O liczb 1.
#```



name_regex="^[A-Za-z]{3}(BILANS)(.*)(\.log)$"

content_regex="[0-9]+"

search_dir=./*

for file in $search_dir; do
	tmp=$( basename $file )
	if [[ -f $file && -r $file && $tmp =~ $name_regex ]]; then
		count_3=0
		count_7=0
		count_eq_1=0
		while read line; do
			arr=( $(echo $line | grep -oE $content_regex ) )
			
			for num in ${arr[@]}; do
				if [[ $((num % 3)) -eq 0 ]]; then
					count_3=$((count_3+1))
				fi

				if [[ $((num % 7)) -eq 0 ]]; then
					count_7=$((count_7+1))
				fi

				if [[ $num -eq 1 ]]; then
					count_eq_1=$((count_eq_1+1))
				fi
			done

		done < $file
		echo "------------plik zawiera----------"
		echo "$count_3 liczb podzielnych przez 3"
		echo "$count_7 liczb podzielnych przez 7"
		echo "$count_eq_1 równych 1"
	fi
done

echo "----------------------------------"
