

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class UniverseTest {

	@Test fun test() {
		try {
			Assert.assertEquals("Running countAllStars(2, 3)...", 5, countAllStars(2, 3))
			Assert.assertEquals("Running countAllStars(9, -3)...", 6, countAllStars(9, -3))
			success(true)

			if (existsInFile("galaxies.sum()", File("./src/universe.kt"))) {
				message("My personal Yoda, you are. 🙏", "* ● ¸ .　¸. :° ☾ ° 　¸. ● ¸ .　　¸.　:. • ")
				message("My personal Yoda, you are. 🙏", "           　★ °  ☆ ¸. ¸ 　★　 :.　 .   ")
				message("My personal Yoda, you are. 🙏", "__.-._     ° . .　　　　.　☾ ° 　. *   ¸ .")
				message("My personal Yoda, you are. 🙏", "'-._\\7'      .　　° ☾  ° 　¸.☆  ● .　　　")
				message("My personal Yoda, you are. 🙏", " /'.-c    　   * ●  ¸.　　°     ° 　¸.    ")
				message("My personal Yoda, you are. 🙏", " |  /T      　　°     ° 　¸.     ¸ .　　  ")
				message("My personal Yoda, you are. 🙏", "_)_/LI");
			} else {
				message("Kudos 🌟", "Did you know that in Kotlin you can use the sum() function directly on an Array? Try it!")
				message("Kudos 🌟", "")
				message("Kudos 🌟", "var galaxies = arrayOf(37, 3, 2)")
				message("Kudos 🌟", "var totalStars = galaxies.sum() // 42")
			}
		} catch (ae: AssertionError) {
			success(false)
			message("Oops! 🐞", ae.message)
			message("Hint 💡", "Did you properly accumulate all stars into 'totalStars'? 🤔")
            annotate("universe.kt", 4, "Fix this line", type = AnnotateType.INFO)
		}
	}

	// check if a string exists in a text file
	fun existsInFile(str: String, file: File): Boolean {
		val scanner = Scanner(file)
		try {
			while (scanner.hasNextLine()) {
				if (scanner.nextLine().contains(str))
					return true
			}
			return false;
		} finally {
			scanner.close()
		}
	}
}
