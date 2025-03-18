# **Benutzerhandbuch Studentenwürfel**

## **1. Einführung**

### **1.1 Zweck des Handbuchs**
Dieses Handbuch beschreibt die Nutzung der Software **Studentenwürfel**. Sie richtet sich an Dozenten und Lehrkräfte generell.

### **1.2 Zielgruppe**
- Lehrkräfte und Dozenten, die Studenten zufällig auswählen möchten.
- Nutzer, die Sitzungsprotokolle führen wollen.

### **1.3 Systemvoraussetzungen**
- Betriebssystem: Windows 10 / macOS / Linux (mindestens Kernel 4.x)
- RAM: Mindestens 512 MB
- Speicherplatz: Mindestens 100 MB

---

## **2. Installation & Einrichtung**

### **2.1 Installation**
1. Laden Sie das Programm aus dem offiziellen GitHub-Repository herunter.
2. Entpacken Sie die Datei in ein Verzeichnis Ihrer Wahl.
3. Führen Sie die ausführbare Datei aus.

### **2.2 Erster Start**
1. Starten Sie die Anwendung.
2. Der Applikationsordner wird automatisch angelegt.
3. Die Software speichert ihre Daten bevorzugt auf dem `H:`-Laufwerk (unter Windows). Falls dieses nicht verfügbar ist, wird stattdessen das Home-Verzeichnis auf `C:` (Windows) bzw. `~/` (Linux/macOS) genutzt.
4. Legen Sie die Klassenlisten in `~/Studentenwuerfel/classes/` ab. Die Dateien müssen im `.csv`-Format vorliegen.
5. Alternativ können Sie über das Optionsmenü eine Klassenliste hinzufügen.

---

## **3. Bedienung der Software**

### **3.1 Hauptfenster**
Im Hauptfenster haben Sie folgende Möglichkeiten:
- Wählen Sie eine bis drei Klassenlisten aus.
- Klicken Sie auf den **Würfel-Button**, um einen Studenten zufällig auszuwählen.
- Fügen Sie einen Studenten manuell ins Protokoll hinzu.

  ![image](https://github.com/user-attachments/assets/123520d8-9ce9-4580-823c-06aa509d9c93)


### **3.2 Optionsmenü**
Über den **Options-Button** gelangen Sie ins Optionsfenster, wo Sie folgende Einstellungen vornehmen können:
- **Regeln aktivieren/deaktivieren** (Checkboxen zur Konfiguration der Auswahlregeln).
- **Eine Klassenliste manuell hinzufügen** (File-Picker für `.csv`-Dateien).
- **Einstellungen speichern** (Speichern-Button).

### **3.3 Erstellung eines Protokolls**
1. Das Programm protokolliert automatisch, welche Studenten in welcher Reihenfolge dran waren.
2. Sie können einen Studenten manuell ins Protokoll eintragen: Geben Sie den Namen ein und klicken Sie auf **Student hinzufügen**.
3. Die Protokolle werden in `~/Studentenwuerfel/protocols/` gespeichert.

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
