package com.ljubinkovicd.yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Yahtzee {

    private static void checkDice(List<Integer> dice) {

        String errorMsg = null;

        if (dice == null) {
            errorMsg = "Dice is NULL";
        }
        if (dice.size() != 5) {
            errorMsg = "Dice size must be 5, not : " + dice.size();
        }

        for (Integer die : dice) {
            if (die == null) {
                errorMsg = "Dice is NULL";
                break;
            } else if (die <= 0 || die > 6) {
                errorMsg = "Die must be between 1 and 6 inclusive, die = " + die;
                break;
            }
        }
        if (errorMsg != null) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static int chance(List<Integer> dice) {

        // "classic" java way
//        int result = 0;
//
//        for (int die : dice) {
//            result += die;
//        }

        // or, using java 8 streams
        int result = dice.stream().mapToInt(Number::intValue).sum();

        return result;
    }

    public static Map<Integer, Integer> sumAll(List<Integer> dice) {


        Map<Integer, Integer> numberSumMap = dice.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(Integer::intValue)));
        // Print the Map
        return numberSumMap;
    }

    private static int numberSum(List<Integer> dice, int number) {

        checkDice(dice);

        int sum = dice.stream().filter(num -> num == number).mapToInt(Integer::intValue).sum();
        return sum;
/*
        int result = 0;
        for (int die : dice) {
            if (die == number) {
                result += die;
            }
        }
        return result;
*/
    }

    public static int aces(List<Integer> dice) {
        return numberSum(dice, 1);
    }

    public static int twos(List<Integer> dice) {
        return numberSum(dice, 2);
    }

    public static int threes(List<Integer> dice) {
        return numberSum(dice, 3);
    }

    public static int fours(List<Integer> dice) {
        return numberSum(dice, 4);
    }

    public static int fives(List<Integer> dice) {
        return numberSum(dice, 5);
    }

    public static int sixes(List<Integer> dice) {
        return numberSum(dice, 6);
    }

    public static boolean isPair(List<Integer> dice) {
        boolean result = false;

        for (int die : dice) {
            if (Collections.frequency(dice, die) == 2) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static boolean isThreeOfaKind(List<Integer> dice) {
        boolean result = false;

        for (int die : dice) {
            if (Collections.frequency(dice, die) == 3) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static int threeOfaKind(List<Integer> dice) {
        if (dice.size() != 5) {
            return -1;
        }

        int result = 0;

        if (isThreeOfaKind(dice)) {
            for (int die : dice) {
                result += die;
            }
        }

        return result;
    }

    public static boolean isFourOfaKind(List<Integer> dice) {
        boolean result = false;

        for (int die : dice) {
            if (Collections.frequency(dice, die) == 4) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static int fourOfaKind(List<Integer> dice) {
        if (dice.size() != 5) {
            return -1;
        }

        int result = 0;

        if (isFourOfaKind(dice)) {
            for (int die : dice) {
                result += die;
            }
        }

        return result;
    }

    // All dice are the same.
    public static boolean isYahtzee(List<Integer> dice) {
        boolean result = false;

        for (int die : dice) {
            if (Collections.frequency(dice, die) == 5) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static int yahtzee(List<Integer> dice) {
        if (dice.size() != 5) {
            return -1;
        }

        int result = 0;

        if (isYahtzee(dice)) {
            result = 50;
        }

        return result;
    }

    public static int fullHouse(List<Integer> dice) {
        if (dice.size() != 5) {
            return -1;
        }

        int result = 0;

        if ((isPair(dice) && isThreeOfaKind(dice))) {
            result = 25;
        }

        return result;
    }

    // Four consecutive in a row.
    public static int smallStraight(List<Integer> dice) {
        if (dice.size() != 5) {
            return -1;
        }

        int result = 0;
        int count = 1;

        Collections.sort(dice);

        for (int die = 1; die < dice.size(); ++die) {
            if (dice.get(die) == dice.get(die - 1) + 1) {
                ++count;

                if (count == 4) {
                    result = 30;
                    break;
                }
            } else {
                count = 1;
            }
        }

        return result;
    }

    // Five consecutive in a row.
    public static int largeStraight(List<Integer> dice) {
        if (dice.size() != 5) {
            return -1;
        }

        int result = 0;

        Collections.sort(dice);

        for (int die = 1; die < dice.size(); ++die) {
            if (dice.get(die) != dice.get(die - 1) + 1) {
                return result;
            }
        }

        result = 40;

        return result;
    }
}