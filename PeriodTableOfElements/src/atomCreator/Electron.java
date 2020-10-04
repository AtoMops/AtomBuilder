package atomCreator;

public class Electron extends Lepton{

	@Override
	public String name() {
		return "Electron";
	}

	@Override
	public double massKG() {
		return 9.109_383_701_5 * Math.pow(10, -31); //kg 
	}

	@Override
	public double massU() {
		return 5.485_799_090_65 * Math.pow(10, -4); // u
	}
	
	@Override
	public double restEnergy() {
		return  0.510_998_950_00; // MeV (ElectronVolt) 
	}
	
	@Override
	public int electricLoad() { // das hier ist die "Ruheenergie"; die elek. Ladung wäre 1 e- oder −1.602_176_634 · 10−19 Coloumb
		return -1;
	}

	

	
}
