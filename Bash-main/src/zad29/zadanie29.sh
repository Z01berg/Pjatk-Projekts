#!/bin/bash

file_name=$1

letter_counter=0
digit_counter=0
sum_numbers=0

letter_counter=$(grep -o [a-zA-Z] $file_name | wc -l)
digit_counter=$(grep -o "[0-9]" $file_name | wc -l)
sum=$(grep -oP '[\d]+' $file_name)

for number in $sum; do
    ((sum_numbers = sum_numbers + $number))
done

echo "Plik $(basename "$file_name") zawiera $digit_counter cyfr i $letter_counter liter."
echo "Suma wszyskich cyfr wynosi $sum_numbers"
