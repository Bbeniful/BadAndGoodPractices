package com.bbeniful.badandgoodexamples.longFunctions

class LongAndTooComplexFunctions {

    //Bad example
    //Very hard to maintain and understand
    fun processData(input: String): String {
        var result = ""
        val reversedInput = input.reversed()
        val charArray = reversedInput.toCharArray()
        var i = 0
        while (i < charArray.size) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                result += charArray[i].uppercaseChar()
                result += charArray[i].uppercaseChar()
            } else {
                result += charArray[i]
                result += charArray[i]
                result += charArray[i]
            }
            i++
        }

        result = result.reversed()
        return result
    }

    //Solution
    //Each method does only one thing and does it well.
    //Easy to read, maintain and understand
    fun processString(input: String): String {
        val reversed = reverseString(input)
        val processed = processCharacters(reversed)
        return reverseString(processed)
    }

    private fun reverseString(input: String): String {
        return input.reversed()
    }

    private fun processCharacters(input: String): String {
        var result = ""
        for (char in input) {
            result += if (isVowel(char)) {
                duplicateCharacter(char.uppercaseChar())
            } else {
                triplicateCharacter(char)
            }
        }
        return result
    }

    private fun isVowel(char: Char): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        return char.lowercaseChar() in vowels
    }

    private fun duplicateCharacter(char: Char): String {
        return "$char$char"
    }

    private fun triplicateCharacter(char: Char): String {
        return "$char$char$char"
    }
}