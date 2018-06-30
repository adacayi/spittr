package com.sanver.trials.spittr.spittle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SpittleConstantRepositoryTest {

	private static SpittleRepository repository;

	@BeforeAll
	public static void setUp() {
		repository = new SpittleConstantRepository();
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
	}

	@Test
	public void repositoryNotEmpty() {
		assertNotNull(repository);
		assertTrue(repository.findSpittles(100, 20).size() > 0, "Repository empty");
	}

	@Test
	public void repositoryCountCorrect() {
		assertNotNull(repository);
		int expected = 50;
		int actual = repository.findSpittles(110, 50).size();
		assertEquals(expected, actual, "Filtering incorrect. Requested size is 50");
	}
}
