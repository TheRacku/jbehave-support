package org.jbehavesupport.core.internal.web.waitcondition;

import static org.apache.commons.lang3.StringUtils.startsWith;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

import org.jbehavesupport.core.web.WebWaitConditionContext;

import org.springframework.stereotype.Component;

@Component
public class HasUrlWebWaitCondition extends AbstractWebWaitCondition {

    @Override
    public boolean match(WebWaitConditionContext ctx) {
        return "@url".equals(ctx.getElement()) && startsWith(ctx.getCondition(), "has text ");
    }

    @Override
    public void evaluate(WebWaitConditionContext ctx) {
        wait(ctx).until(urlContains(ctx.getValue()));
    }

}
