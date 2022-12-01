package com.gologic.formation;

import com.gologic.formation.dto.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseStreams {
    private static final Logger LOG = LogManager.getLogger(ExerciseStreams.class);
    public static void launchExercises(List<Product> products) {

        example_stream(products);
        exercise_searchProducts(products);
        exercise_displayProducts(products);
        exercise_extractProductsAsMap(products);
        exercise_processListInParallel(products);
    }
    private static void example_stream(List<Product> products) {

        LOG.info("example_stream() - Example method");

        BigDecimal maxPrice = new BigDecimal("1000.00");

        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getPrice().compareTo(maxPrice) <= 0)
                .sorted(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                })
//                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
//                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());

        LOG.info( String.format("Found products under %f", maxPrice));
        filteredProducts.forEach(LOG::info);
    }
    private static void exercise_searchProducts(List<Product> products) {

        LOG.info("exercise_searchProducts()");

        // TODO: Effectuer une recherche qui retourne toute les produits de la company = 'Compucenter'
    }
    private static void exercise_searchProductsNonExistant(List<Product> products) {

        LOG.info("exercise_searchProductsNonExistant()");

        // TODO: Effectuer une recherche qui retourne un produit qui n'existe potentiellement pas (utiliser le critère name = 'carpet') avec l'aide du Optional

    }
    private static void exercise_displayProducts(List<Product> products) {

        LOG.info("exercise_displayProducts()");

        // TODO: Effectuer une recherche qui affiche les champs name et company de chaque produit dans le stout (vous pouvez utiliser LOG ou System.out)
    }
    private static void exercise_extractProductsAsMap(List<Product> products) {

        LOG.info("exercise_extractProductsAsMap()");

        // TODO: Effectuer une extraction de tous les produits et les re-arranger dans une Map ou que k = company et v = Liste de produits pour cette company
    }
    private static void exercise_processListInParallel(List<Product> products) {

        LOG.info("exercise_processListInParallel()");

        // TODO: Convertir tous les noms de produits en lettres majuscule en parallel et afficher les résultat dans le stdout (vous pouvez utiliser LOG ou System.out)
    }

    // TODO: more examples with predicates in method parameters (code/logic reuse) and manipulation of List of products

    // TODO: example where a list of predicates can be evaluated, and the first to be true returns the matching objects
}
