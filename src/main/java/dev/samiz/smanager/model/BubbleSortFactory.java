package dev.samiz.smanager.model;

public class BubbleSortFactory extends SortFactory{
    @Override
    public Sort getInstance() {
        return new BubbleSort();
    }
}
