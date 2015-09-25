package com.xc.xnode.wishpool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xc.xnode.Message;
import com.xc.xnode.common.controller.BaseController;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.utils.JsonUtils;
import com.xc.xnode.utils.StringUtils;
import com.xc.xnode.wishpool.beans.SearchWishBean;
import com.xc.xnode.wishpool.beans.SearchWishDesireBean;
import com.xc.xnode.wishpool.beans.WishBeanList;
import com.xc.xnode.wishpool.service.WishPoolService;

@Controller
@RequestMapping("/wishpool")
public class WishPoolController extends BaseController{
	
	@Autowired
	private WishPoolService wishpoolService;
	
	@RequestMapping(value="/list" ,method = RequestMethod.GET)
	public String list(Model model){
		try {
			model.addAttribute("wishList", wishpoolService.getWishListByUser(null));
		} catch (BaseException e) {
			return ERROR_VIEW;
		}
		return "wishpool/list";
	}
	
	@RequestMapping(value="/mywish" ,method = RequestMethod.GET)
	public String mywish(Model model,SearchWishBean searchWishBean,HttpSession session){
		try {
			String tabView = (String) session.getAttribute("tabview");
			if(StringUtils.isEmpty(searchWishBean.getUsername())){
				searchWishBean.setUsername(getCurrentUser(session).getUsername());
			}
			model.addAttribute("wishBeanList", wishpoolService.getWishListByParams(searchWishBean));
			model.addAttribute("tabView",tabView);
			model.addAttribute("searchWishBean", searchWishBean);
		} catch (BaseException e) {
			return ERROR_VIEW;
		}
		return "wishpool/mywish";
	}
	
	@RequestMapping(value="/saveWishList" ,method = RequestMethod.POST)
	@ResponseBody
	public Message saveWishList(String wishList){
		try{
			WishBeanList wishBeanList = JsonUtils.toObject(wishList, WishBeanList.class);
			 wishpoolService.saveWishList(wishBeanList);
			 return SUCCESS_MESSAGE;
		}catch(Exception e){
			return ERROR_MESSAGE;
		}
	}
	
	@RequestMapping(value="/view" ,method = RequestMethod.GET)
	public String view(Model model,Integer id){
		try {
			model.addAttribute("wishPoolBean", wishpoolService.getWishById(id));
		} catch (BaseException e) {
			return ERROR_VIEW;
		}
		return "wishpool/view";
	}
	
	@RequestMapping(value="/edit" ,method = RequestMethod.GET)
	public String edit(Model model,Integer id){
		try {
			model.addAttribute("wishPoolBean", wishpoolService.getWishById(id));
		} catch (BaseException e) {
			return ERROR_VIEW;
		}
		return "wishpool/edit";
	}
	
	@RequestMapping(value="/updateView",method = RequestMethod.POST)
	@ResponseBody
	public void updateView(String view,HttpSession session){
		session.setAttribute("tabview", view);
	}
	
	@RequestMapping(value="/sendWish",method = RequestMethod.POST)
	@ResponseBody
	public Message sendWish(Model model,SearchWishDesireBean searchWishDesireBean){
		try{
			wishpoolService.saveWish(searchWishDesireBean);
			return SUCCESS_MESSAGE;
		}catch(BaseException e){
			return Message.error(e.getErrorCode());
		}
	}
	
	@RequestMapping(value="/wellWisher" ,method = RequestMethod.GET)
	public String wellWisher(Model model){
//		try {
//			model.addAttribute("wishList", wishpoolService.getWishListByUser(null));
//		} catch (BaseException e) {
//			return ERROR_VIEW;
//		}
		return "wishpool/well_wisher";
	}
}
