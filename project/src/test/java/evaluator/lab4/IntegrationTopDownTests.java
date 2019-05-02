package evaluator.lab4;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import evaluator.utils.TestingUtils;
import org.junit.Test;

public class IntegrationTopDownTests {



	@Test
	public void testA() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateStatisticsException {

		AppController appController = new AppController();

		Intrebare intrebare = TestingUtils.getIntrebareRandom("Domeniu");
		appController.addNewIntrebare(intrebare);

		assert appController.exists(intrebare);
	}

	@Test
	public void testB() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException {
		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 113"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 213"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 313"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 413"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 513"));

		evaluator.model.Test result = appController.createNewTest();

		assert result != null;
		assert result.getIntrebari().size() == 5;
	}

	@Test
	public void testC() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateStatisticsException {

		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));

		Statistica statistica = appController.getStatistica();

		assert statistica != null;
	}

	@Test
	public void testIntegrationA() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException, DuplicateIntrebareException, InputValidationFailedException {

		AppController appController = new AppController();

		Intrebare intrebare = TestingUtils.getIntrebareRandom("Domeniu");
		appController.addNewIntrebare(intrebare);

		assert appController.exists(intrebare);
	}

	@Test
	public void testIntegrationB() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException, DuplicateIntrebareException, InputValidationFailedException {

		AppController appController = new AppController();

		Intrebare intrebare = TestingUtils.getIntrebareRandom("Domeniu");
		appController.addNewIntrebare(intrebare);

		assert appController.exists(intrebare);

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 113"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 214"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 351"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 461"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 571"));

		evaluator.model.Test result = appController.createNewTest();
	}

	@Test
	public void testIntegrationC() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException, DuplicateIntrebareException, InputValidationFailedException {

		AppController appController = new AppController();

		Intrebare intrebare = TestingUtils.getIntrebareRandom("Domeniu");
		appController.addNewIntrebare(intrebare);

		assert appController.exists(intrebare);

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 113"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 214"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 351"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 461"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 571"));

		evaluator.model.Test result = appController.createNewTest();

		assert result != null;
		assert result.getIntrebari().size() == 5;

		Statistica statistica = appController.getStatistica();

		assert statistica != null;
	}


}
