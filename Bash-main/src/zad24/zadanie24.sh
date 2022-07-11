#!/bin/bash

find "$PWD" | while read line; do
  if [[ -f $line ]]; then
    check="$(cut -d' ' -f1 "$line" | grep -P "main")"
    if ! [[ -n $check ]]; then
      echo $(basename "$line")
    fi
  fi
done

exit 0
