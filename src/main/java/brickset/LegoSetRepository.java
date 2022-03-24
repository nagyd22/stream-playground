package brickset;

import repository.Repository;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Returns the number of LEGO sets with the theme specified.
     *
     * @param theme a LEGO set theme
     * @return the number of LEGO sets with the theme specified
     */
    public long countLegoSetsWithTheme(String theme) {
        return getAll().stream()
                .filter(l -> l.getTheme() != null && l.getTheme().contains(theme))
                .count();
    }

    /**
     * Returns the number of LEGO sets with a specified CharSequence in their names.
     *
     * @param c a CharSequence
     * @return the number of LEGO sets with a specified CharSequence in their names
     */
    public long countLegoSetsNameContains(CharSequence c) {
        return getAll().stream()
                .filter(l -> l.getName() != null && l.getName().contains(c))
                .count();
    }

    /**
     * Prints all the LEGO sets which name is more than the specified number.
     *
     * @param n an integer
     */
    public void printLegoSetsNameMoreThan(int n) {
        getAll().stream()
                .map(LegoSet::getName)
                .filter(l -> l != null && l.length() > n)
                .forEach(System.out::println);
    }

    /**
     * Returns the number of LEGO sets with dimensions.
     *
     * @return the number of LEGO sets with dimensions
     */
    public long countLegoSetsHasDimensions() {
        return getAll().stream()
                .map(LegoSet::getDimensions)
                .filter(Objects::nonNull)
                .count();
    }

    /**
     * Prints the name of the first n LEGO sets.
     *
     * @param n an integer
     */
    public void printFirstNLegoSetsName(int n) {
        getAll().stream()
                .map(LegoSet::getName)
                .limit(n)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        var repository = new LegoSetRepository();

        System.out.println(repository.countLegoSetsWithTheme("Duplo"));
        System.out.println(repository.countLegoSetsNameContains("b"));
        repository.printLegoSetsNameMoreThan(50);
        System.out.println(repository.countLegoSetsHasDimensions());
        repository.printFirstNLegoSetsName(3);
    }
}

