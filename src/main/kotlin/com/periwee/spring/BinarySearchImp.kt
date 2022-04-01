package com.periwee.spring

class BinarySearchImp {

     private val sortAlgorithm: SortAlgorithm

    constructor(sortAlgorithm: SortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm
    }


    fun binarySearch(numbers: Array<Int>, numbertoSearchFor: Int): Int {
        var sortedNumbers = this.sortAlgorithm.sort(numbers)
        System.out.println(sortAlgorithm)

        //Search the array

        return 3
    }
}