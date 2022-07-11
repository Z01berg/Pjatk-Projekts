# Zadanie 7

Napisz skrypt, który pobierze dwa argumenty. Jeżeli oba są katalogami do odczytu to porównujemy ich zawartość. Jak ich zawartość jest taka sama to wyświetlamy 1 - uwaga porównujemy liczbę plików, ich nazwy i ich zawartość. 

Uwaga: aby porównać zawartość dwóch plików użyjmy polecenia `cmp plik1 plik2`. 

- Jeżeli pliki te są takie same to cmp nic nie wyświetli i zwróci wartość 0. 
- Jeżeli katalog 1 nie zawiera ani jednego pliku z katalogu 2 to wyświetlamy 2. 
- Jak zawiera przynajmniej jeden plik to wyświetlamy 3.
- Jeżeli ich zawartość pod każdym względem (ilość plików, nazwy plików i ich zawartość) jest identyczna, to wyświetlamy OK
- Jeżeli się czymś różnią to wyświetlamy czym się różnią, czy ilością plików, nazwami plików czy zawartością plików i kończymy skrypt. 