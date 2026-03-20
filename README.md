Pentru ex 3:
Codul este de tip consola in care un utilizator
isi poate gestiona notitele (le poate crea, vedea, deschide dupa ID si sterge).
Am o clasa `Note` care reprezinta o notita (cu un id generat automat din UUID,
autorul, continutul si data/ora la care a fost creata), apoi am definit o interfata `NoteRepository`
unde am pus operatiile de baza (save, getAll, delete, getById), ca sa pot schimba usor modul de
stocare daca vreau pe viitor. Apoi folosesc `FileNoteRepository`, care salveaza
fiecare notita ca fisier `.txt` intr-un folder local ("notes"), scriind in fisier autorul,
timestamp-ul si continutul; la citire, reconstruiesc obiectele `Note` din fisiere. Logica aplicatiei
este in `NoteManager`, care e un fel de intermediar intre repository si interfata (nu face ceva complicat,
dar ajuta la organizare si la separarea logicii de UI). Interfata cu utilizatorul este `NoteApp`, unde
am un meniu in consola cu optiuni numerotate (listare, incarcare, creare, stergere, iesire), si folosesc
un `Scanner` pentru input. In `main` doar initializez tot (repository → manager → aplicatie) si pornesc
aplicatia cu un user hardcodat. Per total, am incercat sa fac codul cat mai modular si usor de extins
(de exemplu, as putea schimba usor stocarea din fisiere in baza de date fara sa modific restul aplicatiei).


