package evaluator.controller;

import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppControllerTest {

	private AppController appController;

	@Before
	public void setUp() throws Exception {
		appController = new AppController();
	}

	@Test
	public void addIntrebare1() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();

		appController.addNewIntrebare(intrebare);
	}

	@Test
	public void addIntrebare2() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();
		intrebare.setDomeniu(getStringOfLength(29, false));
		appController.addNewIntrebare(intrebare);
	}

	@Test
	public void addIntrebare3() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();
		intrebare.setDomeniu(getStringOfLength(30, false));
		appController.addNewIntrebare(intrebare);
	}

	@Test(expected = InputValidationFailedException.class)
	public void addIntrebare4() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();
		intrebare.setDomeniu(getStringOfLength(31, false));
		appController.addNewIntrebare(intrebare);
	}

	@Test
	public void addIntrebare5() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();
		intrebare.setEnunt(getStringOfLength(99, true));
		appController.addNewIntrebare(intrebare);
	}

	@Test
	public void addIntrebare6() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();
		intrebare.setEnunt(getStringOfLength(100, true));
		appController.addNewIntrebare(intrebare);
	}

	@Test(expected = InputValidationFailedException.class)
	public void addIntrebare7() throws DuplicateIntrebareException, InputValidationFailedException {
		Intrebare intrebare = getNewIntrebare();
		intrebare.setEnunt(getStringOfLength(101, true));
		appController.addNewIntrebare(intrebare);
	}

	private Intrebare getNewIntrebare() {
		Intrebare intrebare = new Intrebare();
		intrebare.setDomeniu("Domeniu 1");
		intrebare.setEnunt("Enunt 1?");
		intrebare.setVarianta1("1)Varianta 1");
		intrebare.setVarianta2("2)Varianta 2");
		intrebare.setVarianta3("3)Varianta 3");
		intrebare.setVariantaCorecta("3");

		return intrebare;
	}

	private String getStringOfLength(int size, boolean isQuestion) {
		StringBuilder result = new StringBuilder("A");
		for (int i = 2; i < size; i++) {
			result.append(i % 10);
		}
		if (isQuestion) {
			result.append("?");
		} else {
			result.append(size % 10);
		}
		return result.toString();
	}

}