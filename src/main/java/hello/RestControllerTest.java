package hello;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.form.ButtonParamBean;
import hello.form.FormBean;
import hello.logic.ButtonParamBussinessLogic;
import hello.logic.DateTimeSetting;
import hello.logic.FormCheckBusinessLogic;

@RestController
public class RestControllerTest {

	@Autowired
	private DateTimeSetting dts;

	@Autowired
	private FormCheckBusinessLogic fcbl;

	@Autowired
	private ButtonParamBussinessLogic bpbl;


	//メッセージ取得処理
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String formCheck(@RequestBody String json) {
		String rtnJson = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			FormBean obj = mapper.readValue(json, FormBean.class);

			//送信されたリスト(strList)を渡して、クライアントに返すリスト(rtnList)を受け取る
			List<List<String>> rList =  fcbl.checkPattern(obj.getStrList(),8,10);

			//FormBeanのオブジェクトに値をセット
			obj.setRtnList(rList);

			rtnJson = mapper.writeValueAsString(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
        return rtnJson;
    }

	//時刻取得処理
	@RequestMapping(value = "/getTime", method = RequestMethod.GET)
	public String dateTime() {
		String time = dts.rtnDate();
        return time;
    }

	/**
	 * ボタン情報取得処理に投げる
	 * @param json
	 * @return rtnJson
	 */
	@RequestMapping(value = "/getButtonParam", method = RequestMethod.POST)
	public String buttonParam(@RequestBody String json) {
		String rtnJson = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			ButtonParamBean obj = mapper.readValue(json, ButtonParamBean.class);
			List<List<String[]>> rList = bpbl.getButtonParam(obj.getAuthority());
			obj.setBtnList(rList);

			rtnJson = mapper.writeValueAsString(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
        return rtnJson;
    }


}

