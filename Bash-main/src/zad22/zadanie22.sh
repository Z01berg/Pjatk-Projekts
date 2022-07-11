#!/bin/bash

folder=$1
if [ ! -d $folder ]; then
    echo "Folder does not exist!"
fi

# Check if user typed to many arguments
if [ $# -gt 1 ]
then
    echo "Too many arguments!"
fi


# find all txt files in current directory and store them in txtFiles
txtFiles=$(find $folder -type f -name "*.txt" | wc -l)

testCount=$((0))
for file in $(find $folder -type f -name "*.txt"); do
    # Check if file contains "test"
    if grep -q "test" $file; then
        testCount=$((testCount+1))
    fi
done
echo "Biezacy katalog zawiera $txtFiles plikow z rozszerzeniem .txt"
echo "W tym: $testCount plikach zawieraja przynajmniej jedno slowo 'test'"