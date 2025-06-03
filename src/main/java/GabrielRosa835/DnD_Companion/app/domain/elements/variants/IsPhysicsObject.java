package app.domain.elements.variants;

import app.domain.elements.components.*;
import app.domain.elements.options.characterOptions.*;

public interface IsPhysicsObject {
	MeasureComponent height();
	MeasureComponent weight();
	SizeCategory size();
}
