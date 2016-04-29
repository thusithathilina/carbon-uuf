/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.uuf.handlebars.helpers.runtime;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.google.common.collect.ImmutableSet;
import org.wso2.carbon.uuf.core.exception.UUFException;
import org.wso2.carbon.uuf.handlebars.helpers.init.LayoutHelper;

import java.io.IOException;

public class MissingHelper implements Helper {

    private static final ImmutableSet<String> KEYWORDS = ImmutableSet.of(LayoutHelper.HELPER_NAME,
                                                                         FillZoneHelper.HELPER_NAME);

    @Override
    public CharSequence apply(Object arg, Options options) throws IOException {
        if (KEYWORDS.contains(options.helperName)) {
            return "";
        }
        throw new UUFException("Cannot evaluate the variable/helper '" + options.helperName + "'.");
    }
}
