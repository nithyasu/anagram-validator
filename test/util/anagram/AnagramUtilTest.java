package util.anagram;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnagramUtilTest {
	static AnagramUtil anagramUtil;

	@BeforeClass
	public static void setUp() {
		anagramUtil = new AnagramUtil("adobe laya   abode    mala odabe");
	}

	@Test
	public void testAnagramExists() {
		assertEquals(Arrays.asList("abode", "odabe"), anagramUtil.findAllAnagrams("adobe"));
	}

	@Test
	public void testAnagramNotExists() {
		assertEquals(Collections.emptyList(), anagramUtil.findAllAnagrams("mala"));
		assertEquals(Collections.emptyList(), anagramUtil.findAllAnagrams("silent"));
	}

	@Test
	public void testAnagramForNullOrEmptyInput() {
		assertEquals(Collections.emptyList(), anagramUtil.findAllAnagrams(null));
		assertEquals(Collections.emptyList(), anagramUtil.findAllAnagrams(""));
	}

}
