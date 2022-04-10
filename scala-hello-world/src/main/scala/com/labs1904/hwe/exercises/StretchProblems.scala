package com.labs1904.hwe.exercises

object StretchProblems {

  /*
  Checks if a string is palindrome.
 */
  def isPalindrome(s: String): Boolean = {
    if (s.length == 0) {
      return true
    } else if (s(0) != s(s.length - 1)){
      return false
    } else {
      isPalindrome(s.substring(1, s.length - 1))
    }
  }

  /*
For a given number, return the next largest number that can be created by rearranging that number's digits.
If no larger number can be created, return -1
 */
  def getNextBiggestNumber(i: Integer): Int = {
    // in some way, traverse from tail. If you come across a number that is greater than the next, swap

//    val strI = i.toString;
    val reversedStrI = (i.toString).reverse


  }

}
