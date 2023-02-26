package com.koctas.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.koctas.dto.Log;
import com.koctas.service.LogService;

@Controller
public class LogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

	@Autowired
	private LogService logService;
	
	
	@GetMapping("/getAllLogs")
	public String calculate(ModelMap model){
		
		List<Log> allLogs = null;
		try {
			allLogs = logService.getAllLogs();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		model.put("logs", allLogs);

		return "logList";
	}
	
	@RequestMapping(value="deleteLog")
	public String deleteTask(ModelMap model, @RequestParam String id) {
		try {
			logService.deleteLogById(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		 
		return "redirect:getAllLogs";
	}
	
}
