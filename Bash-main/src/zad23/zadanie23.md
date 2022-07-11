# Zadanie 23

Napisz skrypt, który dla każdego pliku, znajdującego się w bieżącym katalogu,

- o nazwie spełniającej nastepujące warunki:
    1. rozpoczynajacej sie od dowolnych 3 znaków,
    2. na kolejnych 6 znakach posiadajacej string `BILANS`
    3. 1 dalej mogacych miec dowolne znaki w nazwie pliku,
    4. posiadajacy rozszerzenie `.log`
- o liczbach w treści pliku spełniające następujące warunki:
    1. podzielne prez 3,
    2. podzielne prez 7,
    3. równe 1.

Zakładamy, te dane zawarte w plikach sa poprawne - są liczbami całkowitymi, czyli pliki nie zawieraja innych danych niz wyżej wymienione.

## Przykład

```bash
Plik `abcBILANS0123.log` zawiera nastepujące liaby:

7 liczb podzielnych przez 3 i 5 liczb podzielnych przez 8 oraz 5 liczb 1.

Plik `zkaBILANSa.log` zawiera:

5 liczb podzielnych przez 3 i 8 liczb podzielnych przez 8 oraz O liczb 1.
```
