package com.gologic.formation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExerciseDates {

    private static final String ZONE_ID = "America/New_York";

    private static final Logger LOG = LogManager.getLogger(ExerciseDates.class);

    public static void launchExercises(Date productDate) {

        example_localDateTime(productDate);
        exercise_toLocalDateConversion(productDate);
        exercise_ToLocalDateTime_WithTimeZone(productDate);
        exercise_firstSaturdayOfMonth(productDate);
    }

    private static void example_localDateTime(Date date) {
        LOG.info("example_localDateTime() - Example method");

        // Activer pour voir la liste des timezone de disponible
//        ZoneId.getAvailableZoneIds().forEach(LOG::debug);

        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.of(ZONE_ID)).toLocalDateTime();
        LOG.info("LocalDateTime defined = " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    private static void exercise_toLocalDateConversion(Date date) {

        LOG.info("exercise_toLocalDateConversion()");

        // TODO: Convertir la date en LocalDate, ensuite comparer les deux objets de dates avec leurs epoch time
    }

    private static void exercise_ToLocalDateTime_WithTimeZone(Date date) {

        LOG.info("exercise_ToLocalDateTime_WithTimeZone()");

        // TODO: Implémenter une méthode qui accepte 2 paramètre (util.Date, ZoneId/TimeZone) et qui retourne la LocalDateTime pour ces valeurs
    }

    private static void exercise_firstSaturdayOfMonth(Date date) {

        LOG.info("exercise_firstSaturdayOfMonth()");

        // TODO: Implémenter une méthode qui accepte une util.Date en paramètre, et qui retourne la LocalDate du premier samedi du prochain mois
    }
}
