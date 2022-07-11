#!/bin/bash

if [[ ! -d "$1" || ! -d "$2" ]]; then
    echo "Nieprawidłowy argument"
    exit 1
fi

mapfile -t files < <(find "$(realpath "$1")" -type f)
mapfile -t files2 < <(find "$(realpath "$2")" -type f)

if [ ! "${#files[@]}" -eq "${#files2[@]}" ]; then
    echo "Nie zgadza sie liczba plikow"
    exit 0
fi
index="${#files[@]}"
for ((i = 0; i < index; i++)); do
    if [[ -f "${files[i]}" ]]; then
        if [[ -f "${files2[i]}" ]]; then
            if [[ "${files[i]}" != "${files2[i]}" ]]; then
                printf "Nie zgadzaja sie nazwy plików:\n"
                echo "${files[i]}"" != ""${files2[i]}"
                exit 0
            fi
            if ! cmp "${files[i]}" "${files2[i]}"; then
                exit 0
            fi
        fi
    fi
done

echo "OK"
exit 0
