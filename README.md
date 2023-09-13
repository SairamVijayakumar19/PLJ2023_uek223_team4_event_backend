# README #

## Starter Project Spring Boot


### Schritt 1
Zuerst müssen Sie ihre Postgres Datenbank erstellen. Verwenden Sie den unten stehenden Command. Sobald Sie das gemacht haben können Sie den Docker App öffen und den Docker starten.
### Docker command
```
docker run --name postgres_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```
### Schritt 2
Öffnen Sie Ihr Backend Ordner in ihrer Umgebung und klicken Sie auf den Button Gradle, der sich auf der rechten Seite ihrer Umgebung befindet.
Öffnen Sie die Ordner in der Navigationsleiste in der folgenden Reihenfolge: demo>Tasks>application>bootrun. Klicken Sie auf die Schaltfläche bootrun, um das Programm zu starten.
![bootrun](/img/bootrun.png)


### Schritt 3 
Öffnen Sie ihr bereits geclontes Frontend Projekt und öffen Sie ihr cmd Terminal und geben sie Folgendes ein:
```
yarn start
```
### Schritt 4
Wenn der Docker und Backend laufen und sie eine Seite sehen, können Sie sich nun anmelden.

| E-Mail             | Password | Authorities                                        |
| ------------------ | -------- |----------------------------------------------------|
| user@example.com   | 1234     | Create/Modify/Delete/Participate/Read/join - Event |
| sairam@example.com  | 1234     | Hat Admin Rechte                                  | 




### Troubleshooting

```
org.postgresql.util.PSQLException: ERROR: relation "role_authority" does not exist
```
Simply restart the application. Hibernate sometimes does not initialize the tables fast enough an causes thios error. restarting the application fixes this.


### Testing


Das Verhalten des Backends haben wir mit verschiedenen Postman Collections getestet.

#### Collection JSON Files

Links zu Files

[JSON Postman Files](https://github.com/SairamVijayakumar19/PLJ2023_uek223_team4_event_backend/blob/main/Postman%20json%20files/)

### Schritte fürs Postman testing

#### Schritt 1

JSON Files herunterladen und per Drag und Drop Files hinzufügen.

<img width="958" alt="image" src="https://github.com/SairamVijayakumar19/PLJ2023_uek223_team4_event_backend/assets/113603845/8c8caabd-bb59-4fe5-ad4b-4a631227aa83">

#### Schritt 2

Bei Environments ein neues Environment erstellen und eine neue Variable namens "token" erstellen.

<img width="961" alt="image" src="https://github.com/SairamVijayakumar19/PLJ2023_uek223_team4_event_backend/assets/113603845/bff27b1f-283f-416a-b943-acd12f3d273d"> 
 

Nun sind Sie bereit fürs testing in Postman, bedenken sie immer zuerst den login test durchzuführen.
Ebenfalls müssen sie oben Rechts das neue Environment auswählen. 

<img width="960" alt="image" src="https://github.com/SairamVijayakumar19/PLJ2023_uek223_team4_event_backend/assets/113603845/424878ac-de35-4c2a-be82-0fff8c929432">


