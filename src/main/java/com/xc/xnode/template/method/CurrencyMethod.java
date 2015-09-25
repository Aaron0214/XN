/* * Project Name: xnode * File Name: CurrencyMethod.java * Class Name: CurrencyMethod * * Copyright 2014 xuce * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or * implied. * See the License for the specific language governing permissions and * limitations under the License. */package com.xc.xnode.template.method;import java.math.BigDecimal;import java.util.List;import com.xc.xnode.utils.SettingUtils;import com.xc.xnode.utils.StringUtils;import freemarker.template.SimpleScalar;import freemarker.template.TemplateBooleanModel;import freemarker.template.TemplateMethodModelEx;import freemarker.template.TemplateModelException;/** * 模板方法 - 货币格式化 *  * @author xuce * @version 2.0_beta */public class CurrencyMethod implements TemplateMethodModelEx {	/**	 * 货币格式化	 */	@SuppressWarnings("rawtypes")	@Override	public Object exec(List arguments) throws TemplateModelException {		if (arguments != null && !arguments.isEmpty() && arguments.get(0) != null && StringUtils.isNotEmpty(arguments.get(0).toString())) {			boolean showSign = false;			boolean showUnit = false;			if (arguments.size() == 2) {				if (arguments.get(1) != null) {					showSign = ((TemplateBooleanModel) arguments.get(1)).getAsBoolean();				}			} else if (arguments.size() > 2) {				if (arguments.get(1) != null) {					showSign = ((TemplateBooleanModel) arguments.get(1)).getAsBoolean();				}				if (arguments.get(2) != null) {					showUnit = ((TemplateBooleanModel) arguments.get(2)).getAsBoolean();				}			}			BigDecimal amount = new BigDecimal(arguments.get(0).toString());			String price = SettingUtils.makeScale(amount).toString();			if (showSign) {				price = SettingUtils.getCurrencySign() + price;			}			if (showUnit) {				price += SettingUtils.getCurrencyUnit();			}			return new SimpleScalar(price);		}		return null;	}}