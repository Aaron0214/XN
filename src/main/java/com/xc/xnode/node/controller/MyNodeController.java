package com.xc.xnode.node.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xc.xnode.Message;
import com.xc.xnode.common.beans.SearchBean;
import com.xc.xnode.common.controller.BaseController;
import com.xc.xnode.node.beans.NodeBean;
import com.xc.xnode.node.service.MyNodeService;

@Controller
@RequestMapping("/xnode")
public class MyNodeController extends BaseController{
	
	@Autowired
	private MyNodeService myNodeService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(Model model,SearchBean searchBean){
		model.addAttribute("nodeListBean", myNodeService.getNodeList(searchBean));
		return "xnode/list";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add(Model model){
		return "xnode/add";
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String save(NodeBean nodeBean,String username,Model model,RedirectAttributes redirectAttributes){
		try{
			myNodeService.saveNode(nodeBean,username);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
			return "redirect:/xnode/list.jhtml";
		}catch(Exception e){
			addFlashMessage(redirectAttributes,Message.error("新增失败"));
			return "redirect:/xnode/add.jhtml";
		}
	}
	
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public String edit(Model model,Integer id){
		model.addAttribute("nodeBean", myNodeService.selectNodeById(id));
		return "xnode/edit";
	}
	
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public String view(Model model,Integer id){
		model.addAttribute("nodeBean", myNodeService.selectNodeById(id));
		return "xnode/view";
	}

}
	