package atomCreator;

public class Neutron extends Nucleon{

	@Override
	public String name() {
		return "Neutron";
	}

	@Override
	public double massKG() {
		return 1.674_927_498_04 * Math.pow(10, -27); // kg
	}

	@Override
	public double massU() {
		return 1.008_664_915_95; // u 
	}

	@Override
	public double restEnergy() { 
		return 939.565_420_52;
	}

	@Override
	public int electricLoad() { // RuheEnergie
		return 0; // MeV (ElectronVolt)
	}
	


}
