Pentru ex 3:
Codul este de tip consola in care un utilizator
isi poate gestiona notitele (le poate crea, vedea, deschide dupa ID si sterge).
Am o clasa Note care reprezinta o notita (cu un id generat automat din UUID,
autorul, continutul si data/ora la care a fost creata), apoi am definit o interfata NoteRepository
unde am pus operatiile de baza (save, getAll, delete, getById), ca sa pot schimba usor modul de
stocare daca vreau pe viitor. Apoi folosesc FileNoteRepository, care salveaza
fiecare notita ca fisier .txt intr-un folder local ("notes"), scriind in fisier autorul,
timestamp-ul si continutul; la citire, reconstruiesc obiectele Note din fisiere. Logica aplicatiei
este in NoteManager, care e un fel de intermediar intre repository si interfata (nu face ceva complicat,
dar ajuta la organizare si la separarea logicii de UI). Interfata cu utilizatorul este NoteApp, unde
am un meniu in consola cu optiuni numerotate (listare, incarcare, creare, stergere, iesire), si folosesc
un Scanner pentru input. In main doar initializez tot (repository → manager → aplicatie) si pornesc
aplicatia cu un user hardcodat. Per total, am incercat sa fac codul cat mai modular si usor de extins
(de exemplu, as putea schimba usor stocarea din fisiere in baza de date fara sa modific restul aplicatiei).


Pentru ex 2:
Codul simuleaza cumpararea de bilete la film, unde ideea principala este ca se poate plati folosind metode 
diferite (card sau cash). Am o clasa Bilet (in loc de Movie) care retine doar titlul filmului si pretul biletului. 
Apoi este partea de Plata, unde am interfata PaymentMethod, care defineste metoda pay(amount), astfel incat orice 
tip de plata trebuie sa implementeze aceasta functionalitate. Am doua implementari: CardPayment, care foloseste un
BankAccount si scade suma din cont (daca exista suficienti bani), si CashPayment, unde verific daca suma disponibila 
cash este suficienta si o scad daca plata reuseste. Clasa BankAccount tine datele unui card (numar, expirare, cvv, nume) 
si gestioneaza suma disponibila prin metoda updateAmount, care nu permite sa ajung sub 0. Logica de cumparare efectiva 
este tot in zona de Plata (prin TicketService), care primeste o metoda de plata si incearca sa faca plata pentru un film; 
in functie de rezultat, afiseaza daca biletul a fost cumparat sau daca plata a esuat. In Main, se creeaza un film, apoi 
se testeaza doua scenarii: unul cu plata cu cardul (unde am suficienti bani) si unul cu cash (unde nu am destui bani), 
ca sa se vada diferenta. Per total, ideea principala a fost sa folosesc interfata pentru a putea schimba usor metoda de 
plata fara sa modific logica din TicketService. 


Pentru ex 1:
Ideea principala e ca pot lua continut de pe un URL si apoi sa-l procesez in moduri diferite, in functie de 
parserul ales. Clasa Crawler primeste un URL si are metoda getResource(), care foloseste biblioteca Jsoup ca 
sa faca request catre site si sa ia continutul brut (indiferent de tip, pentru ca folosesc ignoreContentType(true)); 
daca apare vreo eroare, o prind si returnez un mesaj simplu. Dupa asta, metoda processContent(parser: Parser) ia 
continutul descarcat si il trimite catre un parser, fara sa stie exact cum va fi procesat. Interfata Parser defineste 
metoda parse(text), iar eu am trei implementari: JsonParser, XmlParser si YamlParser, fiecare simuland parsarea pentru
un tip diferit de date (in realitate doar afisez un mesaj si intorc un map cu tipul si primele 20 de caractere din continut). 
In main, creez un crawler pentru un URL (ex: google.com), aleg un parser (in cazul asta JSON) si apelez processContent, 
iar rezultatul este afisat in consola. Practic, ideea principala a fost sa separ partea de „luat datele de pe internet” 
de partea de „interpretat datele”, astfel incat sa pot schimba parserul foarte usor fara sa modific codul din crawler.


