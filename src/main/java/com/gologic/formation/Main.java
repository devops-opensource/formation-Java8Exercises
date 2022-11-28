package com.gologic.formation;

import com.gologic.formation.data.DataLoader;
import com.gologic.formation.dto.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    private static Application appData;

    public static void main(String[] args) {

        printHeaderLog("START Java 8 Exercises");

        loadData();

        printHeaderLog("COMPLETED Java 8 Exercises");
    }

    private static void loadData() {
        DataLoader dl  = new DataLoader("/data.yaml");
        appData = dl.getApplication();
    }

    private static void printHeaderLog(String message) {
        LOG.info("-----------------------------------------------------");
        LOG.info("     " + message);
        LOG.info("-----------------------------------------------------");
    }
}