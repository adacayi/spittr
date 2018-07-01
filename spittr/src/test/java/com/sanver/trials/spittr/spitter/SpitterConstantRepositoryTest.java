package com.sanver.trials.spittr.spitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sanver.trials.spittr.Spitter;

public class SpitterConstantRepositoryTest {

	private static SpitterRepository repository;

	@BeforeAll
	public static void setUp() {
		repository = new SpitterConstantRepository();
	}

	@AfterAll
	public static void tearDown() {
		repository = null;
	}

	@Test
	public void repositoryNotEmpty() {
		assertNotNull(repository);
		assertTrue(repository.findSpitters(100, 20).size() > 0, "Repository empty");
	}

	@Test
	public void repositoryCountCorrect() {
		assertNotNull(repository);
		int expected = 50;
		int actual = repository.findSpitters(110, 50).size();
		assertEquals(expected, actual, "Filtering incorrect. Requested size is 50");
	}

	@Test
	public void repositorySaveWorking() {
		assertNotNull(repository);
		Spitter spitter = new Spitter("asanver", "1234", "Ahmet", "Sanver");
		Spitter expected = spitter;
		Spitter actual = repository.save(spitter);
		assertEquals(expected, actual, "Record not added");
		actual = repository.findByUsername(new String("asanver"));// We purposefully put new String("asanver") to test
																	// if String comparison is not done with == operator
		assertEquals(expected, actual, "Record not found");
	}

	@Test
	public void repositoryInvalidRecord() {
		assertNotNull(repository);
		String username = "asanver";
		Spitter expected = null;
		Spitter actual = repository.findByUsername(username);
		assertEquals(expected, actual, "Invalid record found.");
	}
}
