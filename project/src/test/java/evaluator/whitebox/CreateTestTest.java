package evaluator.whitebox;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.utils.TestingUtils;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class CreateTestTest {

	@Test(expected = NotAbleToCreateTestException.class)
	public void invalidTestCreation1() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {

		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));

		evaluator.model.Test result = appController.createNewTest();
	}

	@Test(expected = NotAbleToCreateTestException.class)
	public void invalidTestCreation2() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {

		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));

		evaluator.model.Test result = appController.createNewTest();
	}

	@Test
	public void validTestCreation1() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {

		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 1"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 2"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 3"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 4"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 5"));

		evaluator.model.Test result = appController.createNewTest();

		assert result != null;
		assert result.getIntrebari().size() == 5;
	}

}
