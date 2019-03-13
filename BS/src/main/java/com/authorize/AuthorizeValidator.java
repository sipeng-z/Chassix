package com.authorize;

import com.core.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

public class AuthorizeValidator {

//	   @Autowired(required =true)

    @Autowired
    private AuthorizeService authorizeService = null;


    //@Autowired(required = false)
    // private Map<String, ExpressionScopeBean> expressionScopeBeanMap;

    // @Override
    public boolean validate(CurrentUserInfo currentUserInfo, Map<String, Object> param, AuthorizeValidatorConfig validatorConfig) {
//		        SimpleAuthorizeValidatorConfig validatorConfig = ((SimpleAuthorizeValidatorConfig) config);
//		        config.getClass();
//		        config.getModules();
//		        config.getActions();
//		        config.getRoles();

        Set<String> modules = validatorConfig.getModules();
        Set<String> roles = validatorConfig.getRoles();
        Set<String> actions = validatorConfig.getActions();
        Set<Boolean> ignores = validatorConfig.getIgnores();
//		        Set<SimpleAuthorizeValidatorConfig.Expression> expressions = validatorConfig.getExpressions();
//		        Authorize.MOD mod = validatorConfig.getMod();


        if (authorizeService == null) {
            return false;
        }
        System.out.println("ignores:" + ignores.size());
        if (!ignores.isEmpty()) {
            for (Boolean b : ignores) {
                if (b.equals(true)) {
                    return true;
                }
            }
        }

        boolean access = false;
        //验证模块
        if (!modules.isEmpty()) {
//		            if (mod == Authorize.MOD.AND) {
//		                access = modules.stream().allMatch(module -> user.hasAccessModuleAction(module, actions.toArray(new String[actions.size()])));
//		            }else {
//					access = modules.stream().anyMatch(module ->user.hasAccessModuleAction(module, actions.toArray(new String[actions.size()])));

            access = modules.stream().anyMatch(module -> authorizeService.hasAccessModuleAction(currentUserInfo.getUserId(), module, actions.toArray(new String[actions.size()])));

   
            //}
        }
//		        //验证角色
//		        if (!roles.isEmpty()) {
//		            if (mod == Authorize.MOD.AND)
//		                access = roles.stream().allMatch(user::hasAccessRole);
//		            else
//		                access = roles.stream().anyMatch(user::hasAccessRole);
//		        }
//		        //验证表达式
//		        if (!expressions.isEmpty()) {
//		            if (mod == Authorize.MOD.AND)
//		                access = expressions.stream().allMatch(expression -> {
//		                    DynamicScriptEngine engine = DynamicScriptEngineFactory.getEngine(expression.getLanguage());
//		                    Map<String, Object> var = getExpressionRoot(user);
//		                    var.putAll(param);
//		                    return StringUtils.isTrue(engine.execute(expression.getId(), var).get());
//		                });
//		            else
//		                access = expressions.stream().anyMatch(expression -> {
//		                    DynamicScriptEngine engine = DynamicScriptEngineFactory.getEngine(expression.getLanguage());
//		                    Map<String, Object> var = getExpressionRoot(user);
//		                    var.putAll(param);
//		                    return StringUtils.isTrue(engine.execute(expression.getId(), var).get());
//		                });
//		        }

        return access;
    }


//	    public Map<String, Object> getExpressionRoot(User users) {
//	        Map<String, Object> root = new HashMap<>();
//	        if (expressionScopeBeanMap != null)
//	            root.putAll(expressionScopeBeanMap);
//	        root.put("user", user);
//	        return root;
//	    }

    public AuthorizeValidatorConfig createConfig() {
        return new AuthorizeValidatorConfig();
    }

}
