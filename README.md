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
| admin@example.com  | 1234     | Hat alle Rechte ausser Participate Event           |




### Troubleshooting

```
org.postgresql.util.PSQLException: ERROR: relation "role_authority" does not exist
```
Simply restart the application. Hibernate sometimes does not initialize the tables fast enough an causes thios error. restarting the application fixes this.