Pentru ex 3:
  Aplicația mea este o aplicație simplă de tip consolă în care un utilizator 
  își poate gestiona notițele (le poate crea, vedea, deschide după ID și șterge). 
  Practic, am pornit de la ideea de a separa responsabilitățile: 
  am o clasă `Note` care reprezintă o notiță (cu un id generat automat din UUID, 
  autorul, conținutul și data/ora la care a fost creată), apoi am definit o interfață `NoteRepository` 
  unde am pus operațiile de bază (save, getAll, delete, getById), ca să pot schimba ușor modul de 
  stocare dacă vreau pe viitor. Apoi folosesc `FileNoteRepository`, care salvează 
  fiecare notiță ca fișier `.txt` într-un folder local („notes”), scriind în fișier autorul, 
  timestamp-ul și conținutul; la citire, reconstruiesc obiectele `Note` din fișiere. Logica aplicației 
  este în `NoteManager`, care e un fel de intermediar între repository și interfață (nu face ceva complicat, 
  dar ajută la organizare și la separarea logicii de UI). Interfața cu utilizatorul este `NoteApp`, unde 
  am un meniu în consolă cu opțiuni numerotate (listare, încărcare, creare, ștergere, ieșire), și folosesc 
  un `Scanner` pentru input. În `main` doar inițializez tot (repository → manager → aplicație) și pornesc 
  aplicația cu un user hardcodat. Per total, am încercat să fac codul cât mai modular și ușor de extins 
  (de exemplu, aș putea schimba ușor stocarea din fișiere în bază de date fără să modific restul aplicației).

