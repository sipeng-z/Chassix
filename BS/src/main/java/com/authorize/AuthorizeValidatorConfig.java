package com.authorize;


import com.authorize.annotation.Authorize;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author mamingbo
 *
 */
public class AuthorizeValidatorConfig {
	
	protected Set<String> modules;
	protected  Set<Boolean> ignores;
    protected Set<String> roles;
    protected Set<String> actions;
    protected Set<Expression> expressions = new LinkedHashSet<>();
   // protected Authorize.MOD mod;
    protected boolean       apiSupport;

   
    public AuthorizeValidatorConfig setApiSupport(boolean apiSupport) {
        this.apiSupport = apiSupport;
        return this;
    }

   
    public AuthorizeValidatorConfig setModules(Set<String> modules) {
        this.modules = modules;
        return this;
    }

   
    public AuthorizeValidatorConfig setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }

  
    public AuthorizeValidatorConfig setActions(Set<String> actions) {
        this.actions = actions;
        return this;
    }

    public AuthorizeValidatorConfig setIgnores(Set<Boolean> ignores) {
        this.ignores = ignores;
        return this;
    }


   
//    public AuthorizeValidatorConfig setMod(Authorize.MOD mod) {
//        this.mod = mod;
//        return this;
//    }

   
//    public AuthorizeValidatorConfig addExpression(String expression, String language) {
//        if (StringUtils.isNullOrEmpty(expression)) return this;
//        DynamicScriptEngine engine = DynamicScriptEngineFactory.getEngine(language);
//        try {
//            String id = "authorize.validator." + expression.hashCode();
//            engine.compile(id, expression);
//            expressions.add(new Expression(id, language));
//        } catch (Exception e) {
//            throw new AuthorizeForbiddenException("compile expression error", e, 403);
//        }
//        return this;
//    }

   
    public int hashCode() {
        return super.hashCode();
    }

    public Set<String> getModules() {
        if (modules == null) modules = new LinkedHashSet<>();
        return modules;
    }

    public Set<String> getRoles() {
        if (roles == null) roles = new LinkedHashSet<>();
        return roles;
    }

    public Set<String> getActions() {
        if (actions == null) actions = new LinkedHashSet<>();
        return actions;
    }

    public Set<Boolean> getIgnores() {
        if (ignores == null) ignores = new LinkedHashSet<>();
        return ignores;
    }

    public Set<Expression> getExpressions() {
        if (expressions == null) expressions = new LinkedHashSet<>();
        return expressions;
    }

    public boolean isApiSupport() {
        return true;
        //    return apiSupport;
    }

    public void setExpressions(Set<Expression> expressions) {
        this.expressions = expressions;
    }

//    public Authorize.MOD getMod() {
//        return mod;
//    }

   
    public boolean isEmpty() {
        return getModules().isEmpty() && getRoles().isEmpty() && getExpressions().isEmpty();
    }

    public AuthorizeValidatorConfig addAnnotation(Set<Authorize> authorizes) {
        Set<String> modules = new LinkedHashSet<>();
        Set<String> roles = new LinkedHashSet<>();
        Set<String> actions = new LinkedHashSet<>();
        Set<Boolean> ignores = new LinkedHashSet<>();
        authorizes.forEach(tmp -> {
            modules.addAll(Arrays.asList(tmp.permission()));
            roles.addAll(Arrays.asList(tmp.role()));
            actions.addAll(Arrays.asList(tmp.action()));
            ignores.addAll(Arrays.asList(tmp.ignore()));
          //  setMod(tmp.mod());
          //  addExpression(tmp.expression(), tmp.expressionLanguage());
          //  setApiSupport(tmp.api());
        });
        setActions(actions).setModules(modules).setRoles(roles).setIgnores(ignores);
        return this;
    }
    
    public static class Expression {
        private String id;
        private String language;

        public Expression() {
        }

        public Expression(String id, String language) {
            this.id = id;
            this.language = language;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}