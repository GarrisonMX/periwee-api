package com.periwee.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SprintBootApplication

fun main(args: Array<String>) {
    var binarySearchImpl = BinarySearchImp(QuickSortAlgorithm())

    var result = binarySearchImpl.binarySearch(arrayOf(12,4,5),3)
    System.out.println(result)
    //runApplication<Application>(*args)
}
