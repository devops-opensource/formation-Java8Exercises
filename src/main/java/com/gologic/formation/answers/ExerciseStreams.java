package com.gologic.formation.answers;

import com.gologic.formation.dto.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseStreams {
    private static final Logger LOG = LogManager.getLogger(ExerciseStreams.class);
    public static void launchExercises(List<Product> products) {

        // exercises
        exercise_searchProducts(products);
        exercise_searchProductsNonExistant(products);
        exercise_displayProducts(products);
        exercise_extractProductsAsMap(products);
        exercise_processListInParallel(products);
        exercise_predicateListEval(products);
        exercise_predicateEval(products);
        exercise_parametrizedPredicates(products);
    }

    private static void exercise_searchProducts(List<Product> products) {

        LOG.info("exercise_searchProducts()");

        // Effectuer une recherche de tous les produits qui sont associés au Company "Compucenter"

        List<Product> foundProducts = products.stream()
                .filter(p -> p.getCompany().equalsIgnoreCase("compucenter"))
                .collect(Collectors.toList());

        assertThat(foundProducts).isNotEmpty();
        assertThat(foundProducts).hasSize(4);
    }
    private static void exercise_searchProductsNonExistant(List<Product> products) {

        LOG.info("exercise_searchProductsNonExistant()");

        // TODO: Effectuer une recherche qui retourne un produit qui n'existe potentiellement pas (utiliser le critère name = 'carpet') avec l'aide du Optional

        Optional<Product> p = products.stream()
                .filter(product -> product.getName().equals("carpet"))
                .findFirst();

        Optional.of(p).ifPresentOrElse(
                LOG::info,
                () -> LOG.info("Product carpet not found"));

        assertThat(p.isPresent()).isFalse();
    }
    private static void exercise_displayProducts(List<Product> products) {

        LOG.info("exercise_displayProducts()");

        // TODO: Effectuer une recherche qui affiche les champs name et company de chaque produit dans le stout (vous pouvez utiliser LOG ou System.out)

        String format = "   Product Name: %s, Company: %s";
        products.forEach(product -> LOG.info( String.format(format, product.getName(), product.getCompany())));
    }
    private static void exercise_extractProductsAsMap(List<Product> products) {

        LOG.info("exercise_extractProductsAsMap()");

        // TODO: Effectuer une extraction de tous les produits et les re-arranger dans une Map ou que k = company et v = Liste de produits pour cette company

        Map<String, List<Product>> companyProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getCompany));

        assertThat(companyProducts).isNotEmpty();
        assertThat(companyProducts).containsKeys("FutureShop", "Compucenter", "TheBreeck");
    }
    private static void exercise_processListInParallel(List<Product> products) {

        LOG.info("exercise_processListInParallel()");

        // TODO: Convertir tous les noms de produits en lettres majuscule en parallel et afficher les résultat dans le stdout (vous pouvez utiliser LOG ou System.out)

        List<Product> uppercaseProducts = products.parallelStream()
                .map(p -> new Product(p.getId(), p.getName().toUpperCase(), p.getCompany(), p.getPrice()))
                .collect(Collectors.toList());

        assertThat(uppercaseProducts).isNotEmpty();
        uppercaseProducts.forEach(p -> assertThat(p.getName()).isUpperCase());
    }

    private static void exercise_parametrizedPredicates(List<Product> products) {

        LOG.info("exercise_parametrizedPredicates()");

        // TODO: créer une fonction qui accepte un Predicate en paramètre pour la recherche de produits qui contiennent les voyelles a, i, o et retourne le résultat en tant qu'Array
        Predicate<Product> voyellesSearch = p -> p.getName().matches("^.*[aio].*$");
        Product[] results = searchItems(products, voyellesSearch);

        assertThat(results).isNotEmpty();
        assertThat(results).hasSize(14);
    }

    private static void exercise_predicateListEval(List<Product> products) {

        LOG.info("exercise_predicateListEval()");

        // TODO: créer une fonction qui accepte multiple predicates: un qui évalue que le produit vient de FutureShop, et un autre que les prix sont au-dessus de 500 dollars.
        // TODO Retourner la liste des produits qui sont applicable aux critères. Utilisez seulement 1 call de filter

        Predicate<Product> futureShopProducts = p -> p.getCompany().equals("FutureShop");
        Predicate<Product> lessThanThousandProducts = p -> p.getPrice().compareTo(new BigDecimal("1000")) < 0;

        List<Predicate<Product>> predicates = List.of(futureShopProducts, lessThanThousandProducts);

        List<Product> results = searchItems(products, predicates);

        assertThat(results).isNotEmpty();
        assertThat(results).hasSize(3);
    }

    private static void exercise_predicateEval(List<Product> products) {

        LOG.info("exercise_predicateEvalO()");

        // TODO: verifier chaque prédicat pour chaque produit, et pour le predicat qui est vrai, retourner le produit dans une liste et afficher un message (stdout, LOG) pour dire quel prédicat est vrai
        // TODO: utiliser 1 call de filter

        Predicate<Product> compucenterProducts = p -> p.getCompany().equals("Compucenter");
        Predicate<Product> lessThanThousandProducts = p -> p.getPrice().compareTo(new BigDecimal("750.00")) >=  0;

        products.stream()
                .filter( p -> {

                    boolean productMatches = false;
                    if(compucenterProducts.test(p)) {
                        LOG.info(p);
                        LOG.info("Product is from Compucenter");
                        productMatches = true;
                    }
                    if(lessThanThousandProducts.test(p)) {
                        LOG.info(p);
                        LOG.info("Product is greater than $750.00");
                        productMatches = true;
                    }

                    return productMatches;
                })
                .close();
    }

    // TODO: quel des exercises peuvent utiliser le parallelStream qu lieu du Stream? Essayez-les pour comparer les résultats vs le Stream conventionel

    private static Product[] searchItems(List<Product> sourceList, Predicate<Product> filterPredicate) {

        return sourceList.stream()
                .filter(filterPredicate)
                .toArray(Product[]::new);
    }

    private static List<Product> searchItems(List<Product> sourceList, List<Predicate<Product>> predicates) {

        return sourceList.stream()
                .filter(predicates.stream().reduce(predicate -> true, Predicate::and))
                .collect(Collectors.toList());
    }
}