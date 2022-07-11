#!/bin/bash

pandoc \
 -f gfm \
 src/zad*/zadanie*.md \
 --pdf-engine=xelatex \
 -o zadania.pdf
