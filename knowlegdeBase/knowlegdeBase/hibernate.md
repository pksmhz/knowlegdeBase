# Hibernate

Kiedy pobieramy listę użytkowników i chcemy także pobrać powiązane z nimi adresy (np. korespondencyjny, zamieszkania), w domyślnej konfiguracji Hibernate dla każdej kolekcji adresów wykona dodatkowe zapytanie (per użytkownik). Jeśli chcemy pobrać listę 100 użytkowników to Hibernate wykona jedno zapytanie, żeby pobrać użytkowników (1 – zapytanie) i jeśli odczytamy dodatkowo dla każdego użytkownika listę adresów, to Hibernate wykona dodatkowo 100 zapytań po jednym dla każdego użytkownika (n – zapytań, gdzie n oznacza ilość użytkowników w tym przypadku 100).



@OneToOne – FetchType.EAGER
@OneToMany – FetchType.LAZY
@ManyToOne – FetchType.EAGER
@ManyToMany – FetchType.LAZY



3. Fetch Mode
   FetchMode ustawiamy za pomocą adnotacji np. @Fetch(FetchMode.JOIN)

Domyślnie encje powiązane pobierane są poprzez FetchMode.SELECT (tak, jak opisałem to w punkcie 1). Tryb ten można dodatkowo sparametryzować używając adnotacji @BatchSize(size = 25). Sprawia to, że powiązane encje będą pobierane dodatkowymi zapytaniami, ale każde zapytanie będzie pobierało określoną ilość powiązanych encji (np. 25, w sqlu, który generuje Hibernate jest to odwzorowane za pomocą klauzuli in(...))

Poza domyślnym sposobem pobierania relacji są jeszcze dwa: FetchMode.JOIN i FetchMode.SUBSELECT

FetchMode.JOIN sprawia, że powiązane kolekcje są pobierane wraz z główną encją i dzieje się to poprzez użycie klauzuli JOIN w sqlu. Dodatkowo musimy zapewnić unikalność zwróconych rezultatów stosując np. Set.

FetchMode.SUBSELECT jest ustawieniem, dzięki któremu Hibernate jednym zapytaniem pobiera listę encji np. użytkowników, a kolejne zapytanie pobiera listę wszystkich powiązanych encji np. adresów. Przy czym są pobierane wszystkie adresy, bez względu na to, czy został pobrany odpowiedni użytkownik dla danego adresu.

Główna różnica, która odróżnia FetchType od FetchMode jest to, że FetchType dotyczy tego czy pobrać daną encję, a FetchMode tego jak pobrać daną encję w relacji.



Optimistic Locking is a strategy where you read a record, take note of a version number (other methods to do this involve dates, timestamps or checksums/hashes) and check that the version hasn't changed before you write the record back. When you write the record back you filter the update on the version to make sure it's atomic. (i.e. hasn't been updated between when you check the version and write the record to the disk) and update the version in one hit.

If the record is dirty (i.e. different version to yours) you abort the transaction and the user can re-start it.

This strategy is most applicable to high-volume systems and three-tier architectures where you do not necessarily maintain a connection to the database for your session. In this situation the client cannot actually maintain database locks as the connections are taken from a pool and you may not be using the same connection from one access to the next.

Pessimistic Locking is when you lock the record for your exclusive use until you have finished with it. It has much better integrity than optimistic locking but requires you to be careful with your application design to avoid Deadlocks. To use pessimistic locking you need either a direct connection to the database (as would typically be the case in a two tier client server application) or an externally available transaction ID that can be used independently of the connection.

In the latter case you open the transaction with the TxID and then reconnect using that ID. The DBMS maintains the locks and allows you to pick the session back up through the TxID. This is how distributed transactions using two-phase commit protocols (such as XA or COM+ Transactions) work.



In contrast to optimistic locking, JPA gives us pessimistic locking. It's another mechanism for handling concurrent access for data.

We cover pessimistic locking in one of our previous articles — Pessimistic Locking in JPA. Let's find out the difference between them and how we can benefit from each type of locking.

As we've said before, optimistic locking is based on detecting changes on entities by checking their version attribute. If any concurrent update takes place, OptmisticLockException occurs. After that, we can retry updating the data.





