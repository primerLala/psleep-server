package primer.pasleep.util;

/**
 * Created by primer on 17/3/1.
 */
public class JsonResult {
    private int statusCode;
    private String message;
    private Object data;

    public JsonResult() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult buildSuccessResult(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(200);
        jsonResult.setData(data);
        jsonResult.setMessage("success");
        return jsonResult;
    }

    public static JsonResult buildSuccessResult(String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(200);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public static JsonResult buildSuccessResult(Object data, String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(200);
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public static JsonResult buildSuccessResult() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatusCode(200);
        jsonResult.setMessage("success");
        return jsonResult;
    }

    public static JsonResult buildFailResult(String message) {
        return buildFailResult(message, 500);
    }

    public static JsonResult buildFailResult(String message, int statusCode) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(null);
        jsonResult.setMessage(message);
        jsonResult.setStatusCode(statusCode);
        return jsonResult;
    }
}
