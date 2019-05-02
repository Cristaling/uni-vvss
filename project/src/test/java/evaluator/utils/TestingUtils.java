package evaluator.utils;

import evaluator.model.Intrebare;

import java.util.UUID;

public class TestingUtils {

	public static Intrebare getIntrebareRandom(String domeniu) {
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
