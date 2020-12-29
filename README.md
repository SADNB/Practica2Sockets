# PRÀCTICA 2 SAD
Pràctica 2: Aplicació Client/Servidor d'un Xat. Client textual

# INTRODUCCIÓ
L'objectiu de la pràctica es dissenyar una aplicació xat amb comunicació entre servidor i client.
El servidor serà l'encarregat de reunir i mostrar els missatges de tots el clients (usuaris) connectats.
Cadascun dels clients estarà representat per un nick vàlid amb el que seran identificats en el xat. Tot seguit s'afegirà a una llista d'ususaris connectats i podrà començar a parlar amb els altres usuaris.
Quan algun usuari vulgui desconnectar-se del xat, haurà d'escriure la paraula 'Marxo'. És la forma que tindrà el programa de saber que aquest usuari vol deixar la conversa i l'eliminarà de la llista d'usuaris connectats al xat, així com informar als altres usuaris a través del servidor que s'ha desconnectat.

# PARTS DE LA PRÀCTICA
--> MySocket: Classe equivalent a la classe de Java Socket però amb streams de text BufferedReader i     PrintWritter i amb excepcions. Serà la manera de implementar mètodes de lectura i escriptura         de tipus bàsic. Un socket permet l'implementació d'una arquitectura client-servidor, de tal           manera de que puguin llegir i escriure la informació desitjada i sigui enviada i rebuda per les       dues parts. Per crear un nou socket ha d'estar definit, i és necessari conèixer el host (adreça       IP) i el número de port. 
    També trobem el mètode close(), que s'encarrega d'alliberar els recursos assignats a un socket.       És a dir, s'encarrega d'acabar la connexió existent amb el servidor.

--> MyServerSocket: Classe equivalent a la classe de Java ServerSocket però que encapsuli excepcions.     Serà la classe que permetrà manipular la connexió desde la part del servidor. Aquí es un            trobarem el mètode accept(), el qual s'encarregarà d'acceptar l'intent de creació d'una connexió      des del client. Per tant, crearà un nou socket quan es realitzi una connexió servidor-client per      establir una comunicació. Aquest mètode serà cridat al servidor quan localitzi que un client          sol·liciti realitzar una connexió.

--> Client: Estarà creat per dos threads, és a dir, dos fils d'execucció. Un serà per llegir de           teclat el missatge escrit per un usuari en el seu terminal i enviar-ho al servidor per a que així     tingui constancia, i pugui llavors informar a la resta d'usuaris, i l'altre per llegir linies del     servidor de missatges enviats per altres usuaris i imprimir-les en el terminal d'aquest usuari.

--> Server: És la classe principal de la pràctica. És l'encarregat de proporcionar els recursos al       client. Crearem una llista d'usuaris amb la classe ConcurrentHashMap que guardarà els nicks dels     usuaris connectats. Un cop detectada la sol·licitud de connexió per part d'un client/usuari, es       preguntarà per el nick del xat. Si aquest no existeix, es crearà una connexió amb la creació d'un     nou fil d'execució amb una nova connexió entre el servidor i el client nou. Si pel contrari ja       existeix el nick, es tornarà a demanar al usuari que introdueixi un altre. El servidor informarà     del que escriu cada client en el seu terminal i s'escriurà en el terminal dels altres usuaris el     que li envii un usuari determinat.
    Si en algun moment, algun usuari escriu la paraula 'Marxo', el programa interpretarà que vol         marxar i deixar la conversació. Per tant, s'eliminarà aquest usuari de la llista de usuaris           connectats i s'informarà a la resta de que l'usuari 'x' abandona el xat.
    
# EXECUCIÓ DE LA PRÀCTICA
1. Executar Server.java. Sortirà uel missatge següent per pantalla: "Servidor inicialitzat. Esperant als usuaris...". Ara, el servidor està preparat.
2. Executar Client.java. Al fer-ho, demanarà que s'introdueixi un nom d'usuari per el xat. Un cop s'accepti el nick proposat, sortirà al terminal del servidor que està connectat.
3. Tornar a executar Client.java. Així, crearem un altre usuari del xat que podrà intercanviar missatges amb el creat anteriorment.
4. Començar la conversa. Si el primer client escriu 'hola' al seu terminal, apareixerà reflexat al servidor, on aniran apareixent els missatges de tots els usuaris, i també en el terminal del segon usuari, i viceversa, fins que algun d'ells escrigui 'Marxo'. Llavors s'eliminarà de la conversa i s'informarà als usuaris i al servidor de que ha abandonat el xat.
