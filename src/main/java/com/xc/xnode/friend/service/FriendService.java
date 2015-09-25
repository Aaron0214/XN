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
package com.xc.xnode.friend.service;

import java.util.List;

import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.friend.beans.FriendAddBean;
import com.xc.xnode.friend.beans.FriendBean;
import com.xc.xnode.friend.beans.MessageBean;
import com.xc.xnode.friend.beans.SearchFriendBean;

/**
 * @author xuce
 *
 */
public interface FriendService {
	
	public List<FriendBean> getMyfriendList(SearchFriendBean searchBean);
	
	public List<FriendAddBean> getNonMyfriendList(String loginUser, String username);
	
	public void addFriend(Integer loginUser, String username) throws BaseException;
	
	public void deleteFriend(Integer loginUser, String username) throws BaseException;
	
	public List<MessageBean> getMessages(String loginUser, String username) throws BaseException;
	
	public void agree(Integer loginUser, Integer messageId) throws BaseException;
	
	public void disagree(Integer loginUser, Integer messageId) throws BaseException;

}
