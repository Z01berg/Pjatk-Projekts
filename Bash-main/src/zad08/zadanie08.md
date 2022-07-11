# Zadanie 8

Napisz skrypt, który pobierze trzy argumenty `PLIKWEJSCIOWY`, `PLIKWYJSCIOWY1`, `PLIKWYJSCIOWY2`, i przepisze wszystkie linie zawierające wyłącznie słowa o parzystej liczbie znaków do `PLIKWYJSCIOWY1`, o pozostałe do `PLIKWYJSCIOWY2`.

- Skrypt ma wyświetlić ile linii zostało zapisanych do pliku wyjściowego 1 i pliku wyjściowego 2.
- Skrypt ma sprawdzać błędy.
- Wyświetl daty modyfikacji plików wyjściowych.

## Przykład:

Mamy `PLIKWEJSCIOWY`:
```
12323 332 33w 434 532
4332 23 32
1333 2ewe 2a
9r 23
Ala ma kota
```
`PLIKWYJSCIOWY1`
```
4332 23 32
1333 2ewe 2a
9r 23
```
`PLIKWYJSCIOWY2`
```
12323 332 33w 434 532
Ala ma kota
```