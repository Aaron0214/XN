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
package com.xc.xnode.friend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xc.xnode.Message;
import com.xc.xnode.common.controller.BaseController;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.friend.beans.SearchFriendBean;
import com.xc.xnode.friend.service.FriendService;
import com.xc.xnode.user.domain.User;

/**
 * @author xuce
 *
 */
@Controller
@RequestMapping("/friend")
public class FriendController extends BaseController{
	
	@Autowired
	private FriendService friendService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list(Model model,HttpSession session,SearchFriendBean searchBean){
		try{
			User loginUser = getCurrentUser(session);
			searchBean.setUsername(loginUser.getUsername());
			model.addAttribute("friendBeanlist", friendService.getMyfriendList(searchBean));
			return "friend/list";
		}catch(BaseException e){
			return ERROR_VIEW;
		}
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(Model model,HttpSession session,String searchUserName){
		try{
			User loginUser = getCurrentUser(session);
			model.addAttribute("nonFriendList", friendService.getNonMyfriendList(loginUser.getUsername(), searchUserName));
			model.addAttribute("username", searchUserName);
			return "friend/add";
		}catch(BaseException e){
			return ERROR_VIEW;
		}
	}
	
	@RequestMapping(value="/getMessage",method = RequestMethod.GET)
	public String getMessage(Model model,String username,RedirectAttributes redirectAttributes,HttpSession session){
		try{
			User loginUser = getCurrentUser(session);
			model.addAttribute("messageList", friendService.getMessages(loginUser.getUsername(), username));
			model.addAttribute("username",username);
			return "friend/friend_required";
		}catch(BaseException e){
			return ERROR_VIEW;
		}
	}

	@RequestMapping(value="/addFriend",method = RequestMethod.GET)
	public String addFriend(String username,RedirectAttributes redirectAttributes,HttpSession session){
		try{
			User loginUser = getCurrentUser(session);
			friendService.addFriend(loginUser.getId(),username);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
		}catch(BaseException e){
			addFlashMessage(redirectAttributes,Message.error(e.getErrorCode()));
		}
		return "redirect:/friend/add.jhtml";
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String delete(String username,RedirectAttributes redirectAttributes,HttpSession session){
		try{
			User loginUser = getCurrentUser(session);
			friendService.deleteFriend(loginUser.getId(),username);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
		}catch(BaseException e){
			addFlashMessage(redirectAttributes,Message.error(e.getErrorCode()));
		}
		return "redirect:/friend/list.jhtml";
	}
	
	@RequestMapping(value="/agree",method = RequestMethod.GET)
	public String agree(Integer id,RedirectAttributes redirectAttributes,HttpSession session){
		try{
			User loginUser = getCurrentUser(session);
			friendService.agree(loginUser.getId(), id);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
		}catch(BaseException e){
			addFlashMessage(redirectAttributes,Message.error(e.getErrorCode()));
		}
		return "redirect:/friend/list.jhtml";
	}
	
	@RequestMapping(value="/disagree",method = RequestMethod.GET)
	public String disagree(Integer id,RedirectAttributes redirectAttributes,HttpSession session){
		try{
			User loginUser = getCurrentUser(session);
			friendService.disagree(loginUser.getId(), id);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
		}catch(BaseException e){
			addFlashMessage(redirectAttributes,Message.error(e.getErrorCode()));
		}
		return "redirect:/friend/list.jhtml";
	}
}
