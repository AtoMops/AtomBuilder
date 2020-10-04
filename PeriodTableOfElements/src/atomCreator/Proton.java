package atomCreator;

public class Proton extends Nucleon{

	@Override
	public String name() {
		return "Proton";
	}

	@Override
	public double massKG() {
		return 1.672_621_923_69 * Math.pow(10,-27); // kg
	}
	
	@Override
	public double massU() {
		return 1.007_276_466_583; // u
	}

	@Override
	public double restEnergy() {
		return 938.272_088_16; // MeV (ElectronVolt)
	}
	
	@Override
	public int electricLoad() {
		return 1;
	}
	

	

}
