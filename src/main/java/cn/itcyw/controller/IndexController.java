/**  
 * @Description: 
 * @author tcy
 * @date 2020-02-02 
 */  
package cn.itcyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**  
 * @Description: 
 * @author tcy
 * @date 2020-02-02 
*/
@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
