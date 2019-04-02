package evaluator.repository;

import evaluator.controller.AppController;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntrebariRepositoryTest {

	private AppController appController;

	private Intrebare intrebare1;
	private Intrebare intrebare2;
	private Intrebare intrebare3;

	@Before
	public void setUp() throws Exception {
		appController = new AppController();

		intrebare1 = new Intrebare();
		intrebare1.setDomeniu("Domeniu 1");
		intrebare1.setEnunt("Enunt 1?");
		intrebare1.setVarianta1("1)Varianta 1");
		intrebare1.setVarianta2("2)Varianta 2");
		intrebare1.setVarianta3("3)Varianta 3");
		intrebare1.setVariantaCorecta("3");

		intrebare2 = new Intrebare();
		intrebare2.setDomeniu("Domeniu 2");
		intrebare2.setEnunt("Enunt 2?");
		intrebare2.setVarianta1("1)Varianta 1");
		intrebare2.setVarianta2("2)Varianta 2");
		intrebare2.setVarianta3("3)Varianta 3");
		intrebare2.setVariantaCorecta("5");

		intrebare3 = new Intrebare();
		intrebare3.setDomeniu("Domeniu 3");
		intrebare3.setEnunt("Enunt 3?");
		intrebare3.setVarianta1("1)Varianta 1");
		intrebare3.setVarianta2("2)Varianta 2");
		intrebare3.setVarianta3("3)Varianta 3");
		intrebare3.setVariantaCorecta("2");

		appController.addNewIntrebare(intrebare1);
	}

	@Test(expected = DuplicateIntrebareException.class)
	public void addIntrebare1() throws DuplicateIntrebareException, InputValidationFailedException {
		this.appController.addNewIntrebare(intrebare1);
	}

	@Test(expected = InputValidationFailedException.class)
	public void addIntrebare2() throws DuplicateIntrebareException, InputValidationFailedException {
		this.appController.addNewIntrebare(intrebare2);
	}

	@Test
	public void addIntrebare3() throws DuplicateIntrebareException, InputValidationFailedException {
		this.appController.addNewIntrebare(intrebare3);
		assert this.appController.exists(intrebare3);
	}
}