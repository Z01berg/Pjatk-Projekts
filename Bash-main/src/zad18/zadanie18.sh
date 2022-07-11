#!/bin/bash

find "$PWD" | while read line; do
  if [[ -f $line ]]; then
    check="$(tail -10 "$line" | grep -P "class")"
    if [[ -n $check ]]; then
      echo $(basename "$line")
    fi
  fi
done

exit 0