package com.example.dising_pattern_android.factory


                                    /**Pattern Factory**/
interface FileParserFactory {
    fun createFileParser(fileName: String): FileParserFactory
}

class StandartFileParserFactory : FileParserFactory {
    override fun createFileParser(fileName: String) =
        when (fileName.substringAfterLast('.')) {
            "xml" -> XmlFileParse()
            "json" -> JsonFileParser()
            else -> throw Exception("Неизвестный тип файла $fileName")
        }
}

class XmlFileParse : FileParserFactory {
    override fun createFileParser(fileName: String): FileParserFactory {
        return XmlFileParse()
    }
}

class JsonFileParser : FileParserFactory {
    override fun createFileParser(fileName: String): FileParserFactory {
        return XmlFileParse()
    }
}
