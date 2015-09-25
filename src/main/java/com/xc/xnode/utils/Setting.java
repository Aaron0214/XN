/*
 * Project Name: xnode
 * File Name: Setting.java
 * Class Name: Setting
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
package com.xc.xnode.utils;

import java.math.BigDecimal;

/**
 * 系统设置
 * 
 * @author xuce
 * @version 2.0_beta
 */
public class Setting {

	/**
	 * 价格精确方式
	 **/
	private int		priceRoundType	= BigDecimal.ROUND_HALF_UP;

	/**
	 * 价格精确位数
	 **/
	private Integer	priceScale		= 2;

	/**
	 * 货币符号
	 **/
	private String	currencySign	= "￥";

	/**
	 * 货币单位
	 **/
	private String	currencyUnit;

	/**
	 * @return the priceRoundType
	 */
	public int getPriceRoundType() {
		return priceRoundType;
	}

	/**
	 * @param priceRoundType
	 *            the priceRoundType to set
	 */
	public void setPriceRoundType(int priceRoundType) {
		this.priceRoundType = priceRoundType;
	}

	/**
	 * @return the priceScale
	 */
	public Integer getPriceScale() {
		return priceScale;
	}

	/**
	 * @param priceScale
	 *            the priceScale to set
	 */
	public void setPriceScale(Integer priceScale) {
		this.priceScale = priceScale;
	}

	/**
	 * @return the currencySign
	 */
	public String getCurrencySign() {
		return currencySign;
	}

	/**
	 * @param currencySign
	 *            the currencySign to set
	 */
	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}

	/**
	 * @return the currencyUnit
	 */
	public String getCurrencyUnit() {
		return currencyUnit;
	}

	/**
	 * @param currencyUnit
	 *            the currencyUnit to set
	 */
	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

}
