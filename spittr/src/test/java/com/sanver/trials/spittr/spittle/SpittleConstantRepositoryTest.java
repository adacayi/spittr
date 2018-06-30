package com.sanver.trials.spittr.spittle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SpittleConstantRepositoryTest {

	@Test
	public void repositoryNotEmpty() {
		SpittleRepository repository = new SpittleConstantRepository();
		assertNotNull(repository);
		assertTrue(repository.findSpittles(Long.MAX_VALUE, 100).size() > 0, "Repository empty");
	}
}
