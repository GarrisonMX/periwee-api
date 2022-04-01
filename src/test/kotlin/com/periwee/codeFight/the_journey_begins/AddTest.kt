package com.periwee.codeFight.the_journey_begins

import com.periwee.codefight.the_jouney_begins.MathService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout


class addTest {
    @Test
    fun `should add 1 and 2 equals to 3`(){
        var math1 = MathService()
        var result = math1.add(1,2)
        Assertions.assertEquals(result,3)
    }

}