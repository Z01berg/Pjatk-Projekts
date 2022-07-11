#!/bin/bash

input=$1
output_asc=$2
output_desc=$3

cat /dev/null > $output_asc
cat /dev/null > $output_desc

if [[ $# -eq 3 && -f $input ]]; then
	incorrect_counter=0
	while read line; do 
		arr=($(echo "$line" | tr ' ' '\n'))

		min=$(( ${arr[0]}+1 ))
		max=$((min -2 ))
	
		okAsc=true
		okDesc=true

		for num in $line; do
			if [[ $num =~ ^[0-9]+$ ]]; then

				if [[ $num -gt $max ]]; then
					max=$num
				else
					okAsc=false
				fi

				if [[ $num -lt $min ]]; then
					min=$num
				else
					okDesc=false
				fi

			else
				okAsc=false
				okDesc=false
				break
			fi
		done
		
#		echo $line $okDesc " desc"
#		echo $line $okAsc " asc" 
		
		if [[ "$okAsc" = true ]]; then
			echo $line >> $output_asc
		elif [[ "$okDesc" = true ]]; then
			echo $line >> $output_desc
		else
			incorrect_counter=$((incorrect_counter+1))
		fi


	done < $input

	size_asc=$(cat $output_asc | wc -c )
	size_desc=$(cat $output_desc | wc -c )

	echo "incorrect_counter=$incorrect_counter"

	echo "size_asc=$size_asc"
	echo "size_desc=$size_desc"
fi
