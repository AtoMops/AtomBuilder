package atomCreator;

public class AtomBuilderMain {

	/*
	 * Atomare Masseneinheit: u = 1.660_539_066_605_0 * 10^-27 kg (1/12 der Masse
	 * eines Atoms des Kohlenstoff-Isotops 12C) oder in electronVolt (eV) u =
	 * 931.494_102_422_8 MeV/c^2.
	 * 
	 * hier zeigen wir die Masse in kg aber üblich ist es diese in der atomaren
	 * Masseneinheit (u) anzuzeigen
	 * 
	 * --> Seit 2019 ist die Avogadro-Konstante (Na) nicht mehr über die Masse des
	 * 12C-Atoms bestimmt, sondern per Definition exakt festgelegt. --> braucht man
	 * wenn man in g/mol umrechnen will (1u * Na --> g/mol)
	 * 
	 * Zur Differerenz von Atomgewichten: Es ist .. eine Differenz zum Tatsächlichen
	 * Atomgewicht .. vorhanden. Der Grund sind die leicht unterschiedlichen Massen
	 * von Neutron und Proton und der sogenannte Massendefekt. Atomkerne aus
	 * mehreren Nukleonen sind leichter als die addierte Masse der isolierten
	 * Nukleonen.
	 * 
	 * --> da wir hier Nukleonen-Gewichte addieren können wir nicht auf die
	 * empirischen Werte kommen oO' zudem ist auch oft das mittlere Atomgewicht
	 * aller stabilen Isotope angegeben
	 * 
	 * Es gibt 2 stabile Lithiumisotope:
	 * 
	 * Lithium 6/3 (7,4 %) Lithium 7/3 (92,6 %)
	 * 
	 * (0,0746)+(0,9267)=6,926 ~ mittleres Atomgewicht Lithium
	 * 
	 * 
	 * Konstante zur Berechnung des Massendefekts (Differenz des Gewichts des AtomKerns zum gesamtem Atom)
	 * Lichtgeschwindigkeit = 299 792 458 m/s
	 * Atomare MassenEinheit u = 1.006 539 066 60 *10(-27)
	 * ProtonMasse(u) = 1,007 276 466 583(15)(29) u 
	 * also:  1,007 276 466 583 u  (ohne die Varianz in Klammern)
	 * wir müssen also ProtonMasse(u)*u  
	 * 
	 *  Protonenmasse in u. 
	 *  Die eingeklammerten Ziffern bezeichnen die Unsicherheit in den letzten Stellen des Wertes,
	 *  diese Unsicherheit ist als geschätzte Standardabweichung des angegebenen Zahlenwertes
	 *  vom tatsächlichen Wert angegeben 
	 * 
	 * MassendDefekt ist gleich der KernBindungsEnergie
	 * Die Masse des Kerns ist schwerer als die Masse des GesamtAtoms
	 * 
	 * MassenDefekt = MasseKern-MasseAtom  (deltaM = mK-mA)
	 * für deltaM sollten wir einen positiven Wert bekommen (da die KernMasse ja höher ist als die Masse des gesamten Atoms)
	 * 
	 * dann: 
	 * E = m*c²
	 * E = deltaM*c²  (also wir tragen statt Masse M unsere MassenDifferenz (oder MassenDefekt) deltaM ein)
	 * 
	 * Vorsicht! Die BindungsEnergie der Nukleonen nimmt bis zu einer Massenzahl von 70 ZU
	 * aber ab einer Massenzahl von über 70 AB!
	 * Das liegt wohl an der Menge der Nukleonen im Kern (also der MassenZahl selbst)
	 * und dem Abstand der einzelner Nukleonen von der Mitte des AtomKerns
	 * In der Mitte des AtomKerns ist die KernBindungsEnergie am höchsten
	 * Warum die BindungsEnergie bis zur MassenZahl 70 zunimmt? KA oO'
	 * 
	 */


	// atomare Masseneinheit
	static double u = 1.660_539_066_60 * Math.pow(10, -27); // in kg 
	// Lichtgeschwindigkeit in m/s
	static double c = 299_792_458;
	// Coloumb eines elektrons; zur Umrechnung von Joule zu eV
	static double electronColoumb = 1.602_176_634 * Math.pow(10, -19); 
	
	
	public static void main(String[] args) {

		AtomBuilder buildAtom = new AtomBuilder();

		Atom helium = buildAtom.createHelium();

		helium.showItems();
		System.out.println();
		System.out.println("Mass Helium in kg: " + helium.getMassKG() + " kg");
		System.out.println("Mass Helium in u: " + helium.getMassU() + " u");
		System.out.println("elec. Load: " + helium.getElectricLoad() + " e");

		System.out.println();
		
		double uProton = 1.007; 
		double uNeutron = 1.008;
		
		uProton*=2;
		uNeutron*=2;
		
		double masseKern = uProton+uNeutron;
		double masseAtom = 4.002602; // Masse helium-Atom
		
		System.out.println("masseKern: " + masseKern + ";\nmasseAtom: " + masseAtom);
		
		double deltaMasse = masseKern-masseAtom;
		
		System.out.println("deltaMasse: " + deltaMasse);
		
		System.out.println();
		// KernBindungsEnergie Helium
		
		double eJoule = deltaMasse*c*c;
		System.out.println("eJoule: " + eJoule);
		
		double eColoumb = eJoule/Math.pow(10, 6);
		System.out.println("eColoumb: " + eColoumb);
		
		System.out.println();
		
		
		
		// E = m*c²
//		double mKern = helium.getMassU()*u; // das hier geht schief oO' 
		
		// erst einzelne Nukleonen-Typen ansteuern (Proton | Neutron) dann multiplizieren
		// oder nur z.B. nur Protonen-Gewichte und dann mal u (weil wir ja 2*proton und 2*neutron rechnen )
		Proton proton = new Proton();
		Neutron neutron = new Neutron();
		
		double mKernProton = proton.massU()*helium.getAmountProtons()*u;
		double mKernNeutron = neutron.massU()*helium.getAmountNeutrons()*u;
		
		System.out.println("mKernProton: " + mKernProton);
		System.out.println("mKernNeutron: " + mKernNeutron);
		
		System.out.println("mKernProton2: " + helium.getMassUProton()*u);
		System.out.println("mKernNeutron2: " + helium.getMassUNeutron()*u);
		
		double massHelium = mKernProton+mKernNeutron;
		System.out.println("massHelium: "  + massHelium);
		System.out.println("massHelium2: "  + helium.getMassU()*u);
		
		double masseAtomHelium = 4.002602; // Masse helium-Atom
		double deltaM_helium = massHelium-(masseAtomHelium*u);
		System.out.println("deltaM_helium: " + deltaM_helium);
		
		double energieJoule1 = deltaM_helium*c*c; 
		
		System.out.println("energieJoule1: " + energieJoule1);
		double energieColoumb1 = energieJoule1/electronColoumb;
		System.out.println("EColoumb1: " + energieColoumb1/Math.pow(10, 6));
		System.out.println();
		
		
		
		
		
		double beNucleon = 7073.915; // BindungsEnergie eines Nucleons in KeV (Wert aus Tabelle)
		
		System.out.println("BindungsEnergie Helium in MeV: " + beNucleon*4/1000); 
		
		System.out.println();
		
		double energieJoule = (deltaMasse*u)*c*c; // deltaMasse*u geht wahrscheinlich schief; wir müssen die einzelnen Werte umrechnen
		System.out.println("EJoule: " + energieJoule);
		
		double energieColoumb = energieJoule/electronColoumb;
		System.out.println("EColoumb: " + energieColoumb/Math.pow(10, 6));
		
		
		
//		double mKern = mKernProton + mKernNeutron;
//		double mAtom = 4*u;
//		
//		System.out.println("mKern: " + mKern);
//		System.out.println("mAtom: " + mAtom);
//		
//		double deltaM = mKern-mAtom;
//		
//		System.out.println("deltaM: " + deltaM);
		
		
//		double mAtom = 4*u;
//		System.out.println("mKern: " + mKern + ";\nmAtom: " + mAtom);
//		
//		double deltaM = mKern-mAtom;
//		System.out.println("deltaM: " + deltaM);
//		
//		
//		double energyJoule = deltaM*c*c; // E = m*c²;
//		
//		
//		System.out.println("Energy Joule: " + energyJoule);
//		
//		double freeBindingEnergy = energyJoule/electronColoumb; // eV
//		
//		System.out.println("freiwerdende KernBindungsEnergie: " + freeBindingEnergy);
//		
//		double atomMasseHelium = helium.getMassU();
//		
//		System.out.println("atomMasseHelium: " + atomMasseHelium);
		
		
		
	}

}
