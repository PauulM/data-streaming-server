package datastreaming.server.security.details;

import datastreaming.server.model.AppClient;
import datastreaming.server.model.ClientAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

public class ClientDetailsImpl implements ClientDetails {

    private AppClient appClient;

    private final String ROLE_PREFIX = "ROLE_";

    public ClientDetailsImpl(AppClient appClient) {
        this.appClient = appClient;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String getClientId() {
        return appClient.getClientName();
    }

    @Override
    public Set<String> getResourceIds() {
        return new HashSet<>();
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return appClient.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        HashSet<String> scopes = new HashSet<>();
        scopes.add("USE_APP");
        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        Set<String> authorizedGrantTypes = new HashSet<>();
        authorizedGrantTypes.add("password");
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (ClientAuthority authority : appClient.getClientAuthorities()){
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + authority.getName()));
        }
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 3600;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        //30 days
        return 2592000;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }
}
