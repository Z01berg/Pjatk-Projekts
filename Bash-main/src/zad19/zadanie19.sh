#!/bin/bash

for arg in $@; do
 if [[ -d $arg  ]]; then
	find ""$PWD"/$arg" | grep -P ".java$" | while read line; do
			echo $line": "
			tail -2 $line
			echo ""
	done
 fi
done

exit 0