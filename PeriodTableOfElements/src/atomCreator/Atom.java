package atomCreator;

import java.util.ArrayList;
import java.util.List;

public class Atom {

	/*
	 * hier nochmal checken wir müssen bei der MassenBerechnung Nukleonen von
	 * ElementarTeilchen (hier nur Elektronen) trennen also nicht noch die Masse der
	 * Elektronen mitrechnen sonst haut der MassenDefekt nicht hin oO'
	 * 
	 */

	private List<AtomPart> atoms = new ArrayList<AtomPart>();

	public void addItem(AtomPart atom) {
		atoms.add(atom);
	}

	public int getElectricLoad() {
		int atomElecLoad = 0;

		for (AtomPart atom : atoms) {
			atomElecLoad += atom.electricLoad();
		}
		return atomElecLoad;
	}

	public double getMassKG() {
		double atomMass = 0.0D;

		for (AtomPart atom : atoms) { // only take Nucleons into account
			if (atom.getClass() == Proton.class || atom.getClass() == Neutron.class) {
				atomMass += atom.massKG();
			}
		}
		return atomMass;
	}

	public double getMassU() {
		double atomMass = 0.0D;

		for (AtomPart atom : atoms) { // only take Nucleons into account
			if (atom.getClass() == Proton.class || atom.getClass() == Neutron.class) {
				atomMass += atom.massU();
			}
		}
		return atomMass;
	}

	public double getMassKGProton() {
		double atomMass = 0.0D;

		for (AtomPart atom : atoms) { // only take Protons into account
			if (atom.getClass() == Proton.class) {
				atomMass += atom.massKG();
			}
		}
		return atomMass;
	}

	public double getMassUProton() {
		double atomMass = 0.0D;

		for (AtomPart atom : atoms) { // only take Protons into account
			if (atom.getClass() == Proton.class) {
				atomMass += atom.massU();
			}
		}
		return atomMass;
	}

	public double getMassKGNeutron() {
		double atomMass = 0.0D;

		for (AtomPart atom : atoms) { // only take Protons into account
			if (atom.getClass() == Neutron.class) {
				atomMass += atom.massKG();
			}
		}
		return atomMass;
	}

	public double getMassUNeutron() {
		double atomMass = 0.0D;

		for (AtomPart atom : atoms) { // only take Protons into account
			if (atom.getClass() == Neutron.class) {
				atomMass += atom.massU();
			}
		}
		return atomMass;
	}

	public int getAmountElectrons() {
		int amount = 0;
		for (AtomPart atom : atoms) {
			if (atom.getClass() == Electron.class) {
				amount++;
			}
		}
		return amount;
	}
	
	public int getAmountProtons() {
		int amount = 0;
		for (AtomPart atom : atoms) {
			if (atom.getClass() == Proton.class) {
				amount++;
			}
		}
		return amount;
	}
	
	public int getAmountNeutrons() {
		int amount = 0;
		for (AtomPart atom : atoms) {
			if (atom.getClass() == Neutron.class) {
				amount++;
			}
		}
		return amount;
	}
	

	public void showItems() {

		for (AtomPart atom : atoms) {
			System.out.print("Atom-Part: " + atom.name());
			System.out.print("; Mass (kg): " + atom.massKG());
			System.out.print("; Mass (u): " + atom.massU());
			System.out.println("; Electric load (e): " + atom.electricLoad());
		}
	}

}
