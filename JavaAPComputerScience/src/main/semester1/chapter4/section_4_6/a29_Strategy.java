/*
 * Exercise 4.29*  Find the best strategy for getting the right answer in the fewest guesses
 * for the revision of GuessNumber described in the preceding exercise.
 *
 *
 * Answer:
 *
 * Knowing the program never lies twice in a row and that it lies only about being too high,
 * after encountering too many "too high" messages, I can randomly pick a message showing
 * "too high" and assume it means "too low."
 * Then, I guess accordingly by choosing a higher  number.
 */

