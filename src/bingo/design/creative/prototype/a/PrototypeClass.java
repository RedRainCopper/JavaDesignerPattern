package bingo.design.creative.prototype.a;

public class PrototypeClass implements Cloneable {
	
	@Override
	protected PrototypeClass clone() throws CloneNotSupportedException {
		PrototypeClass prototypeClass = null;
		prototypeClass = (PrototypeClass) super.clone();
		return prototypeClass;
	}
}
