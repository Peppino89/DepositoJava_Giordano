PROGETTO: Piattaforma Notifiche Personalizzabili

Design Pattern usati:
1. Singleton
   - Classe: NotificationManager
   - Serve ad avere un solo gestore centrale delle notifiche.

2. Observer
   - Interfaccia: Observer
   - Classe concreta: Utente
   - Serve per permettere agli utenti registrati di ricevere notifiche.

3. Decorator
   - Interfaccia: Notifica
   - Classe base: NotificaBase
   - Decorator astratto: NotificaDecorator
   - Decorator concreti: TimestampDecorator, MaiuscoloDecorator, MinuscoloDecorator, PrefissoDecorator, EmojiDecorator
   - Serve per personalizzare il messaggio ricevuto da ogni utente.


