#!/bin/bash
regex_big="[A-Z]"
regex_words="[a-zA-Z]+"
find ~ -type f -not -empty | while read -r file; do
    basename=$(basename "$file")
    if [[ ! $basename =~ $regex_big ]]; then
        test=$(grep -c "$regex_words" "$file")
        if [[ $test -gt 0 ]]; then
            echo "$basename"": ""$test"
        fi
    fi
done
