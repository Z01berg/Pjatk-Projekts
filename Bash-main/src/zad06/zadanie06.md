# Zadanie 6

Napisz skrypt, który pobierze n argumentów. Pierwszy argument to nazwa pliku wyjściowego.

Kolejne n-1 argumentów to nazwy plików z danymi.

Skrypt ma za zadanie scalić pliki wejściowe jak poniżej:

`PLIKA`
```
1
2 3
1 33
3
```
`PLIKB`
```
2 3
9 b
a l a
```
`PLIKC`
```
4 5
3
i o l a
1
```
`PLIKWYJSCIOWY`
```
1 2 3 4 5
2 3 9 b 3
1 33 a l a i o l a
3 1
```

Przydatne polecenia: 

 - `tail -10 plik` odczytuje 10 ostatnich linii z pliku plik,
 - `head -10 plik` odczytuje 10 pierwszych linii z pliku plik,
 - `tail -10 plik | head -1` odczytuje 10 od końca linię z pliku plik. 

Oprócz utworzenia pliku wyjściowego, skr ypt ma wyświetlić jego długość w bajtach.