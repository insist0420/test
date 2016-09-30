package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

	//@Autowired
	//private LogicBean lb;


	@RequestMapping(value = "/1000S", method = RequestMethod.GET)
    public ModelAndView index0(ModelAndView mav) {
		mav.setViewName("1000S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1001S", method = RequestMethod.GET)
    public ModelAndView index1(ModelAndView mav) {
		mav.setViewName("1001S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1002S", method = RequestMethod.GET)
    public ModelAndView index2(ModelAndView mav) {
		mav.setViewName("1002S");
		System.out.println(mav);
        return mav;
    }


	@RequestMapping(value = "/1010S", method = RequestMethod.GET)
    public ModelAndView index3(ModelAndView mav) {
		mav.setViewName("1010S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1020S", method = RequestMethod.GET)
    public ModelAndView index4(ModelAndView mav) {
		mav.setViewName("1020S");
		System.out.println(mav);
        return mav;
    }




}


