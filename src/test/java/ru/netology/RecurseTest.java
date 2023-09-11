package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecurseTest {

    @Test
    public void testRecurseHam() {
        // given:
        int day = 6;
        int[] startNumbers = {4, 2, 23, 4};
        // when:
        Integer chooseHobbydayRecursive = Recurse.chooseHobbyRecursive(startNumbers, day, new int[day]);
        // then:
        assertThat(chooseHobbydayRecursive, not(equalTo(0)));
    }

    @Test
    public void testDay() {
        int day = (int) (Math.random() * 31);
        int[] startNumbers = {(int) (Math.random() * 30), (int) (Math.random() * 31), (int) (Math.random() * 31), (int) (Math.random() * 31)};
        int chooseHobbydayRecursive = Recurse.chooseHobbyRecursive(startNumbers, day, new int[day]);
        int chooseHobbyIterative = Recurse.chooseHobbyIterative(startNumbers, day);
        assertThat(chooseHobbydayRecursive, equalTo(chooseHobbyIterative));
    }

    @Test
    public void testZero() {
        //given
        int day = 0;
        int[] startNumbers = {4, 2, 23, 4};
        //expect
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Recurse.chooseHobbyRecursive(startNumbers, day, new int[day]);
        });
    }


    @ParameterizedTest
    @ValueSource(ints = {3, 4, 7, 1})
    void testParameter(int day) {
        int[] startNumbers = {4, 2, 23, 4};
        int chooseHobbydayRecursive = Recurse.chooseHobbyRecursive(startNumbers, day, new int[day]);
        int chooseHobbyIterative = Recurse.chooseHobbyIterative(startNumbers, day);
        Assertions.assertEquals(chooseHobbydayRecursive, chooseHobbyIterative);
    }

}

