package com.ljubinkovicd.yahtzee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YahtzeeTest {

    // utility method
    private List<Integer> generateRandomDices() {

        List<Integer> integerList = new ArrayList<>();

        Random random = new Random();
        for (int i = 1; i <= 6; i++) {
            int r = random.nextInt(6) + 1;
            integerList.add(r);
        }
        return integerList;
    }

    // utility method
    private void showNumberSumMap(Map<Integer, Integer> numberSumMap) {
        System.out.println("number : sum map ");
        numberSumMap.forEach((k, v) -> System.out.println("number: " + k + ": sum: " + v));
        System.out.println("");
    }


    @Test(expected=IllegalArgumentException.class)
    public void diceWithSixNumbersShouldFail() throws Exception {
        List<Integer> diceWithSixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Yahtzee.aces(diceWithSixNumbers);
    }

    @Test(expected=IllegalArgumentException.class)
    public void diceWithZeroNumbersShouldFail() throws Exception {
        List<Integer> diceWithSixNumbers = Arrays.asList();
        Yahtzee.aces(diceWithSixNumbers);
    }

    @Test(expected=IllegalArgumentException.class)
    public void diceWithSomeNullNumberShouldFail() throws Exception {
        List<Integer> diceWithSixNumbers = Arrays.asList(null, 2, 3, 4, 5);
        Yahtzee.aces(diceWithSixNumbers);
    }

    @Test(expected=IllegalArgumentException.class)
    public void diceWithSomeNumberBiggerThanSixShouldFail() throws Exception {
        List<Integer> diceWithSixNumbers = Arrays.asList(11, 2, 3, 4, 5);
        Yahtzee.aces(diceWithSixNumbers);
    }

    @Test(expected=IllegalArgumentException.class)
    public void diceWithSomeNumberSmallerThanOneShouldFail() throws Exception {
        List<Integer> diceWithSixNumbers = Arrays.asList(0, 2, 3, 4, 5);
        Yahtzee.aces(diceWithSixNumbers);
    }

    @Test
    public void aces() throws Exception {

        List<Integer> diceWithNoOnes = Arrays.asList(2, 3, 4, 5, 6);
        List<Integer> diceWithOneOnes = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> diceWithTwoOnes = Arrays.asList(1, 1, 3, 4, 5);

        assertEquals(0, Yahtzee.aces(diceWithNoOnes));
        assertEquals(1, Yahtzee.aces(diceWithOneOnes));
        assertEquals(2, Yahtzee.aces(diceWithTwoOnes));

        Map<Integer, Integer> numberSumMapDiceWithNoOnes = Yahtzee.sumAll(diceWithNoOnes);
        showNumberSumMap(numberSumMapDiceWithNoOnes);

        assertEquals(0, numberSumMapDiceWithNoOnes.getOrDefault(1, 0).intValue()); // get 1 sum if there is any, otherwise, return 0.

        Map<Integer, Integer> numberSumMapDiceWithOneOnes = Yahtzee.sumAll(diceWithOneOnes);
        showNumberSumMap(numberSumMapDiceWithOneOnes);

        assertEquals(1, numberSumMapDiceWithOneOnes.getOrDefault(1, 0).intValue());

        Map<Integer, Integer> numberSumMapDiceWithTwoOnes = Yahtzee.sumAll(diceWithTwoOnes);
        showNumberSumMap(numberSumMapDiceWithTwoOnes);

        assertEquals(2, numberSumMapDiceWithTwoOnes.getOrDefault(1, 0).intValue());

    }

    @Test
    public void twos() throws Exception {
        // The implementation will be the same as for aces() function, with a different number.
    }

    @Test
    public void threes() throws Exception {
        // The implementation will be the same as for aces() function, with a different number.
    }

    @Test
    public void fours() throws Exception {
        // The implementation will be the same as for aces() function, with a different number.
    }

    @Test
    public void fives() throws Exception {
        // The implementation will be the same as for aces() function, with a different number.
    }

    @Test
    public void sixes() throws Exception {
        // The implementation will be the same as for aces() function, with a different number.
    }

    @Test
    public void threeOfaKind() throws Exception {
        List<Integer> fourConsec = Arrays.asList(3, 1, 6, 4, 5);
        List<Integer> fiveConsec = Arrays.asList(1, 4, 3, 2, 5);
        List<Integer> aPair = Arrays.asList(1, 2, 3, 1, 5);
        List<Integer> threeOnes = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> fullHouse = Arrays.asList(6, 6, 1, 6, 1);
        List<Integer> fourSixes = Arrays.asList(6, 6, 1, 6, 6);
        List<Integer> onlySixes = Arrays.asList(6, 6, 6, 6, 6);

        assertTrue(!Yahtzee.isThreeOfaKind(fourConsec));
        assertTrue(!Yahtzee.isThreeOfaKind(fiveConsec));
        assertTrue(!Yahtzee.isThreeOfaKind(aPair));
        assertTrue(Yahtzee.isThreeOfaKind(threeOnes));
        assertTrue(Yahtzee.isThreeOfaKind(fullHouse));
        assertTrue(!Yahtzee.isThreeOfaKind(fourSixes));
        assertTrue(!Yahtzee.isThreeOfaKind(onlySixes));
    }


    @Test
    public void fourOfaKind() throws Exception {
        List<Integer> fourConsec = Arrays.asList(3, 1, 6, 4, 5);
        List<Integer> fiveConsec = Arrays.asList(1, 4, 3, 2, 5);
        List<Integer> aPair = Arrays.asList(1, 2, 3, 1, 5);
        List<Integer> threeOnes = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> fullHouse = Arrays.asList(6, 6, 1, 6, 1);
        List<Integer> fourSixes = Arrays.asList(6, 6, 1, 6, 6);
        List<Integer> onlySixes = Arrays.asList(6, 6, 6, 6, 6);

        assertTrue(!Yahtzee.isFourOfaKind(fourConsec));
        assertTrue(!Yahtzee.isFourOfaKind(fiveConsec));
        assertTrue(!Yahtzee.isFourOfaKind(aPair));
        assertTrue(!Yahtzee.isFourOfaKind(threeOnes));
        assertTrue(!Yahtzee.isFourOfaKind(fullHouse));
        assertTrue(Yahtzee.isFourOfaKind(fourSixes));
        assertTrue(!Yahtzee.isFourOfaKind(onlySixes));
    }

    @Test
    public void chance() throws Exception {

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6);
        assertEquals(19, Yahtzee.chance(list));

        list = generateRandomDices();

        Integer sum = list.stream().reduce(0, Integer::sum);
        assertEquals(sum.intValue(), Yahtzee.chance(list));
    }

    @Test
    public void yahtzee() throws Exception {
        List<Integer> fourConsec = Arrays.asList(3, 1, 6, 4, 5);
        List<Integer> fiveConsec = Arrays.asList(1, 4, 3, 2, 5);
        List<Integer> aPair = Arrays.asList(1, 2, 3, 1, 5);
        List<Integer> threeOnes = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> fullHouse = Arrays.asList(6, 6, 1, 6, 1);
        List<Integer> fourSixes = Arrays.asList(6, 6, 1, 6, 6);
        List<Integer> onlySixes = Arrays.asList(6, 6, 6, 6, 6);

        assertTrue(!Yahtzee.isYahtzee(fourConsec));
        assertTrue(!Yahtzee.isYahtzee(fiveConsec));
        assertTrue(!Yahtzee.isYahtzee(aPair));
        assertTrue(!Yahtzee.isYahtzee(threeOnes));
        assertTrue(!Yahtzee.isYahtzee(fullHouse));
        assertTrue(!Yahtzee.isYahtzee(fourSixes));
        assertTrue(Yahtzee.isYahtzee(onlySixes));

        assertEquals(0, Yahtzee.yahtzee(fiveConsec));
        assertEquals(50, Yahtzee.yahtzee(onlySixes));
    }

    @Test
    public void fullHouse() throws Exception {
        List<Integer> fourConsec = Arrays.asList(3, 1, 6, 4, 5);
        List<Integer> fiveConsec = Arrays.asList(1, 4, 3, 2, 5);
        List<Integer> aPair = Arrays.asList(1, 2, 3, 1, 5);
        List<Integer> threeOnes = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> fullHouse = Arrays.asList(6, 6, 1, 6, 1);
        List<Integer> fourSixes = Arrays.asList(6, 6, 1, 6, 6);
        List<Integer> onlySixes = Arrays.asList(6, 6, 6, 6, 6);

        assertEquals(0, Yahtzee.fullHouse(fourConsec));
        assertEquals(0, Yahtzee.fullHouse(fiveConsec));
        assertEquals(0, Yahtzee.fullHouse(aPair));
        assertEquals(0, Yahtzee.fullHouse(threeOnes));
        assertEquals(25, Yahtzee.fullHouse(fullHouse));
        assertEquals(0, Yahtzee.fullHouse(fourSixes));
        assertEquals(0, Yahtzee.fullHouse(onlySixes));
    }

    @Test
    public void smallStraight() throws Exception {
        List<Integer> fourConsec = Arrays.asList(3, 2, 5, 4, 5);
        List<Integer> fiveConsec = Arrays.asList(1, 4, 3, 2, 5);
        List<Integer> aPair = Arrays.asList(1, 2, 3, 1, 4);
        List<Integer> threeOnes = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> fullHouse = Arrays.asList(6, 6, 1, 6, 1);
        List<Integer> fourSixes = Arrays.asList(6, 6, 1, 6, 6);
        List<Integer> onlySixes = Arrays.asList(6, 6, 6, 6, 6);

        assertEquals(30, Yahtzee.smallStraight(fourConsec));
        assertEquals(30, Yahtzee.smallStraight(fiveConsec));
        assertEquals(30, Yahtzee.smallStraight(aPair));
        assertEquals(0, Yahtzee.smallStraight(threeOnes));
        assertEquals(0, Yahtzee.smallStraight(fullHouse));
        assertEquals(0, Yahtzee.smallStraight(fourSixes));
        assertEquals(0, Yahtzee.smallStraight(onlySixes));
    }

    @Test
    public void largeStraight() throws Exception {
        List<Integer> fourConsec = Arrays.asList(3, 1, 6, 4, 5);
        List<Integer> fiveConsec = Arrays.asList(1, 4, 3, 2, 5);
        List<Integer> aPair = Arrays.asList(1, 2, 3, 1, 5);
        List<Integer> threeOnes = Arrays.asList(1, 2, 1, 3, 1);
        List<Integer> fullHouse = Arrays.asList(6, 6, 1, 6, 1);
        List<Integer> fourSixes = Arrays.asList(6, 6, 1, 6, 6);
        List<Integer> onlySixes = Arrays.asList(6, 6, 6, 6, 6);

        assertEquals(0, Yahtzee.largeStraight(fourConsec));
        assertEquals(40, Yahtzee.largeStraight(fiveConsec));
        assertEquals(0, Yahtzee.largeStraight(aPair));
        assertEquals(0, Yahtzee.largeStraight(threeOnes));
        assertEquals(0, Yahtzee.largeStraight(fullHouse));
        assertEquals(0, Yahtzee.largeStraight(fourSixes));
        assertEquals(0, Yahtzee.largeStraight(onlySixes));
    }
}