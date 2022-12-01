package com.gologic.formation;

import com.gologic.formation.data.DataLoader;
import com.gologic.formation.dto.Application;
import com.gologic.formation.dto.Product;
import com.gologic.formation.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    private static Application appData;

    private static ProductService productService;

    public static void main(String[] args) {

        printHeaderLog("START Java 8 Exercises");

        loadData();

        ExerciseStreams.launchExercises(appData.getProducts());
        ExerciseInterface.launchExercises(productService);

        Optional<Product> p = appData.getProducts().stream().findFirst();
        p.ifPresent(product -> ExerciseDates.launchExercises(product.getCreatedDate()));

        printHeaderLog("COMPLETED Java 8 Exercises");
    }

    /**
     * Load the application data
     */
    private static void loadData() {
        DataLoader dl  = new DataLoader("/data.yaml");
        appData = dl.getApplication();
        productService = new ProductService(appData);
    }

    private static void printHeaderLog(String message) {
        LOG.info("-----------------------------------------------------");
        LOG.info("     " + message);
        LOG.info("-----------------------------------------------------");
    }
}