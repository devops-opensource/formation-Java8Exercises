# Formation Java 8-9

Cette application Java à pour objectif de faire connaitres certaines nouvelles fonctionnalités de Java 8-9 et de démontrer comment modifier du code Java 7 en équivalent Java 8.

Java 8 exercises showcasing various changes brought in since java 7 such as streams and dates

## Gradle commands

Le package manger c'est Gradle, configurer pour être compiler en Java 8.

| Action    | Command (Linux, Mac) | Command (Windows)     |
|:----------|:---------------------|:----------------------|
| Build     | ``./gradlew build``  | ``gradlew.bat build`` |
| Run Tests | ``./gradlew test``   | ``gradlew.bat test``  |
| Run Main  | ``./gradlew run``    | ``gradlew.bat run``   |

## Exercises

LEs exercises se trouve dans les classes static préfixer avec Exercise
- ExerciseStreams
- ExerciseInterface
- ExerciseDates

## Cheatsheet

### Dates

Convertir une util.Date en Epoch Time (secondes)
```
long epoch = date.toInstant().toEpochMilli() / 1000;
```

Convertir une LocalDateTime en Epoch Time (secondes)
```
long epoch = localDateTime.atZone(ZoneId.of("America/New_York")).toEpochSecond();
```

## Réponses

Des réponses se trouve dans le package "answers" pour la classe ExerciseStreams. Par défault cette classe n'est pas appelé par Main