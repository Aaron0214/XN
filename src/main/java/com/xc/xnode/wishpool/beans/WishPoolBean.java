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
package com.xc.xnode.wishpool.beans;

import com.xc.xnode.common.beans.CommonBean;

/**
 * @author xuce
 *
 */
public class WishPoolBean extends CommonBean{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer index;
	
	private Integer id;
	
	private String code;

    private String css;

    private String wishText;

    private String username;

    private Integer template;
    
    private String createDate;
    
    private String modifyDate;
    
    private Long wishNum;
    
    private String comments;
     
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getWishText() {
		return wishText;
	}

	public void setWishText(String wishText) {
		this.wishText = wishText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getTemplate() {
		return template;
	}

	public void setTemplate(Integer template) {
		this.template = template;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getWishNum() {
		return wishNum;
	}

	public void setWishNum(Long wishNum) {
		this.wishNum = wishNum;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
