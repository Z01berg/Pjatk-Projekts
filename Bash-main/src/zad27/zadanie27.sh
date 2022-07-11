#!/bin/bash

for folder in */; do
	for file in $folder/*; do
		if [[ -r $file ]]; then
			echo $folder
			break
		fi
	done
done