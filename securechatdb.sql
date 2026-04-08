-- ==========================================
-- Création de la base
-- ==========================================
CREATE DATABASE IF NOT EXISTS quizmasternet;
USE quizmasternet;

-- ==========================================
-- Table : students
-- ==========================================
CREATE TABLE IF NOT EXISTS students (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cne VARCHAR(20) UNIQUE,
    password VARCHAR(50),
    fullname VARCHAR(100)
);

-- ==========================================
-- Table : questions
-- ==========================================
CREATE TABLE IF NOT EXISTS questions (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    question TEXT,
    optionA TEXT,
    optionB TEXT,
    optionC TEXT,
    optionD TEXT,
    correctOption CHAR(1)
);

-- ==========================================
-- Table : scores
-- ==========================================
CREATE TABLE IF NOT EXISTS scores (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    studentId INTEGER,
    score INTEGER,
    examDate DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================
-- INSERTION DES 20 QUESTIONS JAVA
-- ==========================================
INSERT INTO questions (question, optionA, optionB, optionC, optionD, correctOption) VALUES
('Quelle est la sortie de : System.out.println(3 + 2 + \"Java\");',
 '5Java', '32Java', 'Java32', 'Erreur de compilation', 'A'),

('Quel est le type de retour de la méthode main ?',
 'int', 'void', 'String', 'Object', 'B'),

('Quel mot-clé permet d’hériter d’une classe en Java ?',
 'implements', 'this', 'extends', 'inherits', 'C'),

('Dans une interface Java, les méthodes sont par défaut :',
 'privées', 'statiques', 'abstraites', 'finales', 'C'),

('Que signifie JVM ?',
 'Java Variable Machine', 'Java Virtual Machine', 'Java Vendor Module', 'Java Verified Memory', 'B'),

('Quelle structure empêche les valeurs dupliquées ?',
 'ArrayList', 'HashSet', 'LinkedList', 'Vector', 'B'),

('Que fait “new” en Java ?',
 'Crée une classe', 'Appelle un constructeur', 'Détruit un objet', 'Importe un package', 'B'),

('Quelle est la taille d’un int en Java ?',
 '8 bits', '16 bits', '32 bits', '64 bits', 'C'),

('Quel package contient la classe Scanner ?',
 'java.lang', 'java.io', 'java.util', 'javax.scanner', 'C'),

('Une classe abstraite peut-elle avoir un constructeur ?',
 'Oui', 'Non', 'Seulement si final', 'Seulement si static', 'A'),

('Que fait la méthode equals() ?',
 'Compare le contenu', 'Compare les références', 'Supprime l’objet', 'Calcule le hashCode', 'A'),

('Quel mot-clé empêche l’héritage ?',
 'private', 'abstract', 'final', 'static', 'C'),

('Quelle exception est levée pour un accès hors limite d’un tableau ?',
 'NullPointerException', 'ArrayIndexOutOfBoundsException', 'IllegalArgumentException', 'IOException', 'B'),

('Dans une HashMap, que représentent les éléments ?',
 'Des valeurs', 'Des clés', 'Des couples clé → valeur', 'Des index', 'C'),

('Quel est le rôle de “this” ?',
 'Référence l’objet actuel', 'Référence l’objet parent', 'Crée un nouvel objet', 'Importe une classe', 'A'),

('Quel est le résultat de : System.out.println(\"A\" + 1);',
 'Erreur', 'A1', '1A', 'Compilation impossible', 'B'),

('Une interface peut contenir :',
 'Des attributs publics statiques finals', 'Des attributs privés', 'Des attributs protégés', 'Des constructeurs', 'A'),

('Quel mot-clé est utilisé pour gérer les exceptions ?',
 'try/catch', 'throw only', 'assert', 'override', 'A'),

('Une classe peut-elle implémenter plusieurs interfaces ?',
 'Oui', 'Non', 'Seulement deux', 'Seulement si abstract', 'A'),

('Quelle est la sortie de : System.out.println(10/3);',
 '3.333', '3', '3.0', 'Erreur', 'B');
