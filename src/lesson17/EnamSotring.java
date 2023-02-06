package lesson17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class EnamSotring {
    public static void main(String[] args) {
        final Store store = new Store(new ArrayList<>());

        try (final Scanner scanner = new Scanner(System.in)) {
            addItemsToStore(store, scanner);
            sortItems(store, scanner);
        } catch (final ItemSortingTypeNotFoundException e) {
            System.err.println("Wrong item sorting type. " + e.getMessage());
        }

    }

    private static void addItemsToStore(final Store store, final Scanner scanner) {
        System.out.println("Please enter the items amount.");
        int itemsAmount = scanner.nextInt();

        while (itemsAmount-- > 0) {
            System.out.println("Please enter item price.");
            int itemPrice = scanner.nextInt();

            System.out.println("Please enter item name.");
            String itemName = scanner.next();

            store.addItemToStore(new Item(itemPrice, itemName));

            System.out.println("Rest of items " + itemsAmount);
        }
    }

    private static void sortItems(final Store store, final Scanner scanner) throws ItemSortingTypeNotFoundException {
        System.out.println("Please enter item sorting type. Available options: " + ItemSortingType.getItemSortingTypes());

        final String itemSortingType = scanner.next() + " " + scanner.next();

        final ItemSortingType productSortingType = ItemSortingType.getByItemSortingType(itemSortingType);

        final List<Item> sortedItems = store.getSortingItems(productSortingType);
        System.out.println("Sorted items: " + sortedItems);
    }

}

enum ItemSortingType {
    SORTING_BY_NAME_ASC(Comparator.comparing(Item::getItemName), "name asc"),
    SORTING_BY_NAME_DESC(Comparator.comparing(Item::getItemName).reversed(), "name desc"),
    SORTING_BY_PRICE_ASC(Comparator.comparing(Item::getItemPrice), "price asc"),
    SORTING_BY_PRICE_DESC(Comparator.comparing(Item::getItemPrice).reversed(), "price desc");
    private final Comparator<Item> comparator;
    private final String sortingName;

    ItemSortingType(Comparator<Item> comparator, String sortingName) {
        this.comparator = comparator;
        this.sortingName = sortingName;
    }

    public Comparator<Item> getComparator() {
        return comparator;
    }

    public String getSortingName() {
        return sortingName;
    }

    public static ItemSortingType getByItemSortingType(String itemSortingType) throws ItemSortingTypeNotFoundException {
        return Stream.of(ItemSortingType.values())
                .filter(type -> type.sortingName.equalsIgnoreCase(itemSortingType))
                .findFirst()
                .orElseThrow(() -> new ItemSortingTypeNotFoundException(itemSortingType));
    }

    public static List<String> getItemSortingTypes() {
        return Stream.of(ItemSortingType.values())
                .map(ItemSortingType::getSortingName)
                .toList();
    }

}

class ItemSortingTypeNotFoundException extends Exception {
    public ItemSortingTypeNotFoundException(String itemSortingType) {
        super("Item sorting type [" + itemSortingType + "] does not exist.");
    }
}

class Store {

    public Store(List<Item> store) {
        this.store = store;
    }

    private final List<Item> store;

    public void addItemToStore(Item item) {
        store.add(item);
    }

    public List<Item> getSortingItems(ItemSortingType itemSortingType) {
        return store.stream().sorted(itemSortingType.getComparator()).toList();
    }

    public int storeSize() {
        return store.size();
    }

    public synchronized void buy(String itemName) throws ItemNotFound, InterruptedException {
        Item item = store.stream()
                .filter(i -> i.getItemName().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new ItemNotFound("Item with name " + itemName + " not found."));

        while (item.getItemsAmount() < 1) {
            System.out.println("I'm waiting for " + itemName);
            wait();
        }

        item.setItemsAmount(item.getItemsAmount() - 1);
        System.out.println("I've bought the " + itemName);
        notifyAll();
    }

    public synchronized void put() throws InterruptedException {
        while (store.stream().allMatch(item -> item.getItemsAmount() > 0)){
            wait();
        }
        for (Item item : store) {
            if (item.getItemsAmount() < 1) {
                item.setItemsAmount(1);
                notifyAll();
            }
        }
    }
}

class ItemNotFound extends Exception {
    public ItemNotFound(String message) {
        super(message);
    }
}

class Item {

    private final int itemPrice;
    private final String itemName;
    private int itemsAmount;

    public Item(int itemPrice, String itemName) {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(int itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    @Override
    public String toString() {
        return "Item: " +
                "itemPrice =" + itemPrice +
                ", itemName ='" + itemName + '\'';
    }
}
