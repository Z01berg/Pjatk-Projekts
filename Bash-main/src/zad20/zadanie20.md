# Zadanie 20

Napisz skrypt który:
 - pobierze nazwę pliku wejściowego jako pierwszy argument
 - wypisze ilość liczb oraz "słów" w pliku

## Przykład:
 - ciąg `1 5 102` będzie policzony jako 3 liczby
 - ciąg znaków `a b 4 5 ac 3gh 65` będzie policzony jako 3 liczby (`4, 5, 65`) oraz 4 słowa (`a, b, ac, 3gh`)
 - specjalne znaki (`*, &, ^` itd.) mają być liczone jako część słowa. (czytaj: ciąg `4*5` ma być potratkowany jako słowo)

Następnie zapisze wyniki sprawdzania (ilość liczb oraz słów) do pliku wyjściowego,
podanego jako drugi argument skryptu. 

## Przykładowy plik:
```
31 543 63 gf3 sd32
1 2 3 5 6 4 2 s a f g ^ a s 2 3 4 
12 3456 francuski sprawia odczucia 14785
```