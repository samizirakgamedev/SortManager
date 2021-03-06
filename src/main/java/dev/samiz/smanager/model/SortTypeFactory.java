package dev.samiz.smanager.model;

// Creator (Factory)
public class SortTypeFactory extends SortType {
    // Method for returning the correct sort when called within the application's controller.
    @Override
    public Sort getInstance(AvailableSorts availableSorts) {
        Sort sort = switch (availableSorts) {
            case BUBBLE -> new BubbleSort();
            case MERGE -> new MergeSort();
            case BINARY -> new BinarySearchTreeSort();
            default -> null;
        };
        return sort;
    }
}
