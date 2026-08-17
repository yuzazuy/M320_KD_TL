### Repetition

### Unterschied OOP und Prozedural

### Prozedural
> Problemlösung mit Prozeduren
> Prozedur = Reihenfolgebasierte Anweisungen
>> Verwenden Variablen, Entscheidungen und Schleifen
>> Sub-Routinen/Funktionen möglich bzw. Aufteilung in Module (vgl. Header-files in C)
>> Vorteil: Eine Funktion mehrere Mal abrufbar
>> ZB Taschenrechner in M319
>> Generell Top-Down

### OOP
> Fokus Problemlösung auf Elemente in realer Welt beziehen und Verhalten darstellen
> Objekt = Datenstruktur, die realem Objekt ähnlich ist
>> Enthalten Datenfelder, Methoden, Attribute
>> Zustand und Verhalten
>> Komplexität variabel
>> Objekt ist Instanz einer Klasse eines Datentyps
> Datenabstraktion
>> Programmiermethode, bei der Details des Programmiercodes vor Benutzer verborgen wird und nur wesentliche Dinge dem Benutzer angezeigt werden
>> Eher Ideen als Ereignisse
>> Vgl Browser, Code im Hintergrund
>> Abstrakte Klassen oder Schnittstellen in Java und Python
> Kapselung
>> Programmierstiel, bei dem Implementierungsdetails ausgeblendet sind
>> Reduktion Komplexität massiv
>> nur Methoden verfügbar
>> Umgesetzt mit Erstellung privater Variablen, in denen versteckte Klassen definiert werden und dann in öffentliche Variablen zu Verwendung eingesetzt werden
>>> Klassen so aktualisiert oder gepflegt ohne Methoden im blick behalten müssen
>>> fast wie Bibliotheken importieren
>> Zur Abschirmung Zugriff auf Daten durch externen Code, erzwingt Bindung Daten und Code als Einheit und erzwingt so Modularität
> Polymorphie
>> Variablen, Funktionen und Objekte können in mehreren Formen vorhanden sein
>>> Laufzeitpolymorphismus
>>>> ändert Form während Ausführung der Anwendung
>>> Kompilierzeitpolymorphismus
>>>> ändert Form während Kompilierung
>> Bsp.: Cursorverhalten
>> Methode oder Unterklasse kann Verhalten und Attribute definieren, während Funktionalität übergeordnete Klasse beibehält
> Messaging
>> Einem Objekt kommunizieren, etwas spezifisches zu tun
>> Kommunikation zwischen Objekten
>> idR Methoden-Aufruf
> Modularität
>> Baukastenprinzip, Programme aufgeteilt in Funktionalitäten, Schnittstellen, Typen, Variablen, Konstanten, Prozeduren, Funktionen
>> Kapselung ist eine Form der Modularität
> Vererbung
>> Klassenhierarchie erstellbar
>> Eigenschaften einer Klasse können von anderen Klassen oder Funktionen vererbt und erweitert werden
>> Attribute einer höher gestellten Klasse kann an eine untergeordnete Klasse vererbt werden
> Flexibel und sehr wartbar, Modularität
>> Wiederverwendbarkeit von Klassen erlaubt Programmierung ohne Code-Recyclings
> Schlussendlich 2 Programmierparadigmen
>> Programmierparadigma = Grundlegender Stil der Programmierung


### Zentrale Erkenntnisse:

* Paradigmendiskrepanz: Viele Java-Enterprise-Anwendungen nutzen zwar Klassen und Vererbung, sind jedoch prozedural entworfen (Services operieren auf reinen Datenobjekten).
* Fehlinterpretation von POJOs: "Plain Old Java Objects" wurden ursprünglich als Träger von Businesslogik konzipiert, werden heute jedoch meist als bloße Datenbehälter mit Gettern und Settern (Anemic Domain Models) verwendet.
* Architektonische Werkzeuge: Zur Förderung eines echten OO-Designs sind Methoden wie CRC-Karten (Class Responsibility Collaboration) oder Verhaltensmodelle sinnvoller als rein datenzentrierte Klassendiagramme.
* Pragmatismus: Die Anerkennung eines prozeduralen Umfelds kann helfen, Entscheidungen (z. B. Nutzung von Utility-Klassen oder Verzicht auf unnötige Getter/Setter) bewusster und wartungsfreundlicher zu treffen.

### Analyse der Programmierparadigmen

Ein Programmierparadigma definiert den grundlegenden Stil und die Herangehensweise an die Problemlösung in der Informatik. Die untersuchten Quellen grenzen die prozedurale und die objektorientierte Programmierung wie folgt ab:

### Vergleich der Kernkonzepte

| Merkmal	| Prozedurale Programmierung | Objektorientierte Programmierung (OOP) |
| --- | --- | --- |
| Fokus	| Zerlegung in Variablen, Datenstrukturen und Unterprogramme (Prozeduren) |	Zerlegung in Objekte, die Daten und Verhalten kapseln |
| Struktur | Trennung von Daten und den darauf angewendeten Methoden | Bündelung von Daten und Methoden ("Object operates on its own data") |
| Entwurf	| Top-Down Design: Systematische funktionale Dekomposition von Problemen in Teilprobleme | Abstraktion: Modellierung der realen Welt durch Klassen und Objekte |
| Einheiten |	Module, Prozeduren, Funktionen, Subroutinen |	Klassen, Objekte, Schnittstellen (Interfaces) |
| Zustand	| Global oder über Parameter an Prozeduren übergeben | In Datenfeldern (Attributen) innerhalb der Objekte gespeichert |

### Die Realität in der Java-Enterprise-Entwicklung

Obwohl Java als objektorientierte Sprache gelehrt wird, weisen Enterprise-Codebasen oft ein prozedurales Design auf. Dies zeigt sich insbesondere in der Verwendung von Services und POJOs.

### Das Service-Modul-Muster

In vielen Projekten werden "Services" als Sammlungen von Routinen verwendet, die auf Datenobjekten operieren. Technisch gesehen handelt es sich hierbei um Singletons, die prozedurale Module repräsentieren. Die Datenhaltung ist dabei strikt von der Logik getrennt.

### Das POJO-Missverständnis

Der Begriff POJO (Plain Old Java Object) wurde im Jahr 2000 geprägt, um die Nutzung regulärer Java-Objekte anstelle komplexer Entity Beans für die Businesslogik zu fördern.

* Ursprüngliche Intention: Objekte als Einheit aus Daten und Verhalten (Kapselung).
* Heutige Praxis: POJOs werden oft nur als Ansammlung von privaten Feldern mit öffentlichen Gettern und Settern verwendet. In der Praxis ist dies keine echte Kapselung, sondern Makulatur, da externe Klassen vollen Zugriff auf den internen Zustand haben.

### Herausforderungen und Lösungsstrategien

### Umgang mit Null-Werten und "Neutralen Objekten"

Ein häufiges Problem in prozedural geprägtem Code sind überstreute Null-Tests oder drohende NullPointerExceptions.

* Das Problem: Die Zuweisung von null verschiebt die Entscheidung über das Systemverhalten an die Verwendungsstelle.
* Die Lösung: Die Implementierung von Neutralen Objekten (Null-Objekten). Diese Instanzen verhalten sich neutral (z. B. ein leerer String oder eine leere Collection), wodurch Methodenaufrufe ohne explizite Prüfung sicher ausgeführt werden können.

### Utility-Klassen vs. OO-Design

In prozeduralen Umgebungen entstehen oft Utility-Klassen (z. B. in commons-Packages), um DRY-Prinzipien (Don't Repeat Yourself) umzusetzen. Aus OO-Sicht ist dies oft fragwürdig, da die Logik eigentlich in die Datenobjekte selbst gehört. Werden statische Hilfsmethoden (wie String.isEmpty) genutzt, folgt man faktisch einem prozeduralen Ansatz.

### Test-Driven Development (TDD) vs. Test-First

* Test-First: Ein prozeduraler Ansatz, bei dem die Implementierung (z. B. Interfaces und Services) vorab feststeht und lediglich vorab getestet wird.
* Echtes TDD: Das Design ergibt sich aus den Tests. Man überlegt, welche Nachricht an welches Objekt gesendet werden muss, um ein Ergebnis zu erhalten. Dies fördert echtes objektorientiertes Design.

### Methodik für besseres Objekt-Design

Um über die Grenzen rein datenzentrierter Entwürfe hinauszugehen, werden folgende Methoden empfohlen:

1. CRC-Karten (Class Responsibility Collaboration):
  * Ein Brainstorming-Werkzeug zur Ermittlung der Verantwortlichkeiten einer Klasse.
  * Fokus auf die Frage: "Mit wem muss diese Klasse zusammenarbeiten, um ihre Aufgabe zu erfüllen?" anstatt "Welche Daten hält sie?".
2. Sequenzdiagramme:
  * Visualisierung des Nachrichtenflusses zwischen Objekten zur Laufzeit.
3. Verhaltensfokus:
  * Identifikation von Zustand und Verhalten realer Objekte und deren Abbildung in Software-Objekte.

### Fazit

Java muss nicht zwingend rein objektorientiert programmiert werden, um erfolgreich zu sein. Die prozedurale Programmierung ist in der Praxis weit verbreitet und funktioniert seit Jahrzehnten. Entscheidend ist die bewusste Wahl des Paradigmas:

* Wartbarkeit: OOP bietet Vorteile durch Wiederverwendbarkeit und Vererbung, kann aber bei falscher Anwendung (übermäßige Getter/Setter) an Komplexität gewinnen.
* Transparenz: Entwickler sollten hinterfragen, ob sie Konventionen (wie Getter/Setter) nur aus Gewohnheit folgen oder ob sie einen echten architektonischen Nutzen bringen.
* Pragmatismus: In einem prozeduralen Umfeld können statische Methoden und Utility-Klassen sinnvolle Werkzeuge sein, sofern man sich ihrer Rolle im Gesamtsystem bewusst ist.
