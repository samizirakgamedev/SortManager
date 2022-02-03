package dev.samiz.smanager.model;

// Creator (Factory)
public class SortTypeFactory extends SortType {
    @Override
    public Sort getInstance(AvailableSorts availableSorts) {
        Sort sort = switch (availableSorts) {
            case BUBBLE -> new BubbleSort();
            case MERGE -> new MergeSort();
            // Case For Binary Search Will Go Here
            default -> null;
        };
        return sort;
    }
}
