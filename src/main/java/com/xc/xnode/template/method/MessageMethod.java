/* * Project Name: xnode * File Name: MessageMethod.java * Class Name: MessageMethod * * Copyright 2014 xuce * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or * implied. * See the License for the specific language governing permissions and * limitations under the License. */package com.xc.xnode.template.method;import java.util.List;import com.xc.xnode.utils.SpringUtils;import com.xc.xnode.utils.StringUtils;import freemarker.template.SimpleScalar;import freemarker.template.TemplateMethodModelEx;import freemarker.template.TemplateModelException;/** * 模板方法 - 多语言 *  * @author xuce * @version 1.0_beta */// @Component("messageMethod")public class MessageMethod implements TemplateMethodModelEx {	@SuppressWarnings("rawtypes")	public Object exec(List arguments) throws TemplateModelException {		if (arguments != null && !arguments.isEmpty() && arguments.get(0) != null && StringUtils.isNotEmpty(arguments.get(0).toString())) {			String message = null;			String code = arguments.get(0).toString();			if (arguments.size() > 1) {				Object[] args = arguments.subList(1, arguments.size()).toArray();				message = SpringUtils.getMessage(code, args);			} else {				message = SpringUtils.getMessage(code);			}			return new SimpleScalar(message);		}		return null;	}}