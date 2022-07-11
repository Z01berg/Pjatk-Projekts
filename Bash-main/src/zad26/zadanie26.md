# Zadanie 26

Mamy plik jak poniżej:

```
1 2 3 a 4 5
9 2 a b
1 2 a l a i o l a
9 2 c
```

Napisz skrypt, który  pobierze trzy argumenty `PLIKWEJSCIOWY`, `PLIKWYJSCIOWY1`, `PLIKWYJSCIOWY2`, który przepisze wszystkie liczby do PLIKWYJSCIOWY1 i ciągi znaków różne od liczb do `PLIKWYJSCIOWY2`.

`PLIKWYJSCIOWY1`

```
1 2 3 4 5
9 2
1 2                        
9 2
```

`PLIKWYJSCIOWY2`

```
a
a b
a l a i o l a
c
```

Plik wejściowy powinien zawierać tylko pojedyncze znaki oddzielone spacją.

Wersja 1:  Jeżeli pojawi się tam jakikolwiek ciąg, który ma więcej jak 1 znak to skrypt ma się zakończyć,  a pliki wyjściowe powinny zostać skasowane.

Wersja 2: Dopuszczamy istnienie elementów wieloznakowych

```
1 2 3 a 4 5
9 2 3a3 b
1 2 a l a i o l a
9 2 c
```

Napisz skrypt, który  pobierze trzy argumenty `PLIKWEJSCIOWY`, `PLIKWYJSCIOWY1`, `PLIKWYJSCIOWY2`, który przepisze wszystkie liczby do `PLIKWYJSCIOWY1` i ciągi znaków różne od liczb do `PLIKWYJSCIOWY2`.

`PLIKWYJSCIOWY1`
```
1 2 3 4 5
9 2
1 2
9 2
```

`PLIKWYJSCIOWY2`

```
a
3a3 b
a l a i o l a
c
```
