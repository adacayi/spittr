package com.sanver.trials.spittr.spitter;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.sanver.trials.spittr.Spitter;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class SpitterControllerTest {
	@Test
	public void shouldShowRegistrationForm() throws Exception {
		SpitterRepository repository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(repository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
	}

	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
		Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
		when(mockRepository.save(unsaved)).thenReturn(saved);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register").param("firstName", "Jack").param("lastName", "Bauer")
				.param("username", "jbauer").param("password", "24hours")).andExpect(redirectedUrl("/spitter/jbauer"));
		verify(mockRepository, atLeastOnce()).save(unsaved);
	}

	@Test
	public void shouldShowProfile() throws Exception {
		SpitterRepository repository = mock(SpitterRepository.class);
		Spitter bauer = new Spitter("jbauer", "24hours", "Jack", "Bauer");
		when(repository.findByUsername("jbauer")).thenReturn(bauer);
		SpitterController controller = new SpitterController(repository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/jbauer")).andExpect(view().name("profile"))
				.andExpect(model().attributeExists("spitter")).andExpect(model().attribute("spitter", bauer));
	}

	@Test
	public void shouldRedirectHomeIfInvalidUser() throws Exception {
		SpitterRepository repository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(repository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/jbauer")).andExpect(redirectedUrl("/"));
	}

	@Test
	public void validationNotSuccessful() throws Exception {
		SpitterRepository repository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(repository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register").param("firstName", "").param("lastName", "").param("username", "")
				.param("password", "")).andExpect(view().name("registerForm"));
	}
}
