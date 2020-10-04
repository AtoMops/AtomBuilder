package atomCreator;

public class AtomBuilder {

    // create Hydrogen-Atom
	  public Atom createHydrogen(){
		  Atom hydrogen = new Atom();
		  hydrogen.addItem(new Proton());
//		  hydrogen.addItem(new Neutron()); // Hydrogen only has a Proton in core (special case)
		  hydrogen.addItem(new Electron());
	      return hydrogen;
	   }  
	  
	  public Atom createHelium(){
		  Atom helium = new Atom();
		  for (int i = 0; i < 2; i++) {
			  helium.addItem(new Proton());
			  helium.addItem(new Neutron()); 
			  helium.addItem(new Electron());
		}
	      return helium;
	   }
	  
	  public Atom createLithium(){
		  Atom lithium = new Atom();
		  for (int i = 0; i < 3; i++) {
			  lithium.addItem(new Proton());
			  lithium.addItem(new Neutron()); 
			  lithium.addItem(new Electron());
		}
	      return lithium;
	   }
	  
	
}
