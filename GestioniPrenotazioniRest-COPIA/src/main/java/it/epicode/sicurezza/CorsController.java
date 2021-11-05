package it.epicode.sicurezza;



	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin(origins = "localhost:8082", maxAge = 3600)
	@RestController
	@RequestMapping("/cors")
	public class CorsController {
	    
	    @GetMapping("/mycors")
	    public String myCors() {    
	        return "Hello CORS";
	    }
	}

