package com.gologic.formation;

import com.gologic.formation.annotation.Sensitive;
import com.gologic.formation.annotation.Serialize;
import com.gologic.formation.dto.Product;
import com.gologic.formation.service.IProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class ExerciseInterface {

    private static final Logger LOG = LogManager.getLogger(ExerciseInterface.class);

    public static void launchExercises(IProductService productService, List<Product> products) {

        exercise_defaultMethod();
        example_annotation(products);
    }

    private static void exercise_defaultMethod() {

        LOG.info("exercise_defaultMethod()");

        // TODO: Add default method in interface IProductService. Output something to stdout return a
    }

    private static void example_annotation(List<Product> products) {

        LOG.info("exercise_typeAnnotation()");

        Product p = products.get(0);

        Class<? extends Product> clazz = p.getClass();

        if(clazz.isAnnotationPresent(Serialize.class)) {
            LOG.info("Class-level Serialize annotation found");
        }

        for(Field f : clazz.getDeclaredFields()) {

            LOG.info("Current Field: " + f.getName());

            if(f.isAnnotationPresent(Sensitive.class)) {
                LOG.info(String.format("   Field-level annotation found %s", Sensitive.class));
            }

            Annotation[] typeAnnotations = f.getAnnotatedType().getDeclaredAnnotations();

            for(Annotation a : typeAnnotations) {
                LOG.debug(String.format("   Type-level annotation found %s on type %s", a.toString(), f.getType()));
            }
        }

        // Type applied annotations (our @Numeric annotation) cannot be evaluated in runtime.
    }
}
