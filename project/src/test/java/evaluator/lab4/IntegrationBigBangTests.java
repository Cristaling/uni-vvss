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

public class IntegrationBigBangTests {



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

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 11"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 21"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 31"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 41"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 51"));

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
	public void testIntegration() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException, DuplicateIntrebareException, InputValidationFailedException {

		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 121"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 212"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 312"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 412"));
		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu 512"));

		evaluator.model.Test result = appController.createNewTest();

		assert result != null;
		assert result.getIntrebari().size() == 5;

		Statistica statistica = appController.getStatistica();

		assert statistica != null;
	}


}
