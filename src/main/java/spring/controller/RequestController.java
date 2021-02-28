package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.RequestService.Request_Service;
import spring.model.GlobalResponse;

@RestController
public class RequestController {

	@Autowired
	private Request_Service request_Service;

	/*---any request---*/
	@GetMapping("/")
	public ResponseEntity<GlobalResponse> setRequest() {
		GlobalResponse globalResponse;

		try {
			request_Service.setRequestCount();

			globalResponse = new GlobalResponse();
			globalResponse.setStatus(HttpStatus.OK.toString());
			globalResponse.setData("request counted");
			globalResponse.setStatus_code(HttpStatus.OK.value());
			globalResponse.setMessage("Request Executed Successfully!");
			return ResponseEntity.ok().body(globalResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			globalResponse = new GlobalResponse();
			globalResponse.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
			globalResponse.setStatus_code(HttpStatus.EXPECTATION_FAILED.value());
			globalResponse.setMessage("Got Exception as : " + e.getLocalizedMessage());
			return ResponseEntity.ok().body(globalResponse);
		}

	}

	/*---get request count---*/
	@GetMapping("/count")
	public ResponseEntity<GlobalResponse> getRequests() {
		GlobalResponse globalResponse;

		long counts;
		try {
			counts = request_Service.getRequestCount();

			globalResponse = new GlobalResponse();
			globalResponse.setStatus(HttpStatus.OK.toString());
			globalResponse.setData("no. of requests processed : " + counts);
			globalResponse.setStatus_code(HttpStatus.OK.value());
			globalResponse.setMessage("Request Executed Successfully!");
			return ResponseEntity.ok().body(globalResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			globalResponse = new GlobalResponse();
			globalResponse.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
			globalResponse.setStatus_code(HttpStatus.EXPECTATION_FAILED.value());
			globalResponse.setMessage("Got Exception as : " + e.getLocalizedMessage());
			return ResponseEntity.ok().body(globalResponse);
		}

	}

	@GetMapping("/resetcount")
	public ResponseEntity<GlobalResponse> resetcount() {
		GlobalResponse globalResponse;

		try {
			request_Service.resetcount();

			globalResponse = new GlobalResponse();
			globalResponse.setStatus(HttpStatus.OK.toString());
			globalResponse.setData("Count set to 0");
			globalResponse.setStatus_code(HttpStatus.OK.value());
			globalResponse.setMessage("Request Executed Successfully!");
			return ResponseEntity.ok().body(globalResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			globalResponse = new GlobalResponse();
			globalResponse.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
			globalResponse.setStatus_code(HttpStatus.EXPECTATION_FAILED.value());
			globalResponse.setMessage("Got Exception as : " + e.getLocalizedMessage());
			return ResponseEntity.ok().body(globalResponse);
		}

	}
}