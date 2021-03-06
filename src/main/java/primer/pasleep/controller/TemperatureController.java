package primer.pasleep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primer.pasleep.entity.Temperature;
import primer.pasleep.service.TemperatureService;
import primer.pasleep.util.JsonResult;

import java.util.List;

/**
 * Created by primer on 17/10/20.
 */
@RestController
@RequestMapping("/temperature")
@CrossOrigin
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveTemperature(Temperature temperature) {
        try {
            temperatureService.save(temperature);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(temperature, "save Temperature succeed");
    }

    //@RequestMapping(value = "/list/patient/{patient_id}/start_time/{start_time}/end_time/{end_time}")
    //@ResponseBody
    //public JsonResult listByTime(@PathVariable Integer patient_id, @PathVariable Long start_time,
    //                             @PathVariable Long end_time) {
    //
    //}

    @RequestMapping(value = "/list/patient/{patient_id}/last_num/{last_num}")
    @ResponseBody
    public JsonResult listByLastNum(@PathVariable Integer patient_id, @PathVariable Integer last_num) {
        List<Temperature> temperatureList;
        try {
            temperatureList = temperatureService.listByLastNum(patient_id, last_num);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(temperatureList);
    }

    @RequestMapping(value = "/list/patient/{patient_id}/last_num/{last_num}/time_space/{time_space}")
    @ResponseBody
    public JsonResult listByTimeSpace(@PathVariable Integer patient_id, @PathVariable Integer last_num,
                                      @PathVariable Integer time_space) {
        List<Temperature> temperatureList;
        try {
            temperatureList = temperatureService.listByTimeSpace(patient_id, time_space, last_num);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(temperatureList);
    }
}
