#!/bin/bash

function isFibbonaci() {
    number=$1
    if [ $number -eq 0 ] || [ $number -eq 1 ]; then
        echo "true"
    else
        fib1=0
        fib2=1
        fib3=$((fib1 + fib2))
        while [ $fib3 -lt $number ]; do
            fib1=$fib2
            fib2=$fib3
            fib3=$((fib1 + fib2))
        done
        if [ $fib3 -eq $number ]; then
            echo "true"
        else
            echo "false"
        fi
    fi
}

input_file=$1
output_file=$2
regex="[0-9]+"

mapfile -d ' ' -t elem < <(xargs -d $'\n' -a "$input_file")
declare -A fibonacci

>"$output_file"
for i in "${elem[@]}"; do
    i=$(echo "$i" | xargs)
    if [[ "$i" =~ $regex ]]; then
        if [[ $(isFibbonaci "$i") == "true" ]]; then
            ((fibonacci["$i"]++))
        else
            fibonacci["$i"]=0
        fi
    else
        fibonacci["$i"]="not_number"
    fi
done

for i in "${!fibonacci[@]}"; do
    if [[ "${fibonacci["$i"]}" == "not_number" ]]; then
        echo "Liczba ""$i"" nie jest liczbą" >>"$output_file"
    else
        if [[ "${fibonacci["$i"]}" == 0 ]]; then
            echo "Liczba ""$i"" nie jest liczbą Fibonacciego" >>"$output_file"
        else
            echo "Liczba ""$i"" jest liczbą Fibonacciego, Liczba wystąpień ""${fibonacci["$i"]}" >>"$output_file"
        fi
    fi
done
