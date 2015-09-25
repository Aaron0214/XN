package com.xc.xnode.friend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.friend.beans.FriendAddBean;
import com.xc.xnode.friend.beans.FriendBean;
import com.xc.xnode.friend.beans.MessageBean;
import com.xc.xnode.friend.beans.SearchFriendBean;
import com.xc.xnode.friend.dao.FriendMapper;
import com.xc.xnode.friend.dao.MessagesMapper;
import com.xc.xnode.friend.domain.Friend;
import com.xc.xnode.friend.domain.FriendEntity;
import com.xc.xnode.friend.domain.FriendMessage;
import com.xc.xnode.friend.domain.Messages;
import com.xc.xnode.friend.enums.MessageStatusEnum;
import com.xc.xnode.friend.enums.MessageTypeEnum;
import com.xc.xnode.friend.service.FriendService;
import com.xc.xnode.user.dao.UserMapper;
import com.xc.xnode.user.domain.User;
import com.xc.xnode.user.enums.UserSexEnum;
import com.xc.xnode.utils.CollectionUtils;
import com.xc.xnode.utils.DateUtils;

@Service
public class FriendServiceImpl implements FriendService{
	
	@Autowired
	private FriendMapper friendMapper;
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MessagesMapper messagesMapper;
	
	private static Logger log = LoggerFactory.getLogger(FriendServiceImpl.class);

	@Override
	public List<FriendBean> getMyfriendList(SearchFriendBean searchBean) {
		List<FriendBean> friendBeanList = new ArrayList<FriendBean>();
		List<FriendEntity> friendList = friendMapper.selectFriendList(prepareParams(searchBean));
		if(CollectionUtils.isNotEmpty(friendList)){
			Integer index = 1;
			for(FriendEntity friend:friendList){
				if(null != friend){
					FriendBean friendBean = buildFriendBean(friend);
					friendBean.setIndex(index++);
					friendBeanList.add(friendBean);
				}
			}
		}
		return friendBeanList;
	}
	
	@Override
	public List<FriendAddBean> getNonMyfriendList(String loginUser, String username) {
		List<FriendAddBean> friendBeanList = new ArrayList<FriendAddBean>();
		List<String> userList = friendMapper.selectUnFriendList(prepareParams(loginUser,username));
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("senderName", loginUser);
		params.put("startDate", DateUtils.todayBegin());
		params.put("endDate", DateUtils.todayEnd());
		if(CollectionUtils.isNotEmpty(userList)){
			for(String user:userList){
				FriendAddBean friendAddBean = new FriendAddBean();
				friendAddBean.setLevel(1);
				friendAddBean.setUsername(user);
				params.put("receiverName", user);
				List<Messages> messageList = messagesMapper.selectMessagesByParams(params);
				if(CollectionUtils.isEmpty(messageList)){
					friendAddBean.setIsSendMessage("N");
				}else{
					friendAddBean.setIsSendMessage("Y");
				}
				friendBeanList.add(friendAddBean);
			}
		}
		return friendBeanList;
	}

	private Map<String,Object> prepareParams(SearchFriendBean searchBean){
		Map<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(searchBean.getUsername())){
			params.put("username", searchBean.getUsername());
		}
		return params;
	}
	
	private FriendBean buildFriendBean(FriendEntity friend){
		FriendBean friendBean = new FriendBean();
		friendBean.setCode(friend.getCode());
		friendBean.setFriendNum(friend.getFrinedNum() == null ? 0 : friend.getFrinedNum());
		friendBean.setName(friend.getName());
		friendBean.setNodeNum(friend.getNodeNum() == null ? 0 : friend.getNodeNum());
		friendBean.setSex(friend.getSex());
		friendBean.setSexValue(UserSexEnum.getValueByKey(friend.getSex()));
		friendBean.setUsername(friend.getUsername());
		friendBean.setWishNum(friend.getWishNum() == null ? 0 : friend.getWishNum());
		return friendBean;
	}
	
	private Map<String,String> prepareParams(String loginUser, String username){
		Map<String,String> params = new HashMap<String,String>();
		if(StringUtils.isNotEmpty(loginUser)){
			params.put("loginname", loginUser);
		}
		if(StringUtils.isNotEmpty(username)){
			params.put("username", username);
		}
		return params;
	}
	
	private Map<String,Object> prepareParams(Integer loginUser, Integer userId){
		Map<String,Object> params = new HashMap<String,Object>();
		if(null != loginUser){
			params.put("loginUser", loginUser);
		}
		if(null != userId){
			params.put("userId", userId);
		}
		return params;
	}

	@Override
	public void addFriend(Integer loginUser, String username) throws BaseException {
		User user = null;
		if(StringUtils.isNotEmpty(username)){
			user = userMapper.selectUserByUserName(username);
		}
		if(null == user){
			throw new BaseException("friend.user.find.error");
		}
		try{
			List<Messages> messagesList = messagesMapper.selectMessagesByParams(prepareParams(loginUser,user.getId()));
			if(CollectionUtils.isEmpty(messagesList)){
				Messages messages = new Messages();
				messages.setMessage("请求添加您为好友");
				messages.setReceiver(user.getId());
				messages.setSender(loginUser);
				messages.setStatus(MessageStatusEnum.SENDING.getStatus());
				messages.setType(MessageTypeEnum.ADD_FRIEND.getKey());
				messages.setCreateDate(new Date());
				messages.setModifyDate(new Date());
				messagesMapper.insertSelective(messages);
			}else{
				Messages messages = messagesList.get(0);
				messages.setModifyDate(new Date());
				messagesMapper.updateByPrimaryKeySelective(messages);
			}
		}catch(Exception e){
			throw new BaseException("common.insert.error");
		}
	}

	@Override
	public void deleteFriend(Integer loginUser, String username)
			throws BaseException {
		User user = null;
		if(StringUtils.isNotEmpty(username)){
			user = userMapper.selectUserByUserName(username);
		}
		if(null == user){
			throw new BaseException("friend.user.find.error");
		}
		try{
			Map<String,Integer> params = new HashMap<String,Integer>();
			params.put("loginUser", loginUser);
			params.put("userId", user.getId());
			friendMapper.deleteFriengByParams(params);
		}catch(Exception e){
			throw new BaseException("common.delete.error");
		}
	}

	@Override
	public List<MessageBean> getMessages(String loginUser, String username)throws BaseException {
		List<MessageBean> MessageBeanList = new ArrayList<MessageBean>();
		try{
			if(StringUtils.isEmpty(username)){
				username = null;
			}
			List<FriendMessage> messageList = messagesMapper.selectMessagesByReceiver(loginUser, username);
			if(CollectionUtils.isNotEmpty(messageList)){
				for(FriendMessage friendMessage : messageList){
					MessageBeanList.add(buildMessageBean(friendMessage));
				}
			}
		}catch(Exception e){
			log.error(e.getMessage(),e.getCause());
		}
		return MessageBeanList;
	}
	
	private MessageBean buildMessageBean(FriendMessage friendMessage){
		MessageBean messageBean = new MessageBean();
		messageBean.setId(friendMessage.getId());
		messageBean.setMessage(friendMessage.getMessage());
		messageBean.setSenderName(friendMessage.getSenderName());
		return messageBean;
	}

	@Override
	public void agree(Integer loginUser, Integer messageId) throws BaseException {
		Messages messages = null;
		if(null != messageId){
			messages = messagesMapper.selectByPrimaryKey(messageId);
		}
		if(null == messages){
			throw new BaseException("friend.message.notfound");
		}
		try{
			Friend friend = new Friend();
			friend.setFrienfId(messages.getSender());
			friend.setUserId(loginUser);
			friendMapper.insertSelective(friend);
			
			//更新message表数据
			messages.setStatus(MessageStatusEnum.COMFIRE.getStatus());
			messages.setModifyDate(new Date());
			messagesMapper.updateByPrimaryKeySelective(messages);
		}catch(Exception e){
			throw new BaseException("common.insert.error");
		}
	}

	@Override
	public void disagree(Integer loginUser, Integer messageId) throws BaseException {
		Messages messages = null;
		if(null != messageId){
			messages = messagesMapper.selectByPrimaryKey(messageId);
		}
		if(null == messages){
			throw new BaseException("friend.message.notfound");
		}
		try{
			//更新message表数据
			messages.setStatus(MessageStatusEnum.REJECT.getStatus());
			messages.setModifyDate(new Date());
			messagesMapper.updateByPrimaryKeySelective(messages);
		}catch(Exception e){
			throw new BaseException("common.insert.error");
		}
	}
}
