package evaluator.gui;

import evaluator.controller.AppController;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.model.Statistica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppUI {

	private static String file;

	public AppUI(String file) {
		this.file = file;
	}

	public void startUI() throws IOException {

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		AppController appController = new AppController();

		boolean activ = true;
		String optiune = null;

		while(activ){

			System.out.println("");
			System.out.println("1.Adauga intrebare");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Exit");
			System.out.println("");

			optiune = console.readLine();

			switch(optiune){
				case "1" :
					break;
				case "2" :
					break;
				case "3" :
					appController.loadIntrebariFromFile(file);
					Statistica statistica;
					try {
						statistica = appController.getStatistica();
						System.out.println(statistica);
					} catch (NotAbleToCreateStatisticsException e) {
						// TODO
					}

					break;
				case "4" :
					activ = false;
					break;
				default:
					break;
			}
		}

	}

}
