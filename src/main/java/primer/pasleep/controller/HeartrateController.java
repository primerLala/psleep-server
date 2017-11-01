package primer.pasleep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primer.pasleep.entity.HeartRate;
import primer.pasleep.service.HeartRateService;
import primer.pasleep.util.JsonResult;

import java.util.List;

/**
 * @Author Jiale Zheng
 * On 17/10/27.
 */
@RestController
@RequestMapping("/heartrate")
@CrossOrigin
public class HeartrateController {
    @Autowired
    private HeartRateService heartRateService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveHeartrate(HeartRate heartRate) {
        try {
            heartRateService.save(heartRate);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(heartRate, "save heartrate succeed.");
    }

    @RequestMapping(value = "/list/patient/{patient_id}/last_num/{last_num}")
    @ResponseBody
    public JsonResult listByLastNum(@PathVariable Integer patient_id, @PathVariable Integer last_num) {
        List<HeartRate> heartRateList;
        try {
            heartRateList = heartRateService.listByLastNum(patient_id, last_num);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(heartRateList);
    }

    @RequestMapping(value = "/list/patient/{patient_id}/last_num/{last_num}/time_space/{time_space}")
    @ResponseBody
    public JsonResult listByTimeSpace(@PathVariable Integer patient_id, @PathVariable Integer last_num,
                                      @PathVariable Integer time_space) {
        List<HeartRate> heartRateList;
        try {
            heartRateList = heartRateService.listByTimeSpace(patient_id, time_space, last_num);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(heartRateList);
    }
}
