package cn.zsxmlv.modules.sys.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: zs
 * @description: token
 * @date: 2019/1/24 12:56
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
