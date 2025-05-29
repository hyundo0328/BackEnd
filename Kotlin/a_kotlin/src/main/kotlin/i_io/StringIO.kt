package i_io

import java.io.File

private val fileName = "StringIO.txt"
private val directory = "file"

fun main(){
//    createFile()
//    readFile()
//    readFileWithForEachLine()
    readText()
}

private fun createFile(){
    println("\n 1. 파일 생성")
    File("$directory/$fileName")
        .bufferedWriter().use {
            it.write("Hello \n")
            it.append("Kotlin \n")
            it.append("IO \n")
        }
}

private fun readFile(){
    println("\n 2. 파일 읽기")
    File("$directory/$fileName")
        .bufferedReader().use { reader ->
            var line: String? = ""
            while(reader.readLine().also { line = it } != null){
                println(line)
            }
        }
}

private fun readFileWithForEachLine(){
    println("\n 3. 파일 읽기")
    File("$directory/$fileName")
        .forEachLine { println(it) }
}

private fun readText(){
    println("\n 4. 파일 읽기")
    println(File("$directory/$fileName").readText())
}