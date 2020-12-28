# Practica2Sockets
Pràctica 2: Aplicació Client/Servidor d'un Xat. Client textual

# INTRODUCCIÓ
L'objectiu de la pràctica es dissenyar una aplicació xat amb comunicació entre servidor i client.
El servidor serà l'encarregat de reunir i mostrar els missatges de tots el clients (usuaris) connectats.
Cadascun dels clients estarà representat per un nick vàlid amb el que seran identificats en el xat. Tot seguit s'afegirà a una llista d'ususaris connectats i podrà començar a parlar amb els altres usuaris.
Quan algun usuari vulgui desconnectar-se del xat, haurà d'escriure la paraula 'Marxo'. És la forma que tindrà el programa de saber que aquest usuari vol deixar la conversa i l'eliminarà de la llista d'usuaris connectats al xat, així com informar als altres usuaris a través del servidor que s'ha desconnectat.

#PARTS DE LA PRÀCTICA: CLASSES 
--> MySocket: Classe equivalent a la classe de Java Socket però amb streams de text BufferedReader i     PrintWritter i amb excepcions. Serà la manera de implementar mètodes de lectura i escriptura         de tipus    bàsic. Un socket permet l'implementació d'una arquitectura client-servidor, de tal       manera de que puguin llegir i escriure la informació desitjada i sigui enviada i rebuda per les       dues parts. Per crear un nou socket ha d'estar definit, i és necessari conèixer el host (adreça       IP) i el número de port. 
    També trobem el mètode close(), que s'encarrega d'alliberar els recursos assignats a un socket.       És a dir, s'encarrega d'acabar la connexió existent amb el servidor.

--> MyServerSocket: Classe equivalent a la classe de Java ServerSocket però que encapsuli excepcions.     Serà la classe que permetrà manipular la connexió desde la part del servidor. Aquí es un            trobarem el mètode accept(), el qual s'encarregarà d'acceptar l'intent de creació d'una connexió      des del client. Per tant, crearà un nou socket quan es realitzi una connexió servidor-client per      establir una comunicació. Aquest mètode serà cridat al servidor quan localitzi que un client          sol·liciti realitzar una connexió


socket(): crea un nou socket d'un cert tipus, identificat per un número. És a on el sistema assignarà els recursos


#EXECUC
