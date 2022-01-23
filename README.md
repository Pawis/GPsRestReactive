## Opis rozwiązania.

Program ma odbierać i zapisywać dane lokalizacji urządzeń GPS.

Postanowiłem użyć platformy Web flux zamiast Web, ponieważ uznałem, że mogę oczekiwać
wysokiej liczby zapytań na sekundę, przez co kontener Tomcat nie będzie dobrym rozwiązaniem.
Web flux posiada kontener Netty, który używa wydajniej wątków, nie tworzy osobnego
watka na każde zapytanie, przez co idealnie nadaje się do tak dużej liczby zapytań.

Dodatkowów użyłem reaktywnej bazy daych (R2DBC – H2) do zapisywania lokalizacji urządzeń przez
co uzyskałem nieblokujący ciąg pracy wątków.

Strwożyłem też warstwę serwisowa, która implementuje interfejs, przez co możemy w łatwy sposób ją 
rozszerzyć i użyć Dependency Injection do testów bądź podmiany.

Do sprawdzania liczby użytych wątków i testowania aplikacji pod obciążeniem użyłem VisualVM i Apache JMeter.

