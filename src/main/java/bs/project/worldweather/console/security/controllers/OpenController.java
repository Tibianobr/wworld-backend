package bs.project.worldweather.console.security.controllers;

import bs.project.worldweather.console.integration.service.impl.WeatherIntegrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/open")
public class OpenController {

    @Autowired
    private WeatherIntegrationServiceImpl weather;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
}
