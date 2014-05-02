/**
 * 
 */
package sm.jtemplate;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.*;

/**
 * @author smazumder
 *
 */

public class J8Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Generate a list of 100 random names
		List<String> students = range(0, 100).mapToObj(
				i -> randomString(new Random(), 'A', 'Z', 10))
				.collect(toList());
		// Sort the names and group by the first letter
		Map<Character, List<String>> directory = students.stream().sorted()
				.collect(groupingBy(name -> name.charAt(0)));

		// print out a nicely formatted student directory
		directory.forEach((letter, names) -> System.out.println(letter + "\n\t"
				+ names.stream().collect(joining("\n\t"))));

	}

	/**
	 * 
	 * Generates a random string of given length.
	 * 
	 * @param r
	 * @param from
	 * @param to
	 * @param length
	 * @return
	 */
	public static String randomString(Random r, char from, char to, int length) {
		return r.ints(from, to + 1)
				.limit(length)
				.collect(() -> new StringBuffer(),
						(sb, c) -> sb.append((char) c),
						(sb1, sb2) -> sb1.append(sb2)).toString();

	}

}
