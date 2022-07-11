# Zadanie 21

Napisz skrypt o nazwie `skrypt`, który drukuje z gwiazdek choinkę.

Jako argument wywołania tego skryptu jest podana dolna krawędź - podstawa tej choinki.

Nalezy sprawdzać poprawność tego argumentu - musi być:

- nieparzysty,
- większy od 4, a mniejszy od 20

## Przykład

**`./zadanie21.sh 7`**:

```
    *    
   ***   
  *****  
 ******* 
    *    
```

**`./zadanie21 4`**:

```
Liczba jest parzysta!
```

**`./zadanie21 21`**:

```
Liczba musi być z przedziału (4,20)!
```