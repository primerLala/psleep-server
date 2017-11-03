package primer.pasleep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import primer.pasleep.entity.CallRecord;
import primer.pasleep.service.CallRecordService;
import primer.pasleep.util.JsonResult;

/**
 * Created by primer on 17/11/3.
 */
@RestController
@RequestMapping("/record")
@CrossOrigin
public class CallRecordController {
    @Autowired
    CallRecordService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveRecord(CallRecord callRecord) {
        try {
            service.save(callRecord);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(callRecord, "save call record succeed.");
    }

    @RequestMapping(value = "/view/id/{record_id}")
    @ResponseBody
    public JsonResult getRecordById(@PathVariable Integer record_id) {
        CallRecord callRecord;
        try {
            callRecord = service.getById(record_id);
        } catch (Exception e) {
            return JsonResult.buildFailResult(e.getMessage());
        }
        return JsonResult.buildSuccessResult(callRecord);
    }
}
