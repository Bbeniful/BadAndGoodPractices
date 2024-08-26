package com.bbeniful.badandgoodexamples.coupling

// Hard to maintain and test
// This is tightly coupled
// The class is dependent on the PdfGenerator
// If we want to change the generator, we have to change the report creator
class BadPdfGenerator
class BadReportCreator(
    val pdfGenerator: BadPdfGenerator
)
// Good example
// This is loosely coupled
// We can create a new generator without changing the report creator
interface Generator {
    fun generate()
}

class PdfGenerator : Generator {
    override fun generate() {
        TODO("Not yet implemented")
    }
}

class ExcelGenerator : Generator {
    override fun generate() {
        TODO("Not yet implemented")
    }
}

// We can easily change the generator without changing the report creator
class GoodReportCreator() {
    fun createReport(generator: Generator) {
        generator.generate()
    }
}