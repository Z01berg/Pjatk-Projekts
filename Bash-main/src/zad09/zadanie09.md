# Zadanie 9

Napisz skrypt, który pobierze trzy argumenty `PLIKWEJSCIOWY`, `PLIKWYJSCIOWY1`, `PLIKWYJSCIOWY2`. 

Jak argumenty sa poprawne to skrypt ma przepisać wszystkie linie zawierajace ciągi rosnące do `PLIKWYJSCIOWY1`, o ciągi malejące do `PLIKWYJSCIOWY2`. 

Linie które nie są poprawnymi ciągami rosnacymi lub malejącymi ignorujemy, ale wyświetlamy ile takich ciągów było.

Podaj wielkość plików wyjściowych w bajtach.

## Przykład:

Mamy `PLIKWEJSCIOWY` jak poniżej:
```
1 2 3 a 4 5
1 2 3 4 5
9 2 3 b
54 45 33
1 2 a l a i o l a
9 2 c
5 5 5
1 2 3 4
4 3 2 1
1 1 1 2
```

`PLIKWYJSCIOWY1`
```
1 2 3 4 5
1 2 3 4
```
`PLIKWYJSCIOWY2`
```
54 45 33
4 3 2 1
```