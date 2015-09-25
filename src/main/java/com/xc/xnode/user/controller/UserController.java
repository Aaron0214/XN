/*
 * Project Name: xnode
 * File Name: Page.java
 * Class Name: Page
 *
 * Copyright 2014 xuce
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xc.xnode.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xc.xnode.Message;
import com.xc.xnode.codedict.beans.CodeDictBean;
import com.xc.xnode.common.controller.BaseController;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.user.beans.PasswordBean;
import com.xc.xnode.user.beans.UserBean;
import com.xc.xnode.user.beans.UserSearchBean;
import com.xc.xnode.user.domain.User;
import com.xc.xnode.user.service.UserService;

/**
 * @author xuce
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model,UserSearchBean searchBean){
		try {
			model.addAttribute("userBeanList",userService.selectUserList(searchBean));
		} catch (BaseException e) {
			return ERROR_VIEW;
		}
		return "user/list";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(Model model,String username,HttpSession session){
		if(null == username){
			try {
				username = getCurrentUser(session).getUsername();
			} catch (BaseException e) {
				return ERROR_VIEW;
			}
		}
		model.addAttribute("userBean", userService.selectUserByUserName(username));
		model.addAttribute("list", userService.getSelectDistrict(username));
		return "user/edit";
	}
	
	@RequestMapping(value="/getDistrictList", method = RequestMethod.GET)
	@ResponseBody
	public List<CodeDictBean> getDistrictList(Model model,String code){
		return userService.getDistrictList(code);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Model model,UserBean userBean,RedirectAttributes redirectAttributes ){
		try{
			userService.update(userBean);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
			return "redirect:/user/view.jhtml";
		}catch(Exception e){
			addFlashMessage(redirectAttributes,ERROR_MESSAGE);
			return "redirect:/user/edit.jhtml";
		}
	}
	
	@RequestMapping(value="/changePassword", method = RequestMethod.GET)
	public String changePassword(Model model){
		return "user/changePassword";
	}
	
	@RequestMapping(value="/change", method = RequestMethod.POST)
	public String change(Model model,PasswordBean passwordBean,RedirectAttributes redirectAttributes ){
		try{
			userService.changePassword(passwordBean);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
			return "redirect:/user/changePassword.jhtml";
		}catch(BaseException e){
			addFlashMessage(redirectAttributes,Message.error(e.getErrorCode().toString()));
			return "redirect:/user/changePassword.jhtml";
		}
		
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String view(Model model,String username,HttpSession session){
		try {
			User user = getCurrentUser(session);
			if(null == username){
				username = user.getUsername();
			}
			model.addAttribute("currentUser",user.getUsername());
			model.addAttribute("userBean", userService.selectUserByUserName(username));
			return "user/view";
		} catch (BaseException e) {
			return ERROR_VIEW;
		}
	}
	
	@RequestMapping(value="/unlock", method = RequestMethod.GET)
	public String unlock(RedirectAttributes redirectAttributes,String id){
		userService.unlock(Integer.parseInt(id));
		addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
		return "redirect:/user/list.jhtml";
	}
}
