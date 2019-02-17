package cn.zsxmlv.modules.sys.oauth2;

import cn.zsxmlv.common.exception.RRException;
import cn.zsxmlv.common.utils.GsonUtils;
import cn.zsxmlv.common.utils.RedisUtils;
import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import cn.zsxmlv.modules.sys.service.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: zs
 * @description: Shiro 认证
 * @date: 2019/1/24 12:37
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity userEntity = (SysUserEntity) principals.getPrimaryPrincipal();

        Integer userId = userEntity.getId();

        Set<String> permissions = shiroService.getUserPermissions(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.setStringPermissions(permissions);

        return info;
    }

    /**
     * 认证(登录时调用)
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        if (accessToken == null || "".equals(accessToken)) {
            throw new RRException("token失效,请重新登录");
        }

        SysUserEntity userEntity = shiroService.queryUserByToken(accessToken);

        if (userEntity == null) {
            throw new RRException("token失效,请重新登录");
        }

//        if (userEntity.getStatus() == 1) {
//            throw new RRException("账号已被禁用");
//        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userEntity, accessToken, getName());

        return info;
    }
}
