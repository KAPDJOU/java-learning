
* Select customer without order
You may want to use LEFT JOIN and IS NULL:

```sql
    SELECT  Persons.LastName, Persons.FirstName
        FROM Persons
            LEFT JOIN Orders ON Persons.id = Orders.Person_id
            WHERE  Orders.Person_id IS NULL;
```

or

```sql
    select * from persons 
        where person.id not in (select person_id from purchase_order)
```

```sql
    select * from persons p 
        where not exists (select null from orders o where o.person_id = p.id)
```


* Calcul binaire

https://openclassrooms.com/fr/courses/1214196-les-calculs-en-binaire 

result of 0001 and 0001

0001 + 0001 = 0010 


* java ascii printchar scanchar

TODO

* garbage collector garanti la mémoire ?

* Largest number in array numbers

* Java Quel fonction est appelé lorsqu'on éxécute un thread ?

exec()
do()
..


* singleton, exemple d'implémentation et de recupération d'une classe; 