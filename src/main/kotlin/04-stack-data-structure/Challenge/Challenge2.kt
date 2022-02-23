package `04-stack-data-structure`.Challenge

import `04-stack-data-structure`.StackImpl

/*:
 # Stack Challenges
 ## Challenge 2:
    Check for balanced parentheses.
    Given a string, check if there are `(` and `)` characters,
    and return `true` if the parentheses in the string are balanced.
    For example:
    h((e))llo(world)() // balanced parentheses
    (hello world // unbalanced parentheses
 */

fun String.checkParentheses(): Boolean {

    val stack = StackImpl<Char>()
    for (char in this) {
        when (char) {
            '(' -> stack.push(char)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }

    return stack.isEmpty
}