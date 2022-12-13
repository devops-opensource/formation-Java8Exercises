package com.gologic.formation;

import com.gologic.formation.dto.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciseStreams {
    private static final Logger LOG = LogManager.getLogger(ExerciseStreams.class);
    public static void launchExercises(List<Product> products) {

        // examples
        example_stream(products);
        example_predicateVar(products);

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

        LOG.info( String.format("Found products under %f:", maxPrice));
        filteredProducts.forEach(LOG::info);
    }

    private static void example_predicateVar(List<Product> products) {

        LOG.info("example_predicateVar() - Example method");

        Predicate<Product> searchPredicate = p -> p.getCompany().equalsIgnoreCase("FutureShop");

        List<Product> foundProducts = products.stream()
                .filter(searchPredicate)
                .collect(Collectors.toList());

        LOG.info("Found products:");
        foundProducts.forEach(LOG::info);
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

    private static void exercise_parametrizedPredicates(List<Product> products) {

        LOG.info("exercise_parametrizedPredicates()");

        // TODO: créer une fonction qui accepte un Predicate en paramètre pour la recherche de produits qui contiennent les voyelles a, e, i, o, u et retourne le résultat en tant qu'Array

    }

    private static void exercise_predicateListEval(List<Product> products) {

        LOG.info("exercise_predicateListEval()");

        // TODO: créer une fonction qui accepte multiple predicates: un qui évalue que le produit vient de FutureShop, et un autre que les prix sont au-dessus de 500 dollars.
        // TODO Retourner la liste des produits qui sont applicable aux critères. Utilisez seulement 1 call de filter
    }

    private static void exercise_predicateEval(List<Product> products) {

        LOG.info("exercise_predicateEvalO()");

        // TODO: verifier chaque prédicat pour chaque produit, et pour le predicat qui est vrai, retourner le produit dans une liste et afficher un message (stdout, LOG) pour dire quel prédicat est vrai
        // TODO: utiliser 1 call de filter

        Predicate<Product> compucenterProducts = p -> p.getCompany().equals("Compucenter");
        Predicate<Product> lessThanThousandProducts = p -> p.getPrice().compareTo(new BigDecimal("750.00")) >=  0;
    }

    // TODO: quel des exercises peuvent utiliser le parallelStream qu lieu du Stream? Essayez-les pour comparer les résultats vs le Stream conventionel
}