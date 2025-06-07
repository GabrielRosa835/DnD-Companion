package app.domain.elements.variants;

import app.domain.elements.entities.options.characterOptions.*;
import app.experimental.*;

public interface IsPhysicsObject {
	MeasureComponent height();
	MeasureComponent weight();
	SizeCategory size();
}
