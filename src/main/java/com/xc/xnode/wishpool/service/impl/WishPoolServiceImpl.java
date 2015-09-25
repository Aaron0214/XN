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
package com.xc.xnode.wishpool.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.user.dao.UserMapper;
import com.xc.xnode.user.domain.User;
import com.xc.xnode.utils.CollectionUtils;
import com.xc.xnode.utils.DateUtils;
import com.xc.xnode.utils.NumberFormatUtils;
import com.xc.xnode.utils.StringUtils;
import com.xc.xnode.wishpool.beans.SearchWishBean;
import com.xc.xnode.wishpool.beans.SearchWishDesireBean;
import com.xc.xnode.wishpool.beans.WishBean;
import com.xc.xnode.wishpool.beans.WishBeanList;
import com.xc.xnode.wishpool.beans.WishPoolBean;
import com.xc.xnode.wishpool.dao.WishPoolMapper;
import com.xc.xnode.wishpool.dao.WisherDesireMapper;
import com.xc.xnode.wishpool.domain.SearchParams;
import com.xc.xnode.wishpool.domain.WishPool;
import com.xc.xnode.wishpool.domain.WishPoolUser;
import com.xc.xnode.wishpool.domain.WisherDesire;
import com.xc.xnode.wishpool.service.WishPoolService;

/**
 * @author xuce
 *
 */
@Service
public class WishPoolServiceImpl implements WishPoolService{
	
	@Autowired
	private WishPoolMapper wishPoolMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WisherDesireMapper wisherDesireMapper;
	
	private static Logger log = LoggerFactory.getLogger(WishPoolServiceImpl.class);


	@Override
	public List<WishPoolBean> getWishListByUser(String username) throws BaseException {
		List<WishPoolBean> wishBeanList = new ArrayList<WishPoolBean>();
		List<WishPoolUser> wishList = wishPoolMapper.getWishListByUser(username);
		if(CollectionUtils.isNotEmpty(wishList)){
			Integer index = 1;
			for(WishPoolUser wishPool : wishList){
				WishPoolBean wishPoolBean = bulidWishPoolBean(wishPool);
				wishPoolBean.setIndex(index++);
				wishBeanList.add(wishPoolBean);
			}
		}
		return wishBeanList;
	}
	
	@Override
	public List<WishPoolBean> getWishListByParams(SearchWishBean searchWishBean) throws BaseException {
		List<WishPoolBean> wishBeanList = new ArrayList<WishPoolBean>();
		List<WishPoolUser> wishList = wishPoolMapper.getWishListByParams(prepareSearchParams(searchWishBean));
		if(CollectionUtils.isNotEmpty(wishList)){
			Integer index = 1;
			for(WishPoolUser wishPool : wishList){
				WishPoolBean wishPoolBean = bulidWishPoolBean(wishPool);
				wishPoolBean.setIndex(index++);
				wishBeanList.add(wishPoolBean);
			}
		}
		return wishBeanList;
	}
	
	@Override
	public void saveWishList(WishBeanList list) {
		if(null != list){
			if(CollectionUtils.isNotEmpty(list.getList())){
				for(WishBean wishBean : list.getList()){
					WishPool wishPool = wishPoolMapper.selectByPrimaryKey(wishBean.getId() == null ? null : Integer.parseInt(wishBean.getId()));
					if(null != wishPool){
						wishPool.setCss(wishBean.getCss());
						wishPool.setWishText(wishBean.getWishText());
						wishPool.setModifyDate(new Date());
						wishPoolMapper.updateByPrimaryKeySelective(wishPool);
					}else{
						wishPool = bulidWishPool(wishBean);
						wishPoolMapper.insertSelective(wishPool);
					}
				}
			}
		}
	}
	
	@Override
	public WishPoolBean getWishById(Integer id) throws BaseException {
		return bulidWishPoolBean(wishPoolMapper.selectByPrimaryKey(id));
	}
	
	private WishPoolBean bulidWishPoolBean(WishPoolUser wishPool) throws BaseException{
		WishPoolBean wishPoolBean = new WishPoolBean();
		wishPoolBean.setId(wishPool.getId());
		wishPoolBean.setCss(wishPool.getCss());
		wishPoolBean.setTemplate(wishPool.getTemplate());
		wishPoolBean.setWishText(wishPool.getWishText());
		wishPoolBean.setUsername(wishPool.getUsername());
		wishPoolBean.setWishNum(wishPool.getWishNum());
		wishPoolBean.setComments(wishPool.getComments());
		try {
			String code = "XNW" + DateUtils.parseDates(wishPool.getCreateDate()) 
									+ NumberFormatUtils.formatNumber(wishPool.getId());
			wishPoolBean.setCode(code);
			wishPoolBean.setCreateDate(DateUtils.parseDate(wishPool.getCreateDate()));
			wishPoolBean.setModifyDate(DateUtils.parseDate(wishPool.getModifyDate()));
		} catch (ParseException e) {
			log.info(e.getMessage());
			throw new BaseException("common.parse.error");
		}
		return wishPoolBean;
	}
	
	private WishPoolBean bulidWishPoolBean(WishPool wishPool) throws BaseException{
		WishPoolBean wishPoolBean = new WishPoolBean();
		wishPoolBean.setId(wishPool.getId());
		wishPoolBean.setCss(wishPool.getCss());
		wishPoolBean.setTemplate(wishPool.getTemplate());
		wishPoolBean.setWishText(wishPool.getWishText());
		wishPoolBean.setWishNum(wishPool.getWishNum());
		wishPoolBean.setComments(wishPool.getComments());
		try {
			wishPoolBean.setCreateDate(DateUtils.parseLongDate(wishPool.getCreateDate()));
			wishPoolBean.setModifyDate(DateUtils.parseLongDate(wishPool.getModifyDate()));
		} catch (ParseException e) {
			log.info(e.getMessage());
			throw new BaseException("common.parse.error");
		}
		return wishPoolBean;
	}
	
	private WishPool bulidWishPool(WishBean wishBean){
		WishPool wishPool = new WishPool();
		wishPool.setCss(wishBean.getCss());
		wishPool.setTemplate(Integer.parseInt(wishBean.getTemplate()));
		wishPool.setWishText(wishBean.getWishText());
		wishPool.setCreateDate(new Date());
		wishPool.setModifyDate(new Date());
		wishPool.setUserId(userMapper.selectUserByUserName(wishBean.getUsername()).getId());
		return wishPool;
	}
	
	private SearchParams prepareSearchParams(SearchWishBean searchWishBean){
		SearchParams searchParams = new SearchParams();
		if(null == searchWishBean){
			return searchParams;
		}
		if(StringUtils.isNotEmpty(searchWishBean.getCode())){
			int length = searchWishBean.getCode().length();
			Integer id = NumberFormatUtils.returnNumber(searchWishBean.getCode().substring(length - 6, length));
			searchParams.setId(id);
		}
		if(StringUtils.isNotEmpty(searchWishBean.getUsername())){
			searchParams.setUsername(searchWishBean.getUsername());
		}
		if(StringUtils.isNotEmpty(searchWishBean.getWishtext())){
			searchParams.setWishtext(searchWishBean.getWishtext());
		}
		if(StringUtils.isNotEmpty(searchWishBean.getStartDate())){
			searchParams.setStartDate(DateUtils.dateBegin(DateUtils.parseDate(searchWishBean.getStartDate())));
		}
		if(StringUtils.isNotEmpty(searchWishBean.getEndDate())){
			searchParams.setEndDate(DateUtils.dateEnd(DateUtils.parseDate(searchWishBean.getEndDate())));
		}
		return searchParams;
	}

	@Override
	public void saveWish(SearchWishDesireBean searchWishDesireBean) throws BaseException {
		if(null == searchWishDesireBean.getWishId() || StringUtils.isEmpty(searchWishDesireBean.getUsername())){
			throw new BaseException("common.wish.error");
		}
		
		WishPool wishPool = wishPoolMapper.selectByPrimaryKey(searchWishDesireBean.getWishId());
		if(null == wishPool){
			throw new BaseException("common.wish.find.error");
		}
		
		Map<String,Object> params = prepareSearchParams(searchWishDesireBean);
		WisherDesire wisherDesire =  wisherDesireMapper.selectByParams(params);
		if(null != wisherDesire){
			throw new BaseException("wishpool.already.send");
		}
		
		try{
			wisherDesire = new WisherDesire();
			wisherDesire.setWisherId((Integer) params.get("wisherId"));
			wisherDesire.setWishId(searchWishDesireBean.getWishId());
			wisherDesire.setCreateDate(new Date());
			wisherDesireMapper.insertSelective(wisherDesire);
			
			wishPool.setWishNum(wishPool.getWishNum() + 1);
			wishPoolMapper.updateByPrimaryKeySelective(wishPool);
		}catch(Exception e){
			throw new BaseException("common.wish.add.error");
		}
	}
	
	private Map<String,Object> prepareSearchParams(SearchWishDesireBean searchWishDesireBean) throws BaseException{
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("wishId", searchWishDesireBean.getWishId());
		
		User user = userMapper.selectUserByUserName(searchWishDesireBean.getUsername());
		if(null == user){
			throw new BaseException("common.user.find.error");
		}
		params.put("wisherId", user.getId());
		
		if(StringUtils.isNotEmpty(searchWishDesireBean.getStartDate())){
			params.put("startDate", DateUtils.dateBegin(DateUtils.parseDate(searchWishDesireBean.getStartDate())));
		}else{
			params.put("startDate", DateUtils.todayBegin());
		}
		
		if(StringUtils.isNotEmpty(searchWishDesireBean.getEndDate())){
			params.put("endDate", DateUtils.dateBegin(DateUtils.parseDate(searchWishDesireBean.getEndDate())));
		}else{
			params.put("endDate", DateUtils.todayEnd());
		}
		return params;
	}
}
