package app.experimental;

import io.vavr.control.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.sql.*;

@Component
public class Canva implements Runnable {

	@Autowired
	private Connection connection;

	private UnitType type = new UnitType(null, "Length");
	private Unit unit = new Unit(null, "Meters", "m", "Meter", 1, type);

	@Override
	public void run() {
		System.out.println(Try.of(() -> connection.createStatement()));
	}
}
