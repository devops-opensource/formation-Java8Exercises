package com.gologic.formation.data;

import com.gologic.formation.dto.Application;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.error.YAMLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DataLoaderTest {

    private static final String TEST_FILE_NAME = "/test-data.yaml";
    private static final String TEST_FILE_NAME_INVALID = "/test-data-invalid.yaml";

    @Test
    void getApplicationWithValidData_ExpectLoadedData() {

        DataLoader dl = new DataLoader(TEST_FILE_NAME);
        Application app = dl.getApplication();

        assertThat(app).isNotNull();
        assertThat(app.getName()).isNotBlank();
        assertThat(app.getProducts()).isNotEmpty();
        assertThat(app.getProducts()).hasSize(2);
    }

    @Test
    void getApplicationWithInvalidData_ExpectException() {

        DataLoader dl = new DataLoader(TEST_FILE_NAME_INVALID);

        assertThatThrownBy(dl::getApplication)
                .isInstanceOf(YAMLException.class)
                .hasMessageContaining("Unable to find property 'product' on class: com.gologic.formation.dto.Application");
    }
}
