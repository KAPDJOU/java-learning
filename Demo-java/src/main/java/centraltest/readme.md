* Que se passe-t-il si vous tentez de compiler et d'exécuter le code suivant : 

---

```java

class Base {
    private static int iAge = 3;
}

public class Berniebron extends Base {

    public int iAge = 10;

    public static void main(String argv[]) {
        Berniebron bb = new Berniebron();
        bb.go();
    }

    public void go() {
        int iOutput = calc(2);
        System.out.println(iOutput * Base.iAge);
    }

    public int calc(int iAge) {
        return (this.iAge * iAge);
    }
}
```

A: The field Base.iAge is not visible form Berniebron child class


* Que se passe-t-il si vous tentez de compiler et d'exécuter le code suivant : 

---

```java
interface Bramley {
}

class Base implements Bramley {

    short s = 10;

    public int getSize() {
        return s;
    }
}

public class Broadlea {

    public static void main(String argv[]) {
        Broadlea b = new Broadlea();
        System.out.println(b.go().getSize());
    }

    public Base go() {
        Base b = new Base();
        return b;
    }
}
```

A : OUI, return 10


* Un constructeur peut être déclaré "static". 

---

Veuillez sélectionner seulement une réponse ci-dessous
Vrai
Faux
Je ne réponds pas

ANSWER : Faux



* Toutes les exception héritent de : 

---

Veuillez sélectionner seulement une réponse ci-dessous
java.lang.Exception
java.lang.Error
java.lang.Throwable
Je ne réponds pas

ANSWER : Throwable


* Le code ci-dessous compile-t-il sans erreur ? 

```java
public class Outer {

    int x;

    static class Inner {

        void foo() {
            x = 5;
        }
    }
}
```

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas

ANSWER : NON, Cannot make a static reference to the non-static field x


* Que se passe-t-il si vous tentez de compiler et d'exécuter le code suivant :

```java
public class MyIf {

    boolean b;

    public static void main(String argv[]) {
        MyIf mi = new MyIf();
    }

    MyIf() {
        if (b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
```


Veuillez sélectionner seulement une réponse ci-dessous :

Erreur de compilation : la variable b n'a pas été initialisée.
Compilation et affichage de "true" à l'exécution.
Compilation et affichage de "false" à l'exécution.
Je ne réponds pas

ANSWER : false


* Considérons que les variables sont déclarées et initialisées correctement, est-ce que le code suivant compile ? 

```
for( i = 1; k < 5; j++){};
```

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas


ANSWER : OUI

* Que se passe-t-il si vous tentez de compiler et d'exécuter le code suivant :

```
class Base {
}

class Sub extends Base {
}

class Sub2 extends Base {
}

public class CEx {

    public static void main(String argv[]) {
        Base b = new Base();
        Sub s = (Sub) b;
    }
}
```


Veuillez sélectionner seulement une réponse ci-dessous
Compile et s'exécute sans erreur.
Exception à la compilation.
Exception à l'exécution.
Je ne réponds pas

ANSWER : Exception à l'exécution. cannot casting a parent into a children

Upcasting is casting to a supertype, while downcasting is casting to a subtype. Upcasting is always allowed, but downcasting involves a type check and can throw a ClassCastException

https://stackoverflow.com/questions/23414090/what-is-the-difference-between-up-casting-and-down-casting-with-respect-to-class



* Que se passe-t-il si vous tentez de compiler et d'exécuter le code suivant :

```java
abstract class Hall {
    public abstract void getFireStation();
}

public class Haddon extends Hall {

    public static void main(String argv[]) {
        new Haddon().getFireStation();
    }

    public synchronized void getFireStation() {
        System.out.print("opposite");
    }
}
```


Veuillez sélectionner seulement une réponse ci-dessous
Erreur de compilation : synchronized ne peut être utilisé que dans une classe qui étend Thread.
Erreur de compilation : la méthode getFireStation de la classe Hall n'est pas correctement définie.
Compilation et affichage de "opposite" à l'exécution.
Erreur de compilation : le code de la méthode main n'est pas correct.
Je ne réponds pas

ANSWER : Compilation et affichage de "opposite" à l'exécution.


* S'il y a une instruction "return" dans un bloc "catch", le block finally ne s'exécutera pas. 

Veuillez sélectionner seulement une réponse ci-dessous
Vrai
Faux
Je ne réponds pas


ANSWER : FAUX; 

https://code.i-harness.com/fr/q/fe0b

Le bloc finally est toujours exécuté à moins qu'il n'y ait une terminaison de programme anormale, résultant soit d'un plantage JVM, soit d'un appel à System.exit(0) .


* Qu'obtenez-vous après la compilation et l'exécution du code suivant ? 

```java
public class MaClasse {

    static int j = 20;

    public static void main(String[] args) {
        int i = 10;
        MaClasse c = new MaClasse();
        c.methode(i);
        System.out.println(i);
        System.out.println(j);
    }

    public void methode(int x) {
        x = x * 2;
        j = j * 2;
    }
}
```


Veuillez sélectionner seulement une réponse ci-dessous
20 et 40
10 et 40
10 et 20
Je ne réponds pas


ANSWER : 10 et 40


* Un constructeur peut être déclaré "abstract". 

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas


ANSWER : NON


* Etant donné les déclarations de variables suivantes : 

```
String s = "Hello"; 
long l = 99; 
double d = 1.11; 
int i = 1; 
int j = 0;  
```

Quelles sont les lignes qui compilent sans erreurs ? 

Veuillez sélectionner seulement une réponse ci-dessous
1, 4 et 5
1, 2, 4, 5
Toutes
Je ne réponds pas

ANSWER : Toutes

* Est-ce que le code suivant compile sans erreurs ? 

```java
 int iArray[] = new int[] {1,2,3,4,5};
```

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas

ANSWER : OUI

15. Si une variable déclarée comme étant final référence un objet, est-ce que les variables membres de cet objet peuvent être modifiées ? 

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas

ANSWER : NON

Using the "final" keyword makes the the variable you are declaring immutable. Once initially assigned it cannot be re-assigned.
However, this does not necessarily mean the state of the instance being referred to by the variable is immutable, only the reference itself.


14. Lorsque l'on passe comme argument d'une méthode une référence à un objet, que passe-t-on comme argument en réalité ? 

Veuillez sélectionner seulement une réponse ci-dessous
L'objet lui-même.
La référence à l'objet.
La référence d'une copie de l'objet.
Une copie de la référence à l'objet.
Je ne réponds pas

ANSWER :La référence à l'objet

13. Quand un objet est créé à l'aide de new(), son constructeur s'exécute après que tous les constructeurs de toutes les classes de sa hiérarchie supérieure se soient exécutés.

Veuillez sélectionner seulement une réponse ci-dessous
Vrai
Faux
Je ne réponds pas

ANSWER : ?


12. Etant donné : 

Integer a = new Integer(5); 
Integer b = new Integer(5);
 
Quel est le résultat de : if (a == b) ?

Veuillez sélectionner seulement une réponse ci-dessous
true
false
Je ne réponds pas

ANSWER : false
if (a == b) ? | false
if (a.equals(b)) ? | true

11. Un constructeur peut être déclaré "private". 

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas

ANSWER : Oui


10. B redéfinie la méthode maMethode() héritée de la classe A. Si vous écrivez : 

```java
A myA = new B();     
myA.maMethode();  
```

Quelle est la méthode qui est appelée à l'exécution ?

Veuillez sélectionner seulement une réponse ci-dessous
maMethode() définie dans B.
maMethode() définie dans A.
Aucune des deux, cela créé une erreur à la compilation.
Aucune des deux, cela crée une erreur à l'exécution.
Je ne réponds pas

ANSWER : maMethode() définie dans B.

9. Pouvez-vous passer comme argument d'une méthode une variable de type "double" lorsque c'est une variable de type "float" qui est attendue ? 

Veuillez sélectionner seulement une réponse ci-dessous
Oui
Non
Je ne réponds pas




7. Etant donné le code suivant, quelles sont les propositions exactes : 

```java
public abstract class Bolser {

    private int iSize;

    public int getSize() {
        return iSize;
    }
}
```


Veuillez sélectionner seulement une réponse ci-dessous
La classe Bolser ne compile pas car elle ne possède pas de méthode abstraite.
La classe Bolser ne compile pas car seul les méthodes peuvent être marquées comme abstraites pas les classes.
Une classe qui hérite de Bolser doit implémenter la méthode getSize() ou être abstraite.
Une classe qui hérite de Bolser ne doit pas nécessairement implémenter la méthode getSize().
Je ne réponds pas



6. Que signifie la ligne suivante : 
protected int getValue(int value) throws IOException; ?

Veuillez sélectionner seulement une réponse ci-dessous
La méthode getValue lance une exception du type IOException.
La méthode getValue peut lancer une exception du type IOException.
Je ne réponds pas
