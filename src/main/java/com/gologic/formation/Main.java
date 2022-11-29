package com.gologic.formation;

import com.gologic.formation.data.DataLoader;
import com.gologic.formation.dto.Application;
import com.gologic.formation.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    private static Application appData;

    private static ProductService productService;

    public static void main(String[] args) {

        printHeaderLog("START Java 8 Exercises");


        loadData();
        initServiceClass();

        printHeaderLog("COMPLETED Java 8 Exercises");
    }

    private static void loadData() {
        DataLoader dl  = new DataLoader("/data.yaml");
        appData = dl.getApplication();
    }

    private static void initServiceClass() {
        productService = new ProductService(appData);
    }

    private static void printHeaderLog(String message) {
        LOG.info("-----------------------------------------------------");
        LOG.info("     " + message);
        LOG.info("-----------------------------------------------------");
    }
}