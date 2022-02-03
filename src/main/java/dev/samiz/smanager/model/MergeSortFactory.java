package dev.samiz.smanager.model;

public class MergeSortFactory extends SortFactory{
    @Override
    public Sort getInstance() {
        return new MergeSort();
    }
}
