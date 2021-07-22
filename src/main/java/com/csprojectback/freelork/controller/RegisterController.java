package com.csprojectback.freelork.controller;

import com.csprojectback.freelork.dto.RegisterDTO;
import com.csprojectback.freelork.exception.BusinessException;
import com.csprojectback.freelork.service.RegisterService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.csprojectback.freelork.constants.AuthConstants.URL_PRIVATE_AUTHENTICATION_BASE;

@RestController
@RequestMapping(URL_PRIVATE_AUTHENTICATION_BASE +"register/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS })
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("")
    public JSONObject createRegister(@RequestParam(name = "file" ,required = false)MultipartFile file, RegisterDTO registerDTO){
        JSONObject json = new JSONObject();
        try {
            registerService.createRegister(file,registerDTO);
            json.put("Status", "200");
            return json;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage(), HttpStatus.EXPECTATION_FAILED, "RegisterController");
        }

    }

}
