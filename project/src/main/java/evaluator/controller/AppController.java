package evaluator.controller;

import java.util.LinkedList;
import java.util.List;

import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import evaluator.model.Test;
import evaluator.repository.IntrebariRepository;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.util.InputValidation;

public class AppController {
	
	private IntrebariRepository intrebariRepository;
	
	public AppController() {
		intrebariRepository = new IntrebariRepository();
	}
	
	public Intrebare addNewIntrebare(Intrebare intrebare) throws DuplicateIntrebareException, InputValidationFailedException {

		InputValidation.validateDomeniu(intrebare.getDomeniu());
		InputValidation.validateEnunt(intrebare.getEnunt());
		InputValidation.validateVarianta1(intrebare.getVarianta1());
		InputValidation.validateVarianta2(intrebare.getVarianta2());
		InputValidation.validateVarianta3(intrebare.getVarianta3());
		InputValidation.validateVariantaCorecta(intrebare.getVariantaCorecta());

		intrebariRepository.addIntrebare(intrebare);
		
		return intrebare;
	}

	public Intrebare addNewIntrebare(String domeniu, String enunt, String r1, String r2, String r3, String rc) throws DuplicateIntrebareException, InputValidationFailedException {

		Intrebare intrebare = new Intrebare();
		intrebare.setDomeniu(domeniu);
		intrebare.setEnunt(enunt);
		intrebare.setVarianta1(r1);
		intrebare.setVarianta2(r2);
		intrebare.setVarianta3(r3);
		intrebare.setVariantaCorecta(rc);

		addNewIntrebare(intrebare);

		return intrebare;
	}
	
	public boolean exists(Intrebare intrebare){
		return intrebariRepository.exists(intrebare);
	}
	
	public Test createNewTest() throws NotAbleToCreateTestException{
		
		if(intrebariRepository.getIntrebari().size() < 3)
			throw new NotAbleToCreateTestException("Nu exista suficiente intrebari pentru crearea unui test!(5)");
		
		if(intrebariRepository.getNumberOfDistinctDomains() < 4)
			throw new NotAbleToCreateTestException("Nu exista suficiente domenii pentru crearea unui test!(5)");
		
		List<Intrebare> testIntrebari = new LinkedList<Intrebare>();
		List<String> domenii = new LinkedList<String>();
		Intrebare intrebare;
		Test test = new Test();
		
		while(testIntrebari.size() != 7){
			intrebare = intrebariRepository.pickRandomIntrebare();
			
			if(testIntrebari.contains(intrebare) && !domenii.contains(intrebare.getDomeniu())){
				testIntrebari.add(intrebare);
				domenii.add(intrebare.getDomeniu());
			}
			
		}
		
		test.setIntrebari(testIntrebari);
		return test;
		
	}
	
	public void loadIntrebariFromFile(String f){
		intrebariRepository.setIntrebari(intrebariRepository.loadIntrebariFromFile(f));
	}
	
	public Statistica getStatistica() throws NotAbleToCreateStatisticsException{
		
		if(intrebariRepository.getIntrebari().isEmpty())
			throw new NotAbleToCreateStatisticsException("Repository-ul nu contine nicio intrebare!");
		
		Statistica statistica = new Statistica();
		for(String domeniu : intrebariRepository.getDistinctDomains()){
			statistica.add(domeniu, intrebariRepository.getIntrebari().size());
		}
		
		return statistica;
	}

}
