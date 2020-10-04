package atomCreator;

public abstract class Nucleon implements AtomPart{

	@Override
	public Fusion fusion() {
		return new AtomicCore();
	}
}
