package com.bbeniful.badandgoodexamples.coupling


class BadPdfGenerator
class BadReportCreator(
    val pdfGenerator: BadPdfGenerator
)

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

class GoodReportCreator() {
    fun createReport(generator: Generator) {
        generator.generate()
    }
}