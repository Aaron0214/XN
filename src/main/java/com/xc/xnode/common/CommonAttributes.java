/* * Project Name: xnode * File Name: CommonAttributes.java * Class Name: CommonAttributes * * Copyright 2014 xuce * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or * implied. * See the License for the specific language governing permissions and * limitations under the License. */package com.xc.xnode.common;/** * 公共参数 *  * @author xuce * @version 1.0_beta */public final class CommonAttributes {	/** 日期格式配比 */	public static final String[]	DATE_PATTERNS	= new String[] { //															"yyyy", //															"yyyy-MM", //															"yyyyMM", //															"yyyy/MM", //															"yyyy-MM-dd", //															"yyyyMMdd",	//															"yyyy/MM/dd", //															"yyyy-MM-dd HH:mm:ss", //															"yyyyMMddHHmmss", //															"yyyy/MM/dd HH:mm:ss" //														};	/**	 * 不可实例化	 */	private CommonAttributes() {	}}