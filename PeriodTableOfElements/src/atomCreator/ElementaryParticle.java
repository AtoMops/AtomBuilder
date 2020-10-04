package atomCreator;

public abstract class ElementaryParticle implements AtomPart{

	@Override
	public Fusion fusion() {
		return new ElectronShell();
	}

}
