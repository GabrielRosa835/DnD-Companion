package dnd_companion.java_api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("armors")
public class ArmorController {
	
	@PostMapping
	public void cadastrar(@RequestBody ArmorRegistryData data) {
		System.out.println(data);
	}
}
