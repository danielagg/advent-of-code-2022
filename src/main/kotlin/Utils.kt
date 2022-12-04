import java.io.File

class Utils {
    companion object {
        fun readFile(path: String): List<String> {
            return File(path).readLines()
        }
    }
}