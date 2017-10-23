package primer.pasleep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import primer.pasleep.entity.Alarm;
import primer.pasleep.service.AlarmService;
import primer.pasleep.util.JsonResult;

/**
 * Created by primer on 17/10/23.
 */
@RestController
@RequestMapping("/alarm")
@CrossOrigin
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveAlarm(Alarm alarm) {
        try {
            alarmService.save(alarm);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(alarm, "save alarm succeed.");
    }

    @RequestMapping(value = "/view/id/{alarm_id}")
    @ResponseBody
    public JsonResult getAlarmById(@PathVariable Integer alarm_id) {
        Alarm alarm;
        try {
            alarm = alarmService.getById(alarm_id);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(alarm);
    }

    @RequestMapping(value = "/list/patient/{patient_id}")
    @ResponseBody
    public JsonResult listByPatientId(@PathVariable Integer patient_id) {
        List<Alarm> alarmList;
        try {
            alarmList = alarmService.listByPatientId(patient_id);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(alarmList);
    }

    @RequestMapping(value = "/delete/id/{alarm_id}")
    @ResponseBody
    public JsonResult deleteAlarmById(@PathVariable Integer alarm_id) {
        try {
            int result = alarmService.deleteById(alarm_id);
            if (result == 0) {
                return JsonResult.buildFailResult("请输入正确参数");
            }
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult("delete alarm succeed");
    }

}
