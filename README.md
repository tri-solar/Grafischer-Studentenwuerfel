# **Benutzerhandbuch Studentenwürfel**

## **1. Einführung**

### **1.1 Zweck des Handbuchs**
Dieses Handbuch beschreibt die Nutzung der Software Studentenwürfel. Sie richtet sich an Dozenten und Lehrkräfte, die eine einfache Möglichkeit benötigen, 
Studenten zufällig auszuwählen und Sitzungsprotokolle zu führen.

### **1.2 Zielgruppe**
- Lehrkräfte und Dozenten, die Studenten zufällig auswählen möchten.
- Nutzer, die Sitzungsprotokolle führen wollen.

### **1.3 Systemvoraussetzungen**
Damit die Software reibungslos funktioniert, müssen folgende Systemvoraussetzungen erfüllt sein:
- Betriebssystem: Windows 10 oder höher, macOS, Linux (mindestens Kernel 4.x)
- Arbeitsspeicher (RAM): Mindestens 512 MB
- Speicherplatz: Mindestens 100 MB freier Speicherplatz

---

## **2. Installation & Einrichtung**

### **2.1 Installation**
1. Laden Sie das Programm für ihr Betriebsystem aus dem offiziellen GitHub-Repository herunter.
   Dafür drücken Sie auf `Code` und danach `Download ZIP`:
   
![image](https://github.com/user-attachments/assets/0b070c0d-bafd-41d2-b781-9b55269f6ba7)


   Wir bieten Windows und Linux builds an, für macOS kann das [Projekt selbst gebaut](https://www.jetbrains.com/help/idea/javafx.html#package-app-with-jlink) werden.
   
3. Entpacken Sie die Datei aus dem build Ordner in ein Verzeichnis Ihrer Wahl.
4. Führen Sie die app.bat (Windows) oder app (Linux) Datei aus.

### **2.2 Erster Start**
1. Starten Sie die Anwendung.
2. Der Applikationsordner wird automatisch angelegt.
3. Die Software speichert ihre Daten bevorzugt auf dem `H:`-Laufwerk (unter Windows). Falls dieses nicht verfügbar ist, wird stattdessen das Home-Verzeichnis des Nutzers bzw. `~/home/$USER` (Linux/macOS) genutzt.
   
   ![image](https://github.com/user-attachments/assets/9ab8b392-bfe7-42f9-81c5-bc18d1def550)

4. Legen Sie die Klassenlisten in `~/Studentenwuerfel/classes/` ab. Die Dateien müssen wie die Klasse heißen, im `.csv`-Format sein und UTF-8 kodiert vorliegen.
Beispiel Aufbau einer Klassendatei:
`PBBFA23A.csv`
```
Vorname,Nachname
Max,Mustermann
Marcel,Davis
```   

6. Alternativ können Sie über das Optionsmenü eine Klassenliste hinzufügen.

---

## **3. Bedienung der Software**

### **3.1 Hauptfenster**
![image](https://github.com/user-attachments/assets/022eb6f3-284a-4be6-9506-c992e8c95ff5)

Im Hauptfenster haben Sie folgende Möglichkeiten:
- Wählen Sie eine bis drei Klassenlisten aus.
- Klicken Sie auf den **Würfel-Button**, um einen Studenten zufällig auszuwählen.
- Fügen Sie einen Studenten manuell ins Protokoll hinzu.
  
 ![image](https://github.com/user-attachments/assets/f8261ae0-cb8b-40bd-999f-78cb85aada56)
- Wenn sie einige Klassen gewählt haben, wird ihnen die jeweilige Anzahl der Studenten angezeigt.

### **3.2 Optionenmenü**
![image](https://github.com/user-attachments/assets/5f1cc44f-8cfd-4378-82ab-c8fbdd71116a)

Über den **Options-Button** gelangen Sie ins Optionsfenster, wo Sie folgende Einstellungen vornehmen können:
- **Regeln aktivieren/deaktivieren** (Checkboxen zur Konfiguration der Auswahlregeln).
- **Datei wählen** (öffnet einen File-Picker für `.csv`-Dateien).
- **Speichern & Schließen** (Speichert die gewählten Optionen und schließt das Fenster).

![image](https://github.com/user-attachments/assets/2e45cb49-b336-48b7-b5b7-591207e5158b)
- Der Name der gewählten Datei wird ihnen angezeigt.
- **Klasse hinzufügen** (Speichert die auswahl der gezeigten Liste).

### **3.3 Erstellung eines Protokolls**
1. Das Programm protokolliert automatisch, welche Studenten in welcher Reihenfolge dran waren.
2. Auf dem Hauptfenster können Sie Studenten manuell ins Protokoll eintragen: Geben Sie den Namen ein und klicken Sie auf **Student hinzufügen**.

![image](https://github.com/user-attachments/assets/229cf7ff-675d-4a1c-8f8e-60cac5f66e37)

4. Die Protokolle werden in `~/Studentenwuerfel/protocols/` gespeichert. Sie beinhalten die Klasse des Studenten und den Namen.

---

## **4. Fehlerbehebung & Support**

### **4.1 Häufige Probleme & Lösungen**
| Problem | Lösung |
|---------|--------|
| Software startet nicht | Überprüfen Sie die Systemvoraussetzungen und führen Sie eine Neuinstallation durch. |
| Es werden keine Klassen eingelesen | Prüfen Sie den Ordner, ob die Dateien korrekt abgelegt und im `.csv`-Format sind. |
| Die gleichen Studenten werden mehrfach nacheinander ausgewählt | Aktivieren Sie im Optionsmenü die entsprechende Regel zur Vermeidung von Wiederholungen. |

### **4.2 Kontakt & Support**
- Offizielle Support-Seite: [Support-Website](https://www.xyz.com/support)
- E-Mail-Support: support@xyz.com
- Telefon-Hotline: +49 123 456 789

---

### **5 Versionshistorie**
- **Version 1.0** – Erste Veröffentlichung
