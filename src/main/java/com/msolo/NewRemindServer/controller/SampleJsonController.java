package com.msolo.NewRemindServer.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msolo.NewRemindServer.domain.Remind;
import com.msolo.NewRemindServer.repos.RemindRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class SampleJsonController {

    @Autowired
    private RemindRepo remindRepo;
    String strJson;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getReminder() {
        try {
            Iterable<Remind> reminders = remindRepo.findAll();
            strJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reminders);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{\"reminder\":"+strJson+"}";
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public void setReminder(@RequestBody String remindJsonSender) {
        try {
            Remind  setRemind = mapper.readValue(remindJsonSender, Remind.class);
            remindRepo.save(setRemind);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
