package atomCreator;

/*
 * hier mal ein Update (ein paar Werte fehlten oder waren nicht gut gewählt)
 * z.B. Masse wird oft in u angegeben
 * in Neutron, Proton und Electron mal anpassen
 */

public interface AtomPart {
	Fusion fusion();
	String name();
	double massKG(); // Masse in KG
	double massU();  // Masse in atomarer Masseneinheit u
	double restEnergy(); // // RuheEnergie (in MeV)
	int electricLoad(); //  elektrische Ladung in eV; z.B. ein Elektron hat -1e was -1,602_176_634 · 10−19 C entspricht; ein Neutron hat 0 weil ladungsneutral
}
