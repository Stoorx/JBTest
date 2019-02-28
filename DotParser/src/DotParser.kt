package dotParser

import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import kotlin.system.exitProcess

class DotParser {
    companion object {
        @JvmStatic
        fun main(args: Array<String>)
        {
            if(args.size != 2){
                println("Incorrect arguments!")
                exitProcess(1)
            }
            val inputFile = FileInputStream(File(args[0]))
            val parser = Parser(Lexer(inputFile))

        }
    }
}