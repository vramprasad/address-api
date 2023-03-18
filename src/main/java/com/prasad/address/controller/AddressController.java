package com.prasad.address.controller;

import com.prasad.address.model.Address;
import com.prasad.address.service.AddressService;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RequestMapping("/api/v1/address-api")
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value="/healthcheck",method = RequestMethod.GET, produces={MediaType.TEXT_PLAIN_VALUE})
    @ResponseBody
    public ResponseEntity<String> healthcheck() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String responseText = "address-api Healthcheck @ "+ timeStamp+" - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @PostMapping
    public Optional<Address> getAddress(@RequestBody String inputRequest) {
        JSONTokener jsonTokener = new JSONTokener(inputRequest);
        JSONObject requestJSON = new JSONObject(jsonTokener);
        JSONObject responseJSON = new JSONObject();

        int clientIDinput = requestJSON.getInt("clientID");
        Optional<Address> resultAddress = addressService.getAddressById(clientIDinput);
        return resultAddress;
    }
}
