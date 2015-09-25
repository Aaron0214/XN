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
package com.xc.xnode.wishpool.service;

import java.util.List;

import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.wishpool.beans.SearchWishBean;
import com.xc.xnode.wishpool.beans.SearchWishDesireBean;
import com.xc.xnode.wishpool.beans.WishBeanList;
import com.xc.xnode.wishpool.beans.WishPoolBean;

/**
 * @author xuce
 *
 */
public interface WishPoolService {
	
	public List<WishPoolBean> getWishListByUser(String username) throws BaseException; 
	
	public List<WishPoolBean> getWishListByParams(SearchWishBean searchWishBean) throws BaseException; 
	
	public void saveWishList(WishBeanList list);
	
	public WishPoolBean getWishById(Integer id) throws BaseException;
	
	public void saveWish(SearchWishDesireBean searchWishDesireBean) throws BaseException;

}
