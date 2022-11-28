package com.gologic.formation.data;

import com.gologic.formation.dto.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

/**
 * Load the YAML file from the resources classpath
 */
public class DataLoader {

    private static final Logger LOG = LogManager.getLogger(DataLoader.class);

    private String yamlFile;
    public DataLoader(String yamlFile) {
        this.yamlFile = yamlFile;
    }

    public Application getApplication() {

        Application data = null;

        try(InputStream is = getClass().getResourceAsStream(yamlFile)) {

            Yaml yaml = new Yaml(new Constructor(Application.class));
            data = yaml.load(is);
            LOG.info("DataLoader load() - Successfully initialized Application data");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
