package evaluator.lab4;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.model.Statistica;
import evaluator.utils.TestingUtils;
import org.junit.Test;

public class UnitTestsF3 {

	@Test
	public void testA() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateStatisticsException {

		AppController appController = new AppController();

		appController.addNewIntrebare(TestingUtils.getIntrebareRandom("Domeniu"));

		Statistica statistica = appController.getStatistica();

		assert statistica != null;
	}

	@Test(expected = NotAbleToCreateStatisticsException.class)
	public void testB() throws DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateStatisticsException {

		AppController appController = new AppController();

		Statistica statistica = appController.getStatistica();
	}

}
