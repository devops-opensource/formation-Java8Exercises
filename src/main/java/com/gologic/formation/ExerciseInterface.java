package com.gologic.formation;

import com.gologic.formation.service.IProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExerciseInterface {

    private static final Logger LOG = LogManager.getLogger(ExerciseInterface.class);

    public static void launchExercises(IProductService productService) {

        exercise_defaultMethod();
    }

    private static void exercise_defaultMethod() {

        LOG.info("exercise_defaultMethod()");

        // TODO: Add default method in interface IProductService. Output something to stdout return a
    }
}
