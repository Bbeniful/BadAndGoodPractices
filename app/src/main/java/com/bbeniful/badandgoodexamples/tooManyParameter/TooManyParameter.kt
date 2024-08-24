package com.bbeniful.badandgoodexamples.tooManyParameter

import androidx.lifecycle.ViewModel

// Bad example
// Makes the code hard to read and maintain
class BadPerson(
    val name: String,
    val age: Int,
    val email: String,
    val address: String,
    val phone: String
)

//Solution
// Group the related data
// Makes the code easier to read and maintain
//We can use Dependency Injection for the Object

class PersonDetails(
    val email: String,
    val address: String,
    val phone: String
)
class GoodPerson(
    val name: String,
    val age: Int,
    val details: PersonDetails
)

//GMA Example
interface VegetableInterface

interface FruitInterface

interface PersonInterface

interface ProgrammingLanguageInterface

class BadViewModel(
    val vegetable: VegetableInterface,
    val fruit: FruitInterface,
    val person: PersonInterface,
    val language: ProgrammingLanguageInterface
): ViewModel()

data class Produce(
    val vegetable: VegetableInterface,
    val fruit: FruitInterface
)

data class Developer(
    val person: PersonInterface,
    val language: ProgrammingLanguageInterface
)

class GoodViewModel(
    private val produce: Produce,
    private val developer: Developer
): ViewModel()