package evaluator.whitebox;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class CreateTestTest {

	@Test(expected = NotAbleToCreateTestException.class)
	public void invalidTestCreation1() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {

		AppController appController = new AppController();

		appController.addNewIntrebare(getIntrebareRandom("Domeniu"));

		evaluator.model.Test result = appController.createNewTest();
	}

	@Test(expected = NotAbleToCreateTestException.class)
	public void invalidTestCreation2() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {

		AppController appController = new AppController();

		appController.addNewIntrebare(getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu"));

		evaluator.model.Test result = appController.createNewTest();
	}

	@Test
	public void validTestCreation1() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {

		AppController appController = new AppController();

		appController.addNewIntrebare(getIntrebareRandom("Domeniu 1"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu 2"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu 3"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu 4"));
		appController.addNewIntrebare(getIntrebareRandom("Domeniu 5"));

		evaluator.model.Test result = appController.createNewTest();

		assert result != null;
		assert result.getIntrebari().size() == 5;
	}

	private Intrebare getIntrebareRandom(String domeniu) {
		Intrebare intrebare = new Intrebare();
		intrebare.setDomeniu(domeniu);
		intrebare.setEnunt("A" + UUID.randomUUID().toString() + "?");
		intrebare.setVarianta1("1)Varianta 1");
		intrebare.setVarianta2("2)Varianta 2");
		intrebare.setVarianta3("3)Varianta 3");
		intrebare.setVariantaCorecta("3");

		return intrebare;
	}

}
