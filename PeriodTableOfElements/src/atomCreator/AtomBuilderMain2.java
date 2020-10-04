package atomCreator;

public class AtomBuilderMain2 {

	// atomare Masseneinheit
		static double u = 1.660_539_066_60 * Math.pow(10, -27); // in kg 
		// Lichtgeschwindigkeit in m/s
		static double c = 299_792_458;
		// Coloumb eines elektrons; zur Umrechnung von Joule zu eV
		static double electronColoumb = 1.602_176_634 * Math.pow(10, -19); 
		
		
	public static void main(String[] args) {
		
		AtomBuilder buildAtom = new AtomBuilder();

		Atom helium = buildAtom.createHelium();
		
		/*	hier mal Berthe-Weizsäcker-Formel ("Tröpfen-Modell") implementieren
		 * die Zahlen werden nicht ganz hinhauen allein schon wegen 
		 * verschiedener MassenDefekte bei unterschiedlichen Nukleonen-Zahlen
		 * "Die Formel ist unbrauchbar für sehr leichte Atomkerne mit geringer Nukleonenzahl,
		 *  für größere Kerne ist sie eine gute Näherung. Aber auch hier kann sie beispielsweise 
		 *  die Magischen Zahlen nicht erklären, erst das Schalenmodell liefert dafür eine Erklärung. "
		 */
		
		Proton proton = new Proton();
		Neutron neutron = new Neutron();
		
		/* "Über die Bindungsenergie lässt sich die gesamte Kernmasse m berechnen."
		 *  Hier KernBindungs-Energie (Ruhe-Energie) der Nukleonen in  MeV/c² 
		 */
		System.out.println("Proton: " + proton.restEnergy());
		System.out.println("Neutron: " + neutron.restEnergy());
		
		/*	"Atomkerne sind leichter als die Summe ihrer Bestandteile (Protonen- und Neutronenmassen):"
		 *  die KernMasse mK kann man berechnen mit:
		 *  
		 *  mK = MasseAtom-OrdungsZahl(bzw. AnzahlDerProtonen)*ElektronenMasse(mE)+ (BindundsEnergieAllerElektronen(eB)/LichtGeschwindigKeit²)
		 *  oder kurz:
		 *  mK = mA-Z*mE+(eB/c²)
		 *  
		 *  Die elektronische BindungsEnergie wird auch als "elektronischer MassenDefekt"bezeichnet
		 *  delta-mE = (eB/c²)
		 *  aber:
		 *  "Die Bindungsenergie eB der Elektronenhülle kann experimentell nicht direkt bestimmt werden, 
		 *  stattdessen ist man auf theoretische Abschätzungen angewiesen."
		 *  
		 */
		
		double mKernProton = proton.restEnergy()*helium.getAmountProtons();
		double mKernNeutron = neutron.restEnergy()*helium.getAmountNeutrons();
		
		
	}
}
